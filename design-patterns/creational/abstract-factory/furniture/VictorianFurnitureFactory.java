package furniture;
public class VictorianFurnitureFactory implements FurnitureFactory {

    @Override
    public Chair createChair() {
        return new VictorianChair();
    }

    @Override
    public Table createTable() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createTable'");
    }

}
