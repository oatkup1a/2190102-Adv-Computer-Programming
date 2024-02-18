## Exploring Classes in Java - Dolls

Objective:
1. Practice creating classes, using inheritance, 2. working with class attributes, methods, and method specialization in Java.

Task 1: Creating the `Doll` Classes in One File
1. Define a class named Doll.
2. Inside the Doll class's constructor (Doll()), define member variables for name (String), material (String), and price (float). All of them are `private`.
3. Add a method named toString() to the Doll class that returns the doll's name.
4. Add a method named play() that is void type (no return statement). This method just prints `"I don't know. How to play"`.

Task 2: Creating Subclasses
1. Subclass `Barbie`
  * Define a class named `Barbie` that inherits from the Doll class (using keyword `extends`).
  * Override the play() method to print: `"Barbie sings: I'm a Barbie girl in a Barbie world!"`
2. Subclass `TeddyDoll`
  * Define a class named `TeddyDoll` that inherits from the `Doll` class.
  * Override the `play()` method to print: `"Teddy Doll says: Hug me!"`
3. Subclass `PorcelainDell`
  * Define a class named PorcelainDoll that inherits from the Doll class.
  * Override the play() method to print: "Porcelain Doll is delicate, be gentle!"

Task 3: Adding Methods
1. In the `Doll` class
  * Add a method named `displayInfo()` that prints out the doll's name, material, and price.
  * Add a method named isFragile() that checks if the doll's material is "Porcelain" or "Glass" and returns `true` if it is, otherwise `false`.

Test your program by running the App.java file in the cell below.

// This is the App.java file

```
public class App {
    public static void main(String[] args) {
        Doll[] dolls = new Doll[5];

        dolls[0] = new Barbie("Barbie1", 29.99f);
        dolls[1] = new Barbie("Barbie2", 34.99f);
        dolls[2] = new TeddyDoll("Teddy", 19.99f);
        dolls[3] = new PorcelainDoll("Porcelain1", 49.99f);
        dolls[4] = new PorcelainDoll("Porcelain2", 59.99f);

        for (Doll doll : dolls) {
            doll.displayInfo();
            if (!doll.isFragile()) {
                doll.play();
            } else {
                System.out.println("This doll is fragile. Not playing with it.");
            }
            System.out.println();
        }
    }
}
```


Your output should be

```
Name: Barbie1
Material: Plastic
Price: $29.99
Barbie sings: I'm a Barbie girl in a Barbie world!

Name: Barbie2
Material: Plastic
Price: $34.99
Barbie sings: I'm a Barbie girl in a Barbie world!

Name: Teddy
Material: Fabric
Price: $19.99
Teddy Doll says: Hug me!

Name: Porcelain1
Material: Porcelain
Price: $49.99
This doll is fragile. Not playing with it.

Name: Porcelain2
Material: Porcelain
Price: $59.99
This doll is fragile. Not playing with it.
```
