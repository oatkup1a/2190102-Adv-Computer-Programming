import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<String> itemList = new ArrayList<>();
    public ShoppingCart cart;
    public DiscountByPercentDecorator PercentDiscount;
    public DiscountByAmountDecorator AmountDiscount;
    public FreeDeliveryDecorator FreeDelivery;

    // Our plan is to replace the old cart with a new cart that has discount applied

    public double deliveryFee = 0.0;
    public double totalPrice = 0.0;
    public double netPrice = 0.0;

    public void addItem(String item) { // Add new item to itemList
        itemList.add(item);
    }

    public void addDeliveryFee(int fee) {
        deliveryFee += fee;
    }

    public double calculateTotal() {
        double total = 0;
        for (String item : itemList) {
            String[] items = item.split(":");
            total += Double.parseDouble(items[1]) *
                Double.parseDouble(items[2]);
        }
        totalPrice = total;
        return total;
    }

    public void FreeFee() { // If free delivery is applied, deliveryFee becomes 0.
        if (FreeDelivery != null) {
            deliveryFee = 0;
        }
    }

    public void setNetPrice() { // Initially set net price equal to total price and we will apply discount to it later
        if (netPrice==0) {
            calculateTotal();
            netPrice = totalPrice;
        }
    }

    public double getNetPrice() {
        setNetPrice();
        FreeFee();
        return netPrice + deliveryFee;
    }

    public void TransferCart() {
        itemList = cart.itemList;
        PercentDiscount = cart.PercentDiscount;
        AmountDiscount = cart.AmountDiscount;
        FreeDelivery = cart.FreeDelivery;
        deliveryFee = cart.deliveryFee;
        totalPrice = cart.totalPrice;
        netPrice = cart.netPrice;
    }
}

class DiscountByPercentDecorator extends ShoppingCart {

    public double percent;

    public DiscountByPercentDecorator(ShoppingCart cart, double percent) {
        this.cart = cart;
        cart.setNetPrice();
        TransferCart();

        if (PercentDiscount == null) {
            this.percent = percent;
            PercentDiscount = this;
            percent *= 0.01;
            netPrice *= (1-percent);
        }
    }
}

class DiscountByAmountDecorator extends ShoppingCart {
    public double Amount;
    public DiscountByAmountDecorator(ShoppingCart cart, double Amount) {
        this.cart = cart;
        cart.setNetPrice();
        TransferCart();

        if (AmountDiscount == null) {
            this.Amount = Amount;
            AmountDiscount = this;
            netPrice -= Amount;
        }
    }
}

class FreeDeliveryDecorator extends ShoppingCart {
    public FreeDeliveryDecorator(ShoppingCart cart) {
        this.cart = cart;
        cart.FreeDelivery = this;
        cart.setNetPrice();
        TransferCart();
    }
}