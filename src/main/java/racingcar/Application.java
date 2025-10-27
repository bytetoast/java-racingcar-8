package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carsStringRaw = Console.readLine();
        final String namesRegex = "^[a-zA-Z0-9]{1,5}(,[a-zA-Z0-9]{1,5})*$";
        if (!Pattern.matches(namesRegex, carsStringRaw)) {
            throw new IllegalArgumentException("Invalid car input.");
        }

        RaceManager manager = new RaceManager();
        String[] carsSplit = carsStringRaw.split(",");
        for (String carSplit : carsSplit) {
            manager.addCar(carSplit);
        }

        System.out.println("시도할 횟수는 몇 회인가요?");
        String numRoundsRaw = Console.readLine();
        final String numRoundsRegex = "^[1-9][0-9]*$";
        if (!Pattern.matches(numRoundsRegex, numRoundsRaw)) {
            throw new IllegalArgumentException("Invalid number of rounds.");
        }
        final int numRounds = Integer.parseInt(numRoundsRaw);

        System.out.println("\n실행 결과");
        for (int round = 0; round < numRounds; round++) {
            manager.processRound();
        }
        System.out.println("최종 우승자 : " + manager.getWinners());
    }
}
