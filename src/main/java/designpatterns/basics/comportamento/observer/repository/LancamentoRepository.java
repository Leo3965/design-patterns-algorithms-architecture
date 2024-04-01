package designpatterns.basics.comportamento.observer.repository;

import designpatterns.basics.comportamento.observer.model.Lancamento;
import designpatterns.basics.comportamento.observer.model.LancamentoBuilder;
import designpatterns.basics.comportamento.observer.model.TipoLancamento;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class LancamentoRepository {
    public List<Lancamento> todosVencidos() {
        // Faz consulta no banco buscando lançamentos vencidos
        Lancamento lancamento1 = LancamentoBuilder.crairLancamento()
                .comPessoa("João Silva", "joao@email.com", "(11)9999-8888")
                .comDescricao("Mesa tabaco MDF")
                .comValor(new BigDecimal("1225.45"))
                .comDataVencimento(LocalDate.now())
                .doTipo(TipoLancamento.DESPESA)
                .criar();

        Lancamento lancamento2 = LancamentoBuilder.crairLancamento()
                .comPessoa("Renato Santos", "renato@email.com", "(21)8888-9999")
                .comDescricao("Armário MDF 3.00 x 2x40")
                .comValor(new BigDecimal("3200.00"))
                .comDataVencimento(LocalDate.now())
                .doTipo(TipoLancamento.DESPESA)
                .criar();

        return Arrays.asList(lancamento1, lancamento2);
    }
}

