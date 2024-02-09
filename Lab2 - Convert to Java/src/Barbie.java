public class Barbie extends Doll {
    public Barbie(String name, String material, float price) {
        super(name, material, price);
    }
    @Override
    public void play() {
        System.out.println("Barbie sings: I'm a Barbie girl in a Barbie world!"
        );
    }
}