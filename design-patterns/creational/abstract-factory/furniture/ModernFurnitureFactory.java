package furniture;
public class ModernFurnitureFactory implements FurnitureFactory {

    @Override
    public Chair createChair() {
        return new ModernChair();
    }

    @Override
    public Table createTable() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createTable'");
    }

}
