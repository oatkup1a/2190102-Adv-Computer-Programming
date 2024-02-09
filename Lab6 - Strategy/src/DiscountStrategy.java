public interface DiscountStrategy {
    double getDiscount(double initPrice);
}

class PercentageDiscountStrategy implements DiscountStrategy {

    int percentage;

    @Override
    public double getDiscount(double initPrice) {
        double disPrice = initPrice * percentage / 100;
        return disPrice;
    }

    public PercentageDiscountStrategy(int percentage) {
        this.percentage = percentage;
    }

}

class FixedDiscountStrategy implements DiscountStrategy {
    
    int fixedDiscounted;

    @Override
    public double getDiscount(double initPrice) {
        double disPrice = initPrice - fixedDiscounted;
        return disPrice;
    }

    public FixedDiscountStrategy(int fixedDiscounted) {
        this.fixedDiscounted = fixedDiscounted;
    }
}

class SampleDiscountStrategy implements DiscountStrategy {

    @Override
    public double getDiscount(double initPrice) {
        return initPrice;
    }
}

