## Decorator Pattern

---

## Lab Sheet: Building a Shopping Cart with Decorator Pattern

### Objective

The objective of this lab is to design and implement a shopping cart class that allows customers to add items to their cart, apply various types of coupons for discounts, and calculate the total cost, including delivery fees.

### Requirements

1. Create a `ShoppingCart` class that stores items in an `ArrayList` of `String`. Each item in the cart should be represented as a string in the format: `"ItemName:Quantity:Price"` where `ItemName` is the name of the item, `Quantity` is the number of items, and `Price` is the price of one item.

2. Implement the `calculateTotal()` method in the `ShoppingCart` class, which calculates the total price of all items in the cart.

3. Implement the `addDeliveryFee(int fee)` method in the `ShoppingCart` class. This method takes an integer `fee` as an input parameter and adds the specified delivery fee to the cart's total cost. The delivery fee should be added before applying any discounts.

4. Implement three types of coupons as decorators:
    - `DiscountByPercentDecorator`: This decorator should apply a discount by a certain percentage to the total cost before adding the delivery fee. It can be applied only once of this type but can be applied along with other types of coupons.
    - `DiscountByAmountDecorator`: This decorator should apply a discount by a specified amount to the total cost before adding the delivery fee. It can be applied only once of this type but can be applied along with other types of coupons.
    - `FreeDeliveryDecorator`: This decorator should provide free delivery with no additional cost. It can be applied only once of this type but can be applied along with other types of coupons.
    
    - This modification allows multiple types of coupons to be applied together while ensuring that each specific type of coupon is applied only once. If a user accidentally applies the same type of coupon more than once, the system will simply ignore the redundant application without displaying an error or halting the program.

5. Implement a `getNetPrice()` method in the `ShoppingCart` class, which calculates the net price after applying all the coupons. This method should return the total price after subtracting all discounts.

6. Create a test program to demonstrate the functionality of the `ShoppingCart` class. You should add items to the cart, apply different coupons, and calculate and display the total and net prices.

### **Example**

Here's an example of how to use the `ShoppingCart` class with the decorator pattern:

```java
// Create a shopping cart
ShoppingCart cart = new ShoppingCart();

// Add items to the cart
cart.addItem("Item1:2:50.0"); // net price is 100.0
cart.addItem("Item2:1:30.0"); // net price is 130.0

// Add delivery fee
cart.addDeliveryFee(10); // Add a $10 delivery fee

// Apply coupons using decorators
cart = new DiscountByPercentDecorator(cart, 10.0); // Apply a 10% discount, net price should be 127.0 (130*0.9+10)
cart = new FreeDeliveryDecorator(cart); // Apply free delivery, net price now is 117.0

// Calculate and display the total price and net price
double total = cart.calculateTotal();
double netPrice = cart.getNetPrice();
System.out.println("Total Price: $" + total);
System.out.println("Net Price: $" + netPrice);
```


## Observer Pattern
---

## Lab Sheet: Implementing the Observer Pattern for Door Control

### Objective

The objective of this lab is to design and implement a system that allows multiple doors to be controlled individually or collectively through a central control center. The system will use the Observer pattern to notify doors when they should be opened or closed.

### Requirements

1. Create a `Door` class that represents an individual door. The `Door` class should include the following methods:
    - `open()`: Opens the door and prints "Door [DoorName] opened," where `[DoorName]` is the name of the door.
    - `close()`: Closes the door and prints "Door [DoorName] closed."

2. Create a `ControlCenter` class that acts as an `Observable`. The `ControlCenter` should include the following methods:
    - `openAllDoors()`: Notifies all doors to open.
    - `closeAllDoors()`: Notifies all doors to close.

3. Implement the Observer pattern by creating an `Observer` interface with methods to update the doors (e.g., `updateDoorOpen(Door door)` and `updateDoorClose(Door door)`).

4. [already done for your] Create a `Main` class to demonstrate the system. In the `Main` class, do the following:
    - Create three `Door` objects (e.g., D1, D2, D3) with unique names.
    - Create a `ControlCenter` object to manage the doors.
    - Register each door with the control center as an observer.
    - Manually open and close the doors, and observe the system's output.
    - Use the control center to open and close all doors, and observe the system's output.
    - Add a new door (D4) and register it with the control center.

### Example

Here's an example of how the system should work:

```java
// Create Door objects
Door D1 = new Door("D1");
Door D2 = a new Door("D2");
Door D3 = new Door("D3");

// Create a ControlCenter object
ControlCenter controlCenter = new ControlCenter();

// Register doors with the control center
controlCenter.registerObserver(D1);
controlCenter.registerObserver(D2);
controlCenter.registerObserver(D3);

// Manually open and close doors
D1.open();
D2.open();
D1.close();

// Use the control center to open and close all doors
controlCenter.openAllDoors();
controlCenter.closeAllDoors();

// Add a new door and register it with the control center
Door D4 = new Door("D4");
controlCenter.registerObserver(D4);
controlCenter.openAllDoors();
```

The expected output for the example:

```
Door D1 opened
Door D2 opened
Door D1 closed
Door D1 opened
Door D2 opened
Door D3 opened
Door D1 closed
Door D2 closed
Door D3 closed
Door D1 opened
Door D2 opened
Door D3 opened
Door D4 opened
```
