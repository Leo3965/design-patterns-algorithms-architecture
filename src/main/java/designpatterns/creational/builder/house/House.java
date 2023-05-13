package designpatterns.creational.builder.house;

public class House {
    private boolean garage;
    private boolean fancyStates;
    private boolean garden;
    private boolean swimmingPool;

    public House() {

    }

    public boolean isGarage() {
        return garage;
    }

    public void setGarage(boolean garage) {
        this.garage = garage;
    }

    public boolean isFancyStates() {
        return fancyStates;
    }

    public void setFancyStates(boolean fancyStates) {
        this.fancyStates = fancyStates;
    }

    public boolean isGarden() {
        return garden;
    }

    public void setGarden(boolean garden) {
        this.garden = garden;
    }

    public boolean isSwimmingPool() {
        return swimmingPool;
    }

    public void setSwimmingPool(boolean swimmingPool) {
        this.swimmingPool = swimmingPool;
    }

    @Override
    public String toString() {
        return "House {" +
                "garage=" + garage +
                ", fancyStates=" + fancyStates +
                ", garden=" + garden +
                ", swimmingPool=" + swimmingPool +
                '}';
    }
}
