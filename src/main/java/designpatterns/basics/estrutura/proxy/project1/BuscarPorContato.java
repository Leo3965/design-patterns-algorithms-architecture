package designpatterns.basics.estrutura.proxy.project1;

public class BuscarPorContato {
    public static void main(String[] args) {
        ContatoCSV csv = new ContatoCSV();
        String nome = csv.buscarPor("leonardo@email.com");
        System.out.println("nome = " + nome);
    }
}
