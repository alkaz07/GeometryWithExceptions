import geometry.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
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

    @Test
    public void testLoadBad0(){
        String s = "test/resources/abracadabra.net";
        Assertions.assertThrows(Exception.class, ()->Loader.loadRecList(s));
    }

    @Test
    public void testLoadBad1(){
        String s = "src/test/resources/bad1.txt";
        Assertions.assertThrows(NumberFormatException.class, ()->Loader.loadRecList(s));
    }
    @Test
    public void testLoadBad2(){
        String s = "src/test/resources/bad2.txt";
        Assertions.assertThrows(GeometryException.class, ()->Loader.loadRecList(s));
    }
    @Test
    public void testLoadBad3(){
        String s = "src/test/resources/bad3.txt";
        Assertions.assertThrows(NumberFormatException.class, ()->Loader.loadRecList(s));
    }
    @Test
    public void testLoadBad4(){
        String s = "src/test/resources/bad4.txt";
        Assertions.assertThrows(NegativeLengthException.class, ()->Loader.loadRecList(s));
    }

    @Test
    public void testLoadBad5() throws IOException {
        //Подготовка контекста
        String s = "src/test/resources/bad5";
        //String s = "bad5";
        FileWriter fileWriter = new FileWriter(s);
        fileWriter.write("10 0");
        fileWriter.close();
        //Проверка
        Assertions.assertThrows(ZeroLengthException.class, ()->Loader.loadRecList(s));
        //ВАЖНО!!! Вернуть контекст в предыдущее состояние!
        /*File myFile = new File(s);
        myFile.delete();*/
        new File(s).delete();
    }

    //подготовка контекста для всех методов тестировщика
    @BeforeAll
    public static void makeFileBad6() throws IOException {
        String s = "src/test/resources/bad6";
        System.out.println("Подготовка: делаем файл "+s);
        FileWriter fileWriter = new FileWriter(s);
        fileWriter.write("2 2\n" +
                        "\n" +
                        "3 4");
        fileWriter.close();
    }

    @Test
    public void testLoadBad6(){
        String s = "src/test/resources/bad6";
        Assertions.assertThrows(Exception.class, ()->Loader.loadRecList(s));
    }

    // Сброс контекста для всех методов
    @AfterAll
    public static void deleteFileBad6()
    {
        String s = "src/test/resources/bad6";
        System.out.println("Очистка: удаляем файл "+s);
        new File(s).delete();
    }

    @BeforeAll
    public static void makeFileBad7() throws IOException {
        String s = "src/test/resources/bad7";
        System.out.println("Подготовка: делаем файл "+s);
        FileWriter fileWriter = new FileWriter(s);
        fileWriter.write("1 2 3");
        fileWriter.close();
    }

    @Test
    public void testLoadBad7(){
        String s = "src/test/resources/bad7";
        Assertions.assertThrows(Exception.class, ()->Loader.loadRecList(s));
    }

    // Сброс контекста для всех методов

    @AfterAll
    public static void deleteFileBad7()
    {
        String s = "src/test/resources/bad7";
        System.out.println("Очистка: удаляем файл "+s);
        new File(s).delete();
    }

}
