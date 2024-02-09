public class Animal {
    private SoundStrategy soundStrategy;

    public void setSoundStrategy(SoundStrategy soundStrategy) {
        this.soundStrategy = soundStrategy;
    }

    public void makeSound() {
        if (soundStrategy != null) {
            soundStrategy.makeSound();
        }
    }
}

class Dog extends Animal {
    // Dog-specific behavior
    public Dog() {
        // By default, dogs bark, so set the bark sound strategy
        setSoundStrategy(new BarkSoundStrategy());
    }
}

class Cat extends Animal {
    // Cat-specific behavior
    public Cat() {
        // By default, cats meow, so set the meow sound strategy
        setSoundStrategy(new MeowSoundStrategy());
    }
}
