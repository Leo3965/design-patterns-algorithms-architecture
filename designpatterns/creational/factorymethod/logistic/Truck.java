package designpatterns.creational.factorymethod.logistic;

public class Truck implements Transport {

    @Override
    public void deliver() {
        System.out.println("Transporting by land!");
    }

}
