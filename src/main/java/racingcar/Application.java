package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carsStringRaw = Console.readLine();
        final String NAMES_REGEX = "^[a-zA-Z0-9]{1,5}(,[a-zA-Z0-9]{1,5})*$";
        if (!Pattern.matches(NAMES_REGEX, carsStringRaw)) {
            throw new IllegalArgumentException("Invalid car input.");
        }

        RaceManager manager = new RaceManager();
        String[] carsSplit = carsStringRaw.split(",");
        for (String carSplit : carsSplit) {
            manager.addCar(carSplit);
        }

        System.out.println("시도할 횟수는 몇 회인가요?");
        String numRoundsRaw = Console.readLine();
        final String NUM_ROUNDS_REGEX = "^[1-9][0-9]*$";
        if (!Pattern.matches(NUM_ROUNDS_REGEX, numRoundsRaw)) {
            throw new IllegalArgumentException("Invalid number of rounds.");
        }
        final int NUM_ROUNDS = Integer.parseInt(numRoundsRaw);
    }
}
