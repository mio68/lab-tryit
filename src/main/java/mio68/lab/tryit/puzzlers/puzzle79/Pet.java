package mio68.lab.tryit.puzzlers.puzzle79;

public class Pet {
    private final String name;
    private final String food;
    private final String sound;

    public Pet(String name, String food, String sound) {
        this.name = name;
        this.food = food;
        this.sound = sound;
    }

    public void eat() {
        System.out.println("eat");
    }

    public void play() {
        System.out.println("play");
    }

    public void sleep() {
        System.out.println("sleep");
    }

    public void live() {
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    eat();
                    play();
                    Pet.this.sleep();
                }
            }
        }.start();
    }


    public static void main(String[] args) throws InterruptedException {
        new Pet("Fido", "beef", "woof").live();
    }

}
