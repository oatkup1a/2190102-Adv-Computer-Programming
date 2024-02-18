public class App {
    public static void main(String[] args) throws Exception {
        ShoppingCart cart = new ShoppingCart();

        cart.addItem("Uddy:2:50.0"); // Total price is now $100
        cart.addItem("Arm:3:20.0"); // Total price is now $160
        cart.addDeliveryFee(100); // Delivery fee is $100

        // Net price must be now at $270

        cart = new DiscountByPercentDecorator(cart, 20.0); // Apply 20% discount, net is now 160x(1-0.2)+100 = $228
        cart = new DiscountByAmountDecorator(cart, 30); // Apply $30 discount, net is now $198
        cart = new FreeDeliveryDecorator(cart); // Free delivery, net is $98 (-$100 fee and Apply 20% and $30 discount)
        cart = new DiscountByAmountDecorator(cart, 10); // Since $30 amount discount has been previous applied, this should be ignored

        double total = cart.calculateTotal();
        double netPrice = cart.getNetPrice();
        System.out.println("Total Price: $" + total); // Expected output: Total Price: $160.0
        System.out.println("Net Price: $" + netPrice); // Expected output: Net Price: $98.0
    }
}
