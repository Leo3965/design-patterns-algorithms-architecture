package junit.projects.blog.negocio;

import junit.projects.blog.armazenamento.ArmazenamentoPost;
import junit.projects.blog.modelo.Notificacao;
import junit.projects.blog.modelo.Post;
import junit.projects.blog.exception.PostNaoEncontradoException;
import junit.projects.blog.exception.RegraNegocioException;
import junit.projects.blog.utilidade.ConversorSlug;

import java.time.OffsetDateTime;
import java.util.Objects;

public class CadastroPost {

    private final ArmazenamentoPost armazenamentoPost;
    private final CalculadoraGanhos calculadoraGanhos;
    private final GerenciadorNotificacao gerenciadorNotificacao;

    public CadastroPost(ArmazenamentoPost armazenamentoPost,
                        CalculadoraGanhos calculadoraGanhos,
                        GerenciadorNotificacao gerenciadorNotificacao) {
        this.armazenamentoPost = armazenamentoPost;
        this.calculadoraGanhos = calculadoraGanhos;
        this.gerenciadorNotificacao = gerenciadorNotificacao;
    }

    public Post criar(Post post) {
        Objects.requireNonNull(post);
        post.setSlug(criarSlug(post));
        post.setGanhos(this.calculadoraGanhos.calcular(post));
        post = armazenamentoPost.salvar(post);
        enviarNotificacao(post);
        return post;
    }

    public Post editar(Post postAtualizado) {
        Objects.requireNonNull(postAtualizado);

        Post post = this.armazenamentoPost.encontrarPorId(postAtualizado.getId())
                .orElseThrow(PostNaoEncontradoException::new);
        post.atualizarComDados(post);

        if (!post.isPago()) {
            post.setGanhos(this.calculadoraGanhos.calcular(post));
        }

        return armazenamentoPost.salvar(post);
    }

    public void remover(Long postId) {
        Objects.requireNonNull(postId);
        Post post = this.armazenamentoPost.encontrarPorId(postId)
                .orElseThrow(PostNaoEncontradoException::new);
        if (post.isPublicado()) {
            throw new RegraNegocioException("Um post publicado não pode ser removido");
        }
        if (post.isPago()) {
            throw new RegraNegocioException("Um post pago não pode ser removido");
        }
        this.armazenamentoPost.remover(postId);
    }

    private String criarSlug(Post post) {
        return ConversorSlug.converterJuntoComCodigo(post.getTitulo());
    }

    private void enviarNotificacao(Post post) {
        Notificacao notificacao = new Notificacao(
                OffsetDateTime.now(),
                "Novo post criado -> " + post.getTitulo()
        );
        this.gerenciadorNotificacao.enviar(notificacao);
    }
}
