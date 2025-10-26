import camp.nextstep.edu.missionutils.Randoms;

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
        int randomVal = Randoms.pickNumberInRange(0, 9);
        if (randomVal >= 4) {
            this.position++;
        }
        System.out.println(this.name + " : " + "-".repeat(this.position));
    }
}
