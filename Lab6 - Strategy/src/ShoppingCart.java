class ShoppingCart {
    private Item[] items;
    private DiscountStrategy strategy;

    public ShoppingCart() {
        items = new Item[0];
        strategy = new SampleDiscountStrategy(); // Default strategy
    }

    public void addItem(Item item) {
        // Extend the array to accommodate the new item
        Item[] newItems = new Item[items.length + 1];
        for(int i=0;i<items.length;i++)
            newItems[i] = items[i];
        newItems[items.length] = item;
        items = newItems;
    }

    public double calculateTotal() {
        double totalPrice = 0;
        for(int i=0;i<items.length;i++) {
            totalPrice += items[i].getPrice() * items[i].getQuantity();
            }
        return strategy.getDiscount(totalPrice);
    }

    public void setStrategy(DiscountStrategy strategy) {
        this.strategy = strategy;
    }

    public void GetItems() {
        for (int i= 0; i < items.length;i++) {
            System.out.println("(" + (i+1) + ") " + items[i].getName() + "|" + items[i].getQuantity() + "|" + items[i].getPrice());
        }
    }
}