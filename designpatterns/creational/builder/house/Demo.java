package designpatterns.creational.builder.house;

public class Demo {
    public static void main(String[] args) {
        var house = new House();
        var builder = new HouseBuilder(house);

        builder.buildFancyStates();
        builder.buildGarage();

        builder.reset();

        System.out.println(house.toString());
    }
}
