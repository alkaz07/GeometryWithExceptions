package geometry;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class Loader {
    //Создать класс Загрузчик
    //
    //а в нем СТАТИЧЕСКИЙ метод загрузитьСписокПрямоугольников
    //входной параметр - это строковое имя файла
    //результат - список прямоугольников
    public static List<Rectangle> loadRecList(String filename) throws FileNotFoundException, GeometryException {
        List<Rectangle> rectangles = new Vector<>();    //привычнее использовать ArrayList
        try(Scanner scanner = new Scanner(new File(filename))){
            while (scanner.hasNext()){
                String line = scanner.nextLine();
                String[] massiv = line.split(" ");
                if(massiv.length != 2) throw new GeometryException("в каждой строчке файла должно быть только 2 числа");
                double w = Double.parseDouble(massiv[0]);
                double l = Double.parseDouble(massiv[1]);
                Rectangle rect = new Rectangle(w, l);
                rectangles.add(rect);
            }
        }

        return rectangles;
    }
}
