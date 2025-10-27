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
        final int STOP_POBI = 3;
        final int MOVING_WONI = 4;
        final int STOP_JUN = 1;
        final int MOVING_JULY = 9;
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
            STOP_POBI, MOVING_WONI, STOP_JUN, MOVING_JULY
        );
    }

    @Test
    public void getWinnersTest() {
        final int STOP_POBI = 3;
        final int STOP_WONI = 1;
        final int MOVING_JUN = 4;
        final int MOVING_JULY = 9;
        final int STOP_REST = 2;
        final int MOVING_WINNER = 5;
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
            STOP_POBI, STOP_WONI, MOVING_JUN, MOVING_JULY, STOP_REST, STOP_REST, STOP_REST, MOVING_WINNER
        );
    }

    @Test
    public void getMultipleWinnersTest() {
        final int STOP_POBI = 3;
        final int STOP_WONI = 1;
        final int MOVING_JUN = 4;
        final int MOVING_JULY = 9;
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
            STOP_POBI, STOP_WONI, MOVING_JUN, MOVING_JULY
        );
    }
}
