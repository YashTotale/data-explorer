package Base;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class BaseFileProcessor {
    protected static ArrayList<BaseEntity> entities = new ArrayList<>();
    protected Scanner scan;

    /**
     * This method attempts to create a Scanner pointing to the
     * file with the specified name
     *
     * @param name Name of the file to be processed
     */
    protected void exploreFile(String name) {
        try {
            File f = new File(name);
            this.scan = new Scanner(f);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected static void selectionSort(String key) {
        for (int i = 0; i < entities.size() - 1; i++) {
            int smallestCalories = (int) entities.get(i).get(key);
            int smallestIndex = i;
            for (int x = i + 1; x < entities.size(); x++) {
                int cals = (int) entities.get(x).get(key);
                if (cals < smallestCalories) {
                    smallestIndex = x;
                    smallestCalories = cals;
                }
            }
            BaseEntity temp = entities.get(i);
            entities.set(i, entities.get(smallestIndex));
            entities.set(smallestIndex, temp);
        }
    }

    protected static void insertionSort(String key) {
        for (int i = 1; i < entities.size(); i++) {
            double rating = (double) entities.get(i).get(key);
            int x = i;
            for (; x > 0; x--) {
                double currRating = (double) entities.get(x - 1).get(key);
                if (rating > currRating) break;
            }
            entities.add(x, entities.remove(i));
        }
    }

    protected void printRank(String key) {
        BaseEntity lowest = entities.get(0);
        System.out.println("Lowest " + key + ": " + lowest.getName() + " (" + lowest.get(key) + ")");

        BaseEntity highest = entities.get(entities.size() - 1);
        System.out.println("Highest " + key + ": " + highest.getName() + " (" + highest.get(key) + ")");
        System.out.println();
    }
}
