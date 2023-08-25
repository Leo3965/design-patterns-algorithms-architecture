package library.date;

public class Date {
    public static void main(String[] args) {
        var hoje = new java.util.Date();
        System.out.println(hoje);
        System.out.println("Nilisegundos desde 1 de Jan 1970 " + hoje.getTime());
        System.out.println(hoje.getDate()); // is deprecated
    }
}
