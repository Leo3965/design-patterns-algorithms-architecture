package designpatterns.creational.factorymethod.logistic;

public class Main {
    public static void main(String[] args) {
        // var logistics = new designpatterns.creationall.factorymethod.logistic.RoadLogistics();
        var logistics = new SeaLogistics(); // Factory
        var transport = logistics.createTransport();  // Product
        transport.deliver();
    }
}
