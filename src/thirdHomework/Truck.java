package thirdHomework;

public class Truck extends Car {
    private boolean trailer;

    public boolean isTrailer() {
        return trailer;
    }

    public void setTrailer(boolean trailer) {
        this.trailer = trailer;
    }

    @Override
    public String toString() {
        return super.toString() + " это грузовой автомобиль " + (trailer ? "с прицепом" : "без прицепа");
    }

    @Override
    public int acceptVisitor(PriceVisitor priceVisitor) {
        return priceVisitor.visit(this);
    }
}
