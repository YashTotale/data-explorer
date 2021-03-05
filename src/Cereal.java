import java.util.HashMap;

/**
 * - Originally constructed with individual variables for each field
 * - Changed to a HashMap for conciseness and maintainability
 */
public class Cereal {
    private static String[] dataKeys;
    public static final String NAME = "Name";
    public static final String TYPE = "Type";
    public static final String SODIUM = "Sodium";
    public static final String FAT = "Fat";
    public static final String PROTEIN = "Protein";
    public static final String CALORIES = "Calories";
    public static final String RATING = "Rating";
    public static final String CUPS = "Cups";
    public static final String WEIGHT = "Weight";
    public static final String CARBOHYDRATES = "Carbohydrates";
    public static final String FIBER = "Fiber";

    private HashMap<String, Object> values = new HashMap<>();

    public void add(String key, Object value) {
        values.put(key, value);
    }

    public Object get(String key) {
        return values.get(key);
    }

    public static Cereal parseString(String s) {
        String[] values = s.split(",");
        Cereal c = new Cereal();
        for(int i = 0; i < dataKeys.length; i++) {
            String key = dataKeys[i];
            Object value = values[i];
            switch (key) {
                case TYPE: {
                    value = value.equals("C");
                    break;
                }
                case SODIUM:
                case FAT:
                case PROTEIN:
                case CALORIES: {
                    value = Integer.parseInt((String) value);
                    break;
                }
                case RATING:
                case CUPS:
                case WEIGHT:
                case CARBOHYDRATES:
                case FIBER: {
                    value = Double.parseDouble((String) value);
                    break;
                }
            }
            c.add(key, value);
        }
        return c;
    }

    public static void setDataKeys(String s) {
        dataKeys = s.split(",");
    }

    @Override
    public String toString() {
        return values.toString();
    }

    public String getName() {
        return (String) this.get(Cereal.NAME);
    }

    public boolean getType() {
        return (boolean) this.get(Cereal.TYPE);
    }

    public int getSodium() {
        return (int) this.get(Cereal.SODIUM);
    }

    public int getFat() {
        return (int) this.get(Cereal.FAT);
    }

    public int getProtein() {
        return (int) this.get(Cereal.PROTEIN);
    }

    public int getCalories() {
        return (int) this.get(Cereal.CALORIES);
    }

    public double getRating() {
        return (double) this.get(Cereal.RATING);
    }

    public double getCups() {
        return (double) this.get(Cereal.CUPS);
    }

    public double getWeight() {
        return (double) this.get(Cereal.WEIGHT);
    }

    public double getCarbohydrates() {
        return (double) this.get(Cereal.CARBOHYDRATES);
    }

    public double getFiber() {
        return (double) this.get(Cereal.FIBER);
    }
}
