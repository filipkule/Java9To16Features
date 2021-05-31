import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestTest {

    @Test
    public void test(){
        String actual = test.Test.testMethod("test");
        String expected = "The input is: test";

        Assertions.assertEquals(expected, actual);
    }
}
