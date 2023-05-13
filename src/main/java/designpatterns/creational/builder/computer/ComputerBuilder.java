package designpatterns.creational.builder.computer;

//Builder Class
public class ComputerBuilder {

    // required parameters
    private String HDD;
    private String RAM;

    // optional parameters
    private boolean isGraphicsCardEnabled;
    private boolean isBluetoothEnabled;

    public ComputerBuilder(String hdd, String ram) {
        this.HDD = hdd;
        this.RAM = ram;
    }

    public ComputerBuilder graphicsCardEnabled(boolean isGraphicsCardEnabled) {
        this.isGraphicsCardEnabled = isGraphicsCardEnabled;
        return this;
    }

    public ComputerBuilder bluetoothEnabled(boolean isBluetoothEnabled) {
        this.isBluetoothEnabled = isBluetoothEnabled;
        return this;
    }

    public Computer build() {
        return new Computer(this);
    }

    public String getHDD() {
        return this.HDD;
    }

    public String getRAM() {
        return this.RAM;
    }

    public boolean isGraphicsCardEnabled() {
        return this.isGraphicsCardEnabled;
    }

    public boolean isBluetoothEnabled() {
        return this.isBluetoothEnabled;
    }
}
