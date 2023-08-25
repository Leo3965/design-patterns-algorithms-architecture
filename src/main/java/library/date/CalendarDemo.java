package library.date;

import java.util.Calendar;

public class CalendarDemo {
    public static void main(String[] args) {
        var calendar = Calendar.getInstance(); //singleton
        var ano = calendar.get(Calendar.YEAR);
        var mes = calendar.get(Calendar.MONTH); // starts at 0
        var dia = calendar.get(Calendar.DAY_OF_MONTH);
        var hora = calendar.get(Calendar.HOUR_OF_DAY);
        var minutos = calendar.get(Calendar.MINUTE);
        var segundos = calendar.get(Calendar.SECOND);

        System.out.printf("Hoje é : %02d/%02d/%02d %02d:%02d:%02d \n", dia, (mes + 1), ano, hora, minutos, segundos);

        calendar.add(Calendar.DAY_OF_MONTH, 7);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
    }
}
