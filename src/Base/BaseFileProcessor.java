package Base;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BaseFileProcessor {
    protected ArrayList<BaseEntity> entities = new ArrayList<>();
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

    protected void selectionSort(String key) {
        for (int i = 0; i < this.entities.size() - 1; i++) {
            int smallestCalories = (int) this.entities.get(i).get(key);
            int smallestIndex = i;
            for (int x = i + 1; x < this.entities.size(); x++) {
                int cals = (int) this.entities.get(x).get(key);
                if (cals < smallestCalories) {
                    smallestIndex = x;
                    smallestCalories = cals;
                }
            }
            BaseEntity temp = this.entities.get(i);
            this.entities.set(i, this.entities.get(smallestIndex));
            this.entities.set(smallestIndex, temp);
        }
    }

    protected void insertionSort(String key) {
        for (int i = 1; i < this.entities.size(); i++) {
            double rating = (double) this.entities.get(i).get(key);
            int x = i;
            for (; x > 0; x--) {
                double currRating = (double) this.entities.get(x - 1).get(key);
                if (rating > currRating) break;
            }
            this.entities.add(x, this.entities.remove(i));
        }
    }

    protected <T> HashMap<T, Integer> accumulate(String key) {
        HashMap<T, Integer> map = new HashMap<>();
        for (BaseEntity entity : this.entities) {
            T toCount = (T) entity.get(key);
            Integer curr = map.get(toCount);
            map.put(toCount, (curr == null ? 0 : curr) + 1);
        }
        return map;
    }

    protected Map.Entry<String, Integer> maxInMap(HashMap<String, Integer> map) {
        Map.Entry<String, Integer> maxEntry = null;

        for (Map.Entry<String, Integer> entry : map.entrySet())
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) maxEntry = entry;

        return maxEntry;
    }

    protected Map.Entry<String, Integer> minInMap(HashMap<String, Integer> map) {
        Map.Entry<String, Integer> minEntry = null;

        for (Map.Entry<String, Integer> entry : map.entrySet())
            if (minEntry == null || entry.getValue().compareTo(minEntry.getValue()) < 0) minEntry = entry;

        return minEntry;
    }

    protected void printRank(String key) {
        BaseEntity lowest = this.entities.get(0);
        System.out.println("Lowest " + key + ": " + lowest.getName() + " (" + lowest.get(key) + ")");

        BaseEntity highest = this.entities.get(this.entities.size() - 1);
        System.out.println("Highest " + key + ": " + highest.getName() + " (" + highest.get(key) + ")");

        System.out.println();
    }
}
