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

    @Test
    public void test2() throws GeometryException {
        String s = "src/test/resources/countOk2.txt";
        HashMap<Rectangle, Integer> expected = new HashMap<>();
        //Проверка

    }
    @Test
    public void test3() throws GeometryException {
        String s = "src/test/resources/countOk3.txt";
        HashMap<Rectangle, Integer> expected = new HashMap<>();
        expected.put(new Rectangle(10, 15), 4);
        expected.put(new Rectangle(11, 11), 1);
        //Проверка

    }
}
