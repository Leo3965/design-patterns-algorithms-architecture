package junit.tdd.projects.vendas.notificador;

import junit.tdd.projects.vendas.model.Pedido;

public class NotificadorSms implements Notificador {

    @Override
    public void enviar(Pedido pedido) {
        System.out.println("enviando sms...");
    }
}
