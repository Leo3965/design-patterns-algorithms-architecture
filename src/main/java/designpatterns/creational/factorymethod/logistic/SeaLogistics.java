package designpatterns.creational.factorymethod.logistic;

public class SeaLogistics extends Logistics {

    @Override
    protected Transport createTransport() {
        return new Ship();
    }

}
