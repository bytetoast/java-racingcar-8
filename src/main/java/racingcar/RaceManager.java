package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RaceManager {
    private List<Car> cars;

    public RaceManager() {
        this.cars = new ArrayList<>();
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public void addCar(String name) {
        this.cars.add(new Car(name));
    }

    public void processRound() {
        for (Car car : this.cars) {
            car.move();
        }
        System.out.println("\n");
    }

    public String getWinners() {
        int max = -1;
        ArrayList<String> winners = new ArrayList<>();
        for (Car car : this.cars) {
            if (car.getPosition() > max) {
                max = car.getPosition();
                winners.clear();
                winners.add(car.getName());
            } else if (car.getPosition() == max) {
                winners.add(car.getName());
            }
        }
        return String.join(", ", winners);
    }
}
