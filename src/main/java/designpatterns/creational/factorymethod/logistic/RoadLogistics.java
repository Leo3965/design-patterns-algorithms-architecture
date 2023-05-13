package designpatterns.creational.factorymethod.logistic;

public class RoadLogistics extends Logistics {

    @Override
    protected Transport createTransport() {
        return new Truck();
    }

}
