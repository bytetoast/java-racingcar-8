package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class CarTest extends NsTest {
    @Override
    public void runMain() { }

    @Test
    void moveTest() {
        final int movingForward = 4;
        assertRandomNumberInRangeTest(
            () -> {
                Car car = new Car("pobi");
                car.move();
                assertThat(output()).contains("pobi : -");
            },
            movingForward
        );
    }

    @Test
    void stopTest() {
        final int stop = 3;
        assertRandomNumberInRangeTest(
            () -> {
                Car car = new Car("pobi");
                car.move();
                assertThat(output()).contains("pobi :");
            },
            stop
        );
    }

    @Test
    void threePlayersTest() {
        final int movingPobi = 6;
        final int stopWoni = 2;
        final int movingJun = 5;
        assertRandomNumberInRangeTest(
            () -> {
                Car carPobi = new Car("pobi");
                Car carWoni = new Car("woni");
                Car carJun = new Car("jun");
                carPobi.move();
                carWoni.move();
                carJun.move();
                assertThat(output()).contains("pobi : -\nwoni : \njun : -");
            },
            movingPobi, stopWoni, movingJun
        );
    }
}
