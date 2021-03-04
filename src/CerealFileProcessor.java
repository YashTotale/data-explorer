import java.io.File;
import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.Scanner;

public class CerealFileProcessor {
    // We will store a List of Cereal Objects in this list
    private ArrayList<Cereal> cereals = new ArrayList<>();

    public static void main(String[] args) {
        CerealFileProcessor fp = new CerealFileProcessor();
        Scanner scan = fp.exploreFile(System.getProperty("user.dir") + "/data/Cereal.csv");
        fp.processCereal(scan);

        // solves some problems, like cereal with the most sugar,
        // fewest calories, etc.  You can make up your own
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

    /**
     * Explores the cereals that were input from the file.
     * You will find the Cereal with the most calories, least salt, etc.
     * Make up some attribute to explore.
     */
    private void exploreCereal() {
        // for starters, find the Cereal with the most calories, least sugar, highest rating, etc.
        sortByCalories();
        System.out.println("Lowest calories: " + cereals.get(0));
        System.out.println("Highest calories: " + cereals.get(cereals.size() - 1));

        sortByRating();
        System.out.println(cereals);
        // now get the highest and lowest rated cereals

    }

    private void sortByCalories() {
        for (int i = 0; i < cereals.size() - 1; i++) {
            int smallestCalories = cereals.get(i).getCalories();
            int smallestIndex = i;
            for (int x = i + 1; x < cereals.size(); x++) {
                int cals = cereals.get(x).getCalories();
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

    /**
     * For this sort, try to implement an insertionsort
     * AVOID looking at code for the sort.
     */
    private void sortByRating() {
        for(int i = 1; i < cereals.size(); i++) {
            double rating = cereals.get(i).getRating();
            int x = i;
            for(; x > 0; x--) {
                double currRating = cereals.get(x - 1).getRating();
                if(rating > currRating) break;
            }
            cereals.add(x, cereals.remove(i));
        }
    }
}
