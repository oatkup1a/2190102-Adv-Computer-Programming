public class TeddyDoll extends Doll {
    public TeddyDoll(String name, String material, float price) {
        super(name, material, price);
    }
    @Override
    public void play() {
        System.out.println("Teddy Doll says: Hug me!"
        );
    }
}