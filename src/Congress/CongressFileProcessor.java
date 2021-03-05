package Congress;

import Base.BaseFileProcessor;

public class CongressFileProcessor extends BaseFileProcessor {
    public static void main(String[] args) {
        CongressFileProcessor fp = new CongressFileProcessor();
        fp.exploreFile(System.getProperty("user.dir") + "/data/Congress.csv");
        fp.processCongress();

        fp.exploreCongress();
    }

    /**
     * Inputs the contents from the Scanner and adds new Congress objects
     * for each line in the source that is being scanned.
     */
    private void processCongress() {
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

    }
}
