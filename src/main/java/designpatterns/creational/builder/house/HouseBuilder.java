package designpatterns.creational.builder.house;

public class HouseBuilder {
    private House house;

    public HouseBuilder(House house) {
        this.house = house;
    }

    void reset() {
        this.house = null;
    }

    void buildGarage() {
        house.setGarage(true);
    }

    void buildFancyStates() {
        house.setFancyStates(true);
    }

    void buildGarden() {
        house.setGarden(true);
    }

    void buildSwimmingPool() {
        house.setSwimmingPool(true);
    }

}
