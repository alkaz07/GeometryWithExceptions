import geometry.GeometryException;
import geometry.Loader;
import geometry.Rectangle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Vector;

public class TestLoader {
    //вариант когда все ок
    @Test
    public void testLoadOk0()  {
        String s = "rectangles_ok.txt";
        Assertions.assertDoesNotThrow(()->Loader.loadRecList(s));
    }

    @Test
    public void testLoadOk1() throws GeometryException, FileNotFoundException {
        String s = "rectangles_ok.txt";
        //создать коллекцию, которая должна получиться
        List<Rectangle> expected = new Vector<>();
        expected.add(new Rectangle(10, 15));
        expected.add(new Rectangle(15, 12));
        expected.add(new Rectangle(3.4, 7.12));
        Assertions.assertIterableEquals(expected, Loader.loadRecList(s));
    }
}
