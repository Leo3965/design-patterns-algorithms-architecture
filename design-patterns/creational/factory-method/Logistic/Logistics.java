public abstract class Logistics {
    
    protected void planDelivery() {
        System.out.println("Planning how to delivey cargo!");
    }

    protected abstract Transport createTransport();
}