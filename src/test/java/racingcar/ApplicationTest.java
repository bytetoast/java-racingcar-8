package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Test
    void 기능_테스트() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void missingLastItemTest() {
        assertThrows(IllegalArgumentException.class, 
            () -> {
                run("pobi,woni,", "3");
            }
        );
    }

    @Test
    void nameLongerThanFiveTest() {
        assertThrows(IllegalArgumentException.class, 
            () -> {
                run("pobi,woni,junjun", "5");
            }
        );
    }

    @Test
    void namesInWrongFormatTest() {
        assertThrows(IllegalArgumentException.class, 
            () -> {
                run("pobi1:wo1ni,1jun", "10"); // .도
            }
        );
    }

    @Test
    void spacesBetweenNamesTest() {
        assertThrows(IllegalArgumentException.class, 
            () -> {
                run("pobi1 ,wo1ni ,1jun", "9");
            }
        );
    }

    @Test
    void missingFirstItemTest() {
        assertThrows(IllegalArgumentException.class, 
            () -> {
                run(",wo1ni ,1jun", "12");
            }
        );
    }

    @Test
    void zeroRoundsTest() {
        assertThrows(IllegalArgumentException.class,
            () -> {
                run("pobi,woni,jun", "0");
            }
        );
    }

    @Test
    void negativeNumRoundsTest() {
        assertThrows(IllegalArgumentException.class,
            () -> {
                run("pobi1,wo1ni,1jun", "-3");
            }
        );
    }
}
