public class InsufficientFundsExceptions extends Exception {

    private double shortfall;

    public InsufficientFundsExceptions(String message, double shortfall) {

        super(message);
        this.shortfall = shortfall;

    }

    public double getShortfall() {

        return shortfall;

    }

}