package pl.sda.springproject.exception;

public class TooOldCarException extends RuntimeException{
    private final int productionYear;
    public TooOldCarException(String message, int productionYear) {
        super(message);
        this.productionYear = productionYear;
    }

    public int getProductionYear() {
        return productionYear;
    }
}
