import geometry.GeometryException;
import geometry.Rectangle;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class TestCounter {
    @Test
    public void test1() throws GeometryException {
        String s = "src/test/resources/countOk1.txt";
        HashMap<Rectangle, Integer> expected = new HashMap<>();
        expected.put(new Rectangle(10, 15), 3);
        expected.put(new Rectangle(25, 15), 1);
        //Проверка

    }
}
