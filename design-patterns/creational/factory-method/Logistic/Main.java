public class Main {
    public static void main(String[] args) {
        // var logistics = new RoadLogistics();
        var logistics = new SeaLogistics(); // Factory
        var transport = logistics.createTransport();  // Product
        transport.deliver();
    }
}
