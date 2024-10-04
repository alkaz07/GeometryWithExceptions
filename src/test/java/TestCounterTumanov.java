import geometry.GeometryException;
import geometry.Rectangle;
import geometry.RectangleCounterTumanov;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class TestCounterTumanov {
    @Test
    public void test1() throws Exception {
        String s = "src/test/resources/countOk1.txt";
        HashMap<Rectangle, Integer> expected = new HashMap<>();
        expected.put(new Rectangle(10, 15), 3);
        expected.put(new Rectangle(25, 15), 1);
        //Проверка
        Assertions.assertIterableEquals(expected.entrySet(), RectangleCounterTumanov.countRectanglesFromFile(s).entrySet());
    }

    @Test
    public void test2() throws Exception {
        String s = "src/test/resources/countOk2.txt";
        HashMap<Rectangle, Integer> expected = new HashMap<>();
        //Проверка
        Assertions.assertIterableEquals(expected.entrySet(), RectangleCounterTumanov.countRectanglesFromFile(s).entrySet());
    }
    @Test
    public void test3() throws Exception {
        String s = "src/test/resources/countOk3.txt";
        HashMap<Rectangle, Integer> expected = new HashMap<>();
        expected.put(new Rectangle(10, 15), 4);
        expected.put(new Rectangle(11, 11), 1);
        //Проверка
        Assertions.assertIterableEquals(expected.entrySet(), RectangleCounterTumanov.countRectanglesFromFile(s).entrySet());
    }
}
