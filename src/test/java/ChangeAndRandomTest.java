import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ChangeAndRandomTest {
    private ChangeAndRandom changeTest;

    @BeforeEach
    public void setUp(){
        changeTest = new ChangeAndRandom();
    }
    @DisplayName("테스트 테스트")
    @Test
    public void testChange(){
        int money = Integer.MIN_VALUE;
        boolean check = changeTest.retMsg(money);
        Assertions.assertEquals(false, check);
    }

}
