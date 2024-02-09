abstract class Shape {
    public abstract double getArea();
    public abstract void printDetails();
    public abstract void resize(double factor);
    protected String color;
    public Shape(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}

class Square extends Shape {
    private double length;
    public Square(double length, String color) {
        super(color);
        this.length = length;
    }

    
    public double getArea() {
        return length * length;
    }

    public void printDetails() {
        System.out.println("Shape: Square"
         + "\n" + "Color: " + getColor() + "\n" +
          "Side Length: " + length + "\n" 
          + "Area: " + getArea());
    }

    public void resize(double factor) {
        length = length * factor;
    }
}

class Rectangle extends Shape {
    private double width;
    private double height;
    public Rectangle(String color, double width, double height) {
        super(color);
        this.width = width;
        this.height = height;
    }

    public double getArea() {
        return width * height;
    }

    public void printDetails() {
        System.out.println("Shape: Rectangle" +
        "\n" + "Color: " + getColor() + "\n" +
         "Width: " + width + "\n" + "Height: "
          + height + "\n" + "Area: " + getArea());
    }

    public void resize(double factor) {
    width = width * factor;
    height = height * factor;
    }
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius, String color) {
        super(color);
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public void printDetails() {
        System.out.println("Shape: Circle" + 
        "\n" + "Color: " + color + "\n" +
         "Radius: " + radius + "\n" + 
         "Area: " + getArea());
    }

    public void resize(double factor) {
        radius = radius * factor;
    }
}
public class Lab4_6538184921 {
    public static void main(String[] args) {
        Shape[] shape = new Shape[5];
            shape[0] = new Square(5.0, "Red");
            shape[1] = new Square(3.0, "Blue");
            shape[2] = new Rectangle("Green", 4.0, 6.0);
            shape[3] = new Rectangle("Yellow", 2.0, 8.0);
            shape[4] = new Circle(7.0, "Orange");

        for (int i = 0; i <5;i++) {
            shape[i].printDetails();
            System.out.println("----------------------");
        }

        for (int i = 0; i <5;i++) {
            shape[i].resize(2);
            shape[i].printDetails();
            System.out.println("----------------------");
        }
    }

}