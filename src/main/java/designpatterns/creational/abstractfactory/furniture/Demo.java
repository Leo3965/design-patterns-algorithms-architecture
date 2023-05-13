package designpatterns.creational.abstractfactory.furniture;
import java.util.Scanner;

public class Demo {
    static FurnitureFactory factory;

    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        var option = scan.nextInt();

        if (option == 0) {
            factory = new ModernFurnitureFactory();
        } else {
            factory = new VictorianFurnitureFactory();
        }

        var chair = factory.createChair();
        chair.sitOn();

        scan.close();
    }
}
