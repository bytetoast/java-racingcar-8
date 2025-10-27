package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class CarTest extends NsTest {
    @Test
    void moveTest() {
        final int MOVING_FORWARD = 4;
        assertRandomNumberInRangeTest(
                () -> {
                    Car car = new Car("pobi");
                    car.move();
                    assertThat(output()).contains("pobi : -");
                },
                MOVING_FORWARD
        );
    }

    @Test
    void stopTest() {
        final int STOP = 3;
        assertRandomNumberInRangeTest(
            () -> {
                Car car = new Car("pobi");
                car.move();
                assertThat(output()).contains("pobi :");
            },
            STOP
        );
    }

    @Test
    void threePlayersTest() {
        final int MOVING_POBI = 6;
        final int STOP_WONI = 2;
        final int MOVING_JUN = 5;
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
            MOVING_POBI, STOP_WONI, MOVING_JUN
        );
    }

    @Override
    public void runMain() { }
}
