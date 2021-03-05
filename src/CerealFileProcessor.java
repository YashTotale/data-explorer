public class CerealFileProcessor extends BaseFileProcessor {
    public static void main(String[] args) {
        CerealFileProcessor fp = new CerealFileProcessor();
        fp.exploreFile(System.getProperty("user.dir") + "/data/Cereal.csv");
        fp.processCereal();

        fp.exploreCereal();
    }

    /**
     * Inputs the contents from the Scanner and adds new Cereal objects
     * for each line in the source that is being scanned.
     */
    private void processCereal() {
        int i = 0;
        while (this.scan.hasNext()) {
            String line = this.scan.nextLine();
            if (i > 0) {
                this.entities.add(Cereal.parseString(line));
            } else {
                Cereal.setDataKeys(line);
            }
            i++;
        }
        this.scan.close();
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
}
