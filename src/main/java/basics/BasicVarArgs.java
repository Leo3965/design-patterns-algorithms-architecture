package basics;

import java.util.Arrays;

public class BasicVarArgs {

    public static void main(String[] args) {
        Fatura fatura = new Fatura();
        fatura.numero = 123;
        fatura.valorTotal = 1_293.55;

        ServicoDeCobranca servicoDeCobranca = new ServicoDeCobranca();

        servicoDeCobranca.pagar(fatura, "joao@algaworks.com", "maria@algaworks.com");
    }

    static class Fatura {
        int numero;
        double valorTotal;
    }

    static class ServicoDeCobranca {
        void pagar(Fatura fatura, String... emailsCobranca) {
            System.out.println(Arrays.toString(emailsCobranca));
            System.out.printf(
                    "Fatura %d, no valor total de R$%.2f, foi paga!%n",
                    fatura.numero,
                    fatura.valorTotal
            );

            for (String email : emailsCobranca) {
                System.out.printf(
                        "Fatura %d enviada para %s%n",
                        fatura.numero, email
                );
            }
        }

    }
}



