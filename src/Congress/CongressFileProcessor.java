package Congress;

import Base.BaseEntity;
import Base.BaseFileProcessor;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

public class CongressFileProcessor extends BaseFileProcessor {
    public static void main(String[] args) throws ParseException {
        CongressFileProcessor fp = new CongressFileProcessor();
        fp.exploreFile(System.getProperty("user.dir") + "/data/Congress.csv");
        fp.processCongress();

        fp.exploreCongress();
    }

    /**
     * Inputs the contents from the Scanner and adds new Congress objects
     * for each line in the source that is being scanned.
     */
    private void processCongress() throws ParseException {
        int i = 0;
        while (this.scan.hasNext()) {
            String line = this.scan.nextLine();
            if (i > 0) {
                entities.add(Congress.parseString(line));
            } else {
                Congress.setDataKeys(line);
            }
            i++;
        }
        this.scan.close();
    }

    private void exploreCongress() {
        this.insertionSort(Congress.AGE);
        this.printRank(Congress.AGE);

        HashMap<String, Integer> partyCounts = this.accumulate(Congress.PARTY);
        System.out.println("Party Counts: " + partyCounts);

        System.out.println();

        HashMap<Boolean, Integer> incumbentCounts = this.accumulate(Congress.INCUMBENT);
        System.out.println("Incumbent Counts: " + incumbentCounts);

        System.out.println();

        HashMap<String, Integer> stateCounts = this.accumulate(Congress.STATE);
        System.out.println("State Counts: " + stateCounts);

        System.out.println();

        HashMap<String, Integer> personCounts = this.accumulate(BaseEntity.NAME);
        System.out.println("Person Counts: " + personCounts);

        Map.Entry<String, Integer> maxPerson = this.maxInMap(personCounts);
        System.out.println("Highest Person Count: " + maxPerson);

        Map.Entry<String, Integer> minPerson = this.minInMap(personCounts);
        System.out.println("Lowest Person Count: " + minPerson);
    }
}
