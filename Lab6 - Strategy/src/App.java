public class App {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        Item item1 = new Item("Widget", 3, 10.99);
        Item item2 = new Item("Gadget", 2, 19.99);
        Item item3 = new Item("Padthai", 4, 49.99);
        Item item4 = new Item("Krapao", 2, 34.99);
        cart.addItem(item1);
        cart.addItem(item2);
        cart.addItem(item3);
        cart.addItem(item4);

        System.out.println("===== Shopping Cart =====\n");
        System.out.println("(#) Item|Quantity|Price\n");
        cart.GetItems();
        System.out.println("\n> Total Price: " + cart.calculateTotal() + "\n");
        // Your cart should set different discount strategies and display the total cost after discount. 
        System.out.println("(!) Only one discount method can be chosen at a time. Possible methods are shown below. (!)\n");
        cart.setStrategy(new SampleDiscountStrategy());
        System.out.println("Sample Discounted Price: " + cart.calculateTotal());
        cart.setStrategy(new PercentageDiscountStrategy(50));
        System.out.println("Percentage Discounted Price: " + cart.calculateTotal() + " (-50%)");
        cart.setStrategy(new FixedDiscountStrategy(20));
        System.out.println("Fixed Discounted Price: " + cart.calculateTotal() + " (-20)");
        System.out.println("\n=========================");

        };
}