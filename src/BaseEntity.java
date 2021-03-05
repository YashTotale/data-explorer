import java.util.HashMap;

public class BaseEntity {
    protected static String[] dataKeys;
    protected static final String NAME = "Name";
    protected HashMap<String, Object> values = new HashMap<>();

    public void add(String key, Object value) {
        values.put(key, value);
    }

    public Object get(String key) {
        return values.get(key);
    }

    public static void setDataKeys(String s) {
        dataKeys = s.split(",");
    }


    public String getName() {
        return (String) this.get(BaseEntity.NAME);
    }

    @Override
    public String toString() {
        return values.toString();
    }
}
