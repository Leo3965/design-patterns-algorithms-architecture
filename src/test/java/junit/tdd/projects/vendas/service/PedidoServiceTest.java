package junit.tdd.projects.vendas.service;

import junit.tdd.projects.vendas.builder.PedidoBuilder;
import junit.tdd.projects.vendas.model.Pedido;
import junit.tdd.projects.vendas.model.StatusPedido;
import junit.tdd.projects.vendas.notificador.NotificadorEmail;
import junit.tdd.projects.vendas.notificador.NotificadorSms;
import junit.tdd.projects.vendas.repository.Pedidos;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PedidoServiceTest {
    private PedidoService service;
    private Pedidos banco = Mockito.mock(Pedidos.class);

    @Mock
    private NotificadorEmail notificadorEmail;

    @Mock
    private NotificadorSms notificadorSms;

    private Pedido pedido;

    @BeforeEach
    void before() {
        pedido = new PedidoBuilder()
                .comValor(100)
                .para("Leonardo", "leo@email.com", "111-222")
                .construir();

        service = new PedidoService(banco, List.of(notificadorEmail, notificadorSms));
    }

    @Test
    void deveCalcularOImposto() {
        double imposto = service.lancar(pedido);
        assertThat(imposto).isEqualTo(10);
    }

    @Test
    void deveSalvarPedidoNoBancoDeDados() {
        service.lancar(pedido);
        verify(banco).guardar(pedido);
    }

    @Test
    void deveNotificarPorEmail() {
        service.lancar(pedido);
        verify(notificadorEmail).enviar(pedido);
    }

    @Test
    void deveNotificarPorSms() {
        service.lancar(pedido);
        verify(notificadorSms).enviar(pedido);
    }

    @Test
    void devePagarPedidoPendente() {
        Long codigoPedido = 135L;
        var pedidoPendente = new PedidoBuilder()
                .comStatus(StatusPedido.PENDENTE)
                .construir();

        when(banco.buscarPeloCodigo(codigoPedido)).thenReturn(pedidoPendente);

        Pedido pedidoPago = service.pagar(codigoPedido);
        assertThat(pedidoPago.getStatus())
                .isEqualTo(StatusPedido.PAGO);
    }

    @Test
    void deveNegarPagamento() {
        Long codigoPedido = 135L;
        var pedidoPago = new PedidoBuilder()
                .comStatus(StatusPedido.PAGO)
                .construir();

        when(banco.buscarPeloCodigo(codigoPedido)).thenReturn(pedidoPago);

        Assertions
                .assertThatThrownBy(() -> service.pagar(codigoPedido))
                .isInstanceOf(PedidoInvalidoException.class);
    }
}