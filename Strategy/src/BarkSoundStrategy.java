class BarkSoundStrategy implements SoundStrategy {
    @Override
    public void makeSound() {
        System.out.println("Woof!");
    }
}

class MeowSoundStrategy implements SoundStrategy {
    @Override
    public void makeSound() {
        System.out.println("Meow!");
    }
}

