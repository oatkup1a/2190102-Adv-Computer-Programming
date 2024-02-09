public class Doll {
    private String name;
    private String material;
    private float price;

    public Doll(String name, String material, float price) {
        this.name = name;
        this.material = material;
        this.price = price;
    }

    public String toString() {
        return "Doll's name: " + name;
    }

    public void play() {
        System.out.println("I don't know how to play");
    }

    public void displayInfo() {
        System.out.println("Name: " + name + "\nMaterial: " + material + "\nPrice: $" + price);
    }

    public boolean isFragile() {
        if (material == "Porcelain" || material == "Glass") {
            return true;
        } else {
            return false;
        }
    }

}
