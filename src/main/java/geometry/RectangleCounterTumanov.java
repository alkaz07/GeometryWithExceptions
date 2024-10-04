package geometry;

import java.util.HashMap;
import java.util.List;

public class RectangleCounterTumanov {
    public static HashMap<Rectangle, Integer> countRectanglesFromFile(String fileName) throws Exception {
        List<Rectangle> rectanglesList = Loader.loadRecList(fileName);
        HashMap<Rectangle, Integer> rectangleMap = new HashMap<>();
        for (Rectangle rectangle : rectanglesList) {
            if (rectangleMap.containsKey(rectangle)) {
                rectangleMap.replace(rectangle, rectangleMap.get(rectangle) + 1);
            }
            else rectangleMap.put(rectangle, 1);
        }
        return rectangleMap;
    }
}
