import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Java14DescriptiveNullPointerExceptionTest {

    @Test
    public void invokeNPETest() {
        Assertions.assertThrows(NullPointerException.class, () -> Java14DescriptiveNullPointerException.invokeNPE());
    }
}
