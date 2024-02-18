You are tasked with implementing an object-oriented program that demonstrates the concepts of inheritance, abstraction, and polymorphism in the context of geometric shapes. Your goal is to create an abstract superclass called Shape, from which three subclasses, `Square`, `Rectangle`, and `Circle`, will inherit. Each of these classes should implement the abstract method `getArea()` and `printDetails()`, and you should also add specific methods to each class.

## Class Details:

**1. `Shape` (Abstract Superclass):**

* Create an abstract class named `Shape`.
* Include two abstract methods, namely `getArea()` and `printDetails()`, with no implementation.
* Define an instance variable (protected) as `String` to hold the shape's color.
* Implement a parameterized constructor to initialize the color.
* Include a method getColor() to retrieve the color.

**2. `Square` (Subclass of Shape):**

* Create a class named `Square` that extends Shape.
* Include a private instance variable to hold the side length of the square.
* Implement a parameterized constructor to initialize the side length and color.
* Implement the `getArea()` method to calculate and return the area of the square.
* Include a method `printDetails()` to display the color, side length, and area of the square.

**3. `Rectangle` (Subclass of Shape):**

* Create a class named `Rectangle` that extends `Shape`.
* Include private instance variables (`width`,`height`) to hold the `width` and `height` of the rectangle.
* Implement a parameterized constructor to initialize the `width`, `height`, and `color`.
* Implement the `getArea()` method to calculate and return the area of the rectangle.
* Include a method `printDetails()` to display the `color`, `width`, `height`, and `area` of the rectangle.

**4. `Circle` (Subclass of Shape):**

* Create a class named `Circle` that extends `Shape`.
* Include a private instance variable to hold the `radius` of the circle.
* Implement a parameterized constructor to initialize the `radius` and `color`.
* Implement the `getArea()` method to calculate and return the area of the circle.
* Include a method `printDetails()` to display the `color`, `radius`, and `area` of the circle.

**Tasks:**

1. Implement the `Shape`, `Square`, `Rectangle`, and `Circle` classes as per the provided specifications in one file, `Lab4_XXXXXXXXXX.java` where `XXXXXXXXXX` is your id.
2. Write a suitable testing program that creates an array of five instances of Shapes. The first two elements are `Square`, next two elements are `Rectangle` and the last element is a `Circle`. Please sets appropriate values, and displays their details including colors, dimensions, and areas.
3. Add a method `resize(double factor)` in each subclass that scales the shape by the given factor and updates its dimensions.


## Expected Output

```
Shape: Square
Color: Red
Side Length: 5.0
Area: 25.0
----------------------
Shape: Square
Color: Blue
Side Length: 3.0
Area: 9.0
----------------------
Shape: Rectangle
Color: Green
Width: 4.0
Height: 6.0
Area: 24.0
----------------------
Shape: Rectangle
Color: Yellow
Width: 2.0
Height: 8.0
Area: 16.0
----------------------
Shape: Circle
Color: Orange
Radius: 7.0
Area: 153.93804002589985
----------------------
```
