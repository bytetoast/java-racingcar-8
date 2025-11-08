package racingcar;

import java.util.Random;

public class Car {
    private String name;
    private int position;

    public Car(String inputName) {
        this.name = inputName;
        this.position = 0;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public void move() {
        Random random = new Random();
        int randomVal = random.nextInt(10);
        if (randomVal >= 4) {
            this.position++;
        }
        System.out.println(this.name + " : " + "-".repeat(this.position));
    }
}
