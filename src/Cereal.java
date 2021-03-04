import java.util.HashMap;

public class Cereal {
    private static String[] dataKeys;
    public static final String CALORIES = "Calories";
    public static final String RATING = "Rating";

    private HashMap<String, Object> values = new HashMap<>();

    public void add(String key, Object value) {
        values.put(key, value);
    }

    public Object get(String key) {
        return values.get(key);
    }

    public int getCalories() {
        return (int) this.get(Cereal.CALORIES);
    }

    public double getRating() {
        return (double) this.get(Cereal.RATING);
    }

    public static Cereal parseString(String s) {
        String[] values = s.split(",");
        Cereal c = new Cereal();
        for(int i = 0; i < dataKeys.length; i++) {
            String key = dataKeys[i];
            Object value = values[i];
            switch (key) {
                case "Type": {
                    value = value.equals("C");
                    break;
                }
                case "Sodium":
                case "Fat":
                case "Protein":
                case CALORIES: {
                    value = Integer.parseInt((String) value);
                    break;
                }
                case RATING:
                case "Cups":
                case "Weight":
                case "Carbohydrates":
                case "Fiber": {
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
        return values.toString() + "\n";
    }
}
