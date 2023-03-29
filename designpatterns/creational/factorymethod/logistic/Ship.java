package designpatterns.creational.factorymethod.logistic;

public class Ship implements Transport {

    @Override
    public void deliver() {
        System.out.println("Transporting by sea!");
    }

}
