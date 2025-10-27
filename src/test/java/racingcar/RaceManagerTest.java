package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class RaceManagerTest extends NsTest {
    @Override
    public void runMain() { }

    @Test
    public void addTwoCarTest() {
        RaceManager manager = new RaceManager();
        manager.addCar("pobi");
        manager.addCar("woni");
        assertThat(manager.getCars().get(0).getName() == "pobi");
        assertThat(manager.getCars().get(1).getName() == "woni");
    }

    @Test
    public void processRoundTest() {
        final int stopPobi = 3;
        final int movingWoni = 4;
        final int stopJun = 1;
        final int movingJuly = 9;
        assertRandomNumberInRangeTest(
            () -> {
                RaceManager manager = new RaceManager();
                manager.addCar("pobi");
                manager.addCar("woni");
                manager.addCar("jun");
                manager.addCar("july");
                manager.processRound();
                assertThat(output()).contains("pobi : \nwoni : -\njun : \njuly : -");
            },
            stopPobi, movingWoni, stopJun, movingJuly
        );
    }

    @Test
    public void getWinnersTest() {
        final int stopPobi = 3;
        final int stopWoni = 1;
        final int movingJun = 4;
        final int movingJuly = 9;
        final int stopRest = 2;
        final int movingWinner = 5;
        assertRandomNumberInRangeTest(
            () -> {
                RaceManager manager = new RaceManager();
                manager.addCar("pobi");
                manager.addCar("woni");
                manager.addCar("jun");
                manager.addCar("july");
                manager.processRound();
                manager.processRound();
                assertThat(manager.getWinners()).contains("july");
            },
            stopPobi, stopWoni, movingJun, movingJuly, stopRest, stopRest, stopRest, movingWinner
        );
    }

    @Test
    public void getMultipleWinnersTest() {
        final int stopPobi = 3;
        final int stopWoni = 1;
        final int movingJun = 4;
        final int movingJuly = 9;
        assertRandomNumberInRangeTest(
            () -> {
                RaceManager manager = new RaceManager();
                manager.addCar("pobi");
                manager.addCar("woni");
                manager.addCar("jun");
                manager.addCar("july");
                manager.processRound();
                assertThat(manager.getWinners()).contains("jun, july");
            },
            stopPobi, stopWoni, movingJun, movingJuly
        );
    }
}
