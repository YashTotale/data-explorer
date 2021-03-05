import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class CerealFileProcessor {
    private ArrayList<Cereal> cereals = new ArrayList<>();

    public static void main(String[] args) {
        CerealFileProcessor fp = new CerealFileProcessor();
        Scanner scan = fp.exploreFile(System.getProperty("user.dir") + "/data/Cereal.csv");
        fp.processCereal(scan);

        fp.exploreCereal();
    }

    /**
     * This method attempts to create a Scanner pointing to the
     * file with the specified name
     *
     * @param fname Name of the file to be processed
     * @return A Scanner that points to the File or null if there was
     * a problem opening the file
     */
    private Scanner exploreFile(String fname) {
        Scanner scan = null;
        try {
            File f = new File(fname);
            scan = new Scanner(f);
        } catch (Exception e) {
            System.err.println("Problem!!!");
            e.printStackTrace();
        }
        return scan;
    }

    /**
     * Inputs the contents from the Scanner and adds new Cereal objects
     * for each line in the source that is being scanned.
     *
     * @param scan The Scanner that points to the source of info
     */
    private void processCereal(Scanner scan) {
        int i = 0;
        while (scan.hasNext()) {
            String line = scan.nextLine();
            if (i > 0) {
                cereals.add(Cereal.parseString(line));
            } else {
                Cereal.setDataKeys(line);
            }
            i++;
        }
        scan.close();
    }

    private void exploreCereal() {
        String[] sortInts = {Cereal.SODIUM, Cereal.PROTEIN, Cereal.FAT, Cereal.CALORIES};

        for (String toSort : sortInts) {
            // Doing selection sort for ints (can change this without breaking, but change the casting as well)
            selectionSort(toSort);
            printRank(toSort);
        }

        String[] sortDoubles = {Cereal.RATING, Cereal.CUPS, Cereal.WEIGHT, Cereal.CARBOHYDRATES, Cereal.FIBER};

        for (String toSort : sortDoubles) {
            // Doing insertion sort for doubles (can change this without breaking, but change the casting as well)
            insertionSort(toSort);
            printRank(toSort);
        }
    }

    private void printRank(String key) {
        Cereal lowest =  cereals.get(0);
        System.out.println("Lowest " + key + ": " + lowest.getName() + " (" + lowest.get(key) + ")");

        Cereal highest = cereals.get(cereals.size() - 1);
        System.out.println("Highest " + key + ": " + highest.getName()  + " (" + highest.get(key) + ")");
        System.out.println();
    }

    private void selectionSort(String key) {
        for (int i = 0; i < cereals.size() - 1; i++) {
            int smallestCalories = (int) cereals.get(i).get(key);
            int smallestIndex = i;
            for (int x = i + 1; x < cereals.size(); x++) {
                int cals = (int) cereals.get(x).get(key);
                if (cals < smallestCalories) {
                    smallestIndex = x;
                    smallestCalories = cals;
                }
            }
            Cereal temp = cereals.get(i);
            cereals.set(i, cereals.get(smallestIndex));
            cereals.set(smallestIndex, temp);
        }
    }

    private void insertionSort(String key) {
        for (int i = 1; i < cereals.size(); i++) {
            double rating = (double) cereals.get(i).get(key);
            int x = i;
            for (; x > 0; x--) {
                double currRating = (double) cereals.get(x - 1).get(key);
                if (rating > currRating) break;
            }
            cereals.add(x, cereals.remove(i));
        }
    }
}
