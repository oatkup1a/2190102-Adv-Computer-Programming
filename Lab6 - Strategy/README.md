## **Task 1: Add more methods to PythonList, SortedList, and Unsorted List**

There are some methods which should be added to the classes we have done during the lecture class. All of them are listed below:

1. `append(int v)` for unsorted list.
```
    public void append(int v) {
        int[] a = new int[array.length+1];
        for(int i=0;i<array.length;i++) {
            a[i] = array[i];
        }
        a[array.length]=v;
        array=a;
    }
```
2. `append(int v)` for sorted list.
```
    public void append(int v) {
        int[] a = new int[array.length+1];
        int i = 0;
        while(v > array[i]) {
            a[i] = array[i];
            i++;
        }
        a[i++] = v;
        for(int j=i-1;j<array.length;j++) {
            a[i++] = array[j];
        }
        array=a;
    }   
```
3. `contains(int v)` for ***any*** lists.
```
    public boolean contains(int v) {
        for(int a: array) {
            if(a==v) return true;
        }
        return false;
    }
```
4. `contains(int v)` for ***sorted*** lists.
```
    public boolean contains(int v) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            // If the middle element is equal to v, return true
            if (array[mid] == v) {
                return true;
            }

            // If v is less than the middle element, search in the left half
            if (array[mid] > v) {
                right = mid - 1;
            }
            // If v is greater than the middle element, search in the right half
            else {
                left = mid + 1;
            }
        }

        // If the loop finishes without finding v, return false
        return false;
    }
```
5. toString() for both kinds of llist
```
    public String toString() {
        if(array.length == 0) return "[]";
        String out = "[";
        for(int a:array) {
            out += a+", ";
        }
        out = out.substring(0,out.length()-2)+"]";
        return out;
    }
```
Please add all of them to suitable class(es) and make sure that the testMethod below gives the correct results.

```
      int[] d1 = {3,8,2,10,4,5};
      SortedList l1 = new SortedList(d1);
      System.out.println(l1.findMax());
      System.out.println(l1.findMin());
      System.out.println(l1.contains(10));
      System.out.println(l1.contains(7));
      System.out.println(l1);
      l1.append(7);
      System.out.println(l1.contains(7));
      System.out.println(l1);
      int[] d2 = {3,8,2,10,4,5};
      UnsortedList l2 = new UnsortedList(d2);
      System.out.println(l2.findMax());
      System.out.println(l2.findMin());
      System.out.println(l2.contains(10));
      System.out.println(l2.contains(7));
      System.out.println(l2);
      l2.append(7);
      System.out.println(l2.contains(7));
      System.out.println(l2);
```
Expected Result
```
10
2
true
false
[2, 3, 4, 5, 8, 10]
true
[2, 3, 4, 5, 7, 8, 10]
10
2
true
false
[3, 8, 2, 10, 4, 5]
true
[3, 8, 2, 10, 4, 5, 7]
```

## **Task 2: Apply Strategy Pattern to a new problem**

**Objective:** In this task, you will implement the strategy pattern to enhance the functionality of a simple shopping cart system. The goal is to allow the cart to apply different discount strategies to items added to it.

**Background:** You are provided with the basic structure of a shopping cart and a sample discount strategy. Your task is to extend the system to support multiple discount strategies and allow users to apply different strategies at runtime.

**Instructions:**

1. **Setup:** The starter code provided below, which includes the following classes:
   - `Item`: Represents an item that can be added to the shopping cart. Each item is represented as a string containing the item name, the number of items, and the price of each item, separated by a vertical line "|". For example, `"Widget|3|10.99"` represents 3 widgets at a price of $10.99 each.
   - `ShoppingCart`: Represents the shopping cart and currently supports adding items and calculating the total cost.

2. **Implement Additional Discount Strategies:** Create two new discount strategy classes that implement the `DiscountStrategy` interface,
  * `PercentageDiscountStrategy` (for example 10% discount or 20% discount, the percent should be able to input from by a parameter in the method)
  *  `FixedDiscountStrategy` (for example 5$ discount or 10$ discount, the amount should be able to input from by a parameter in the method).

3. **Integrate Discount Strategies:** Modify the `ShoppingCart` class to allow users to set a discount strategy. Implement a setter method to set the current discount strategy for the cart.

4. **Apply Discounts:** Modify the `calculateTotal()` method in the `ShoppingCart` class to apply the chosen discount strategy when calculating the total cost.

5. **Test the System:** Create a test program that demonstrates the functionality of the shopping cart system. In the test program:
   - Create a shopping cart.
   - Add various items to the cart (in the specified format).
   - Set different discount strategies on the cart.
   - Calculate and display the total cost with different discount strategies.

## **Starter code**


`Item` class represents an item in the shopping cart
```
class Item {
    private String name;
    private int quantity;
    private double price;

    public Item(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }
}
```

`ShoppingCart` class represents the shopping cart

```
class ShoppingCart {
    private Item[] items;

    public ShoppingCart() {
        items = new Item[0];
        discountStrategy = new SampleDiscountStrategy(); // Default strategy
    }

    public void addItem(Item item) {
        // Extend the array to accommodate the new item
        Item[] newItems = new Item[items.length + 1];
        for(int i=0;i<items.length;i++)
            newItems[i] = items
        newItems[items.length] = item;
        items = newItems;
    }
}
```
An example of App class
```
public class App {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        Item item1 = new Item("Widget", 3, 10.99);
        Item item2 = new Item("Gadget", 2, 19.99);

        cart.addItem(item1);
        cart.addItem(item2);

        // Your cart should set different discount strategies and display the total cost after discount.
    }
}
```
