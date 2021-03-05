package Congress;

import Base.BaseEntity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Congress extends BaseEntity {
    public static final String CONGRESS = "Congress";
    public static final String CHAMBER = "Chamber";
    public static final String BIO_GUIDE = "Bio Guide";
    public static final String FIRST_NAME = "First Name";
    public static final String MIDDLE_NAME = "Middle Name";
    public static final String LAST_NAME = "Last Name";
    public static final String SUFFIX = "Suffix";
    public static final String BIRTHDAY = "Birthday";
    public static final String STATE = "State";
    public static final String PARTY = "Party";
    public static final String INCUMBENT = "Incumbent";
    public static final String TERM_START = "Term Start";
    public static final String AGE = "Age";

    public static Congress parseString(String s) throws ParseException {
        String[] values = s.split(",");
        Congress c = new Congress();
        for (int i = 0; i < BaseEntity.dataKeys.length; i++) {
            String key = BaseEntity.dataKeys[i];
            Object value = values[i];
            switch (key) {
                case AGE: {
                    value = Double.parseDouble((String) value);
                    break;
                }
                case CONGRESS: {
                    value = Integer.parseInt((String) value);
                    break;
                }
                case TERM_START:
                case BIRTHDAY: {
                    value = new SimpleDateFormat("yyyy-MM-dd").parse((String) value);
                    break;
                }
                case INCUMBENT: {
                    value = value.equals("Yes");
                    break;
                }
            }
            c.add(key, value);
        }

        String name = c.getFirstName();
        if (c.getMiddleName().length() > 0) name += (" " + c.getMiddleName());
        if (c.getLastName().length() > 0) name += (" " + c.getLastName());
        if (c.getSuffix().length() > 0) name += (" " + c.getSuffix());
        c.add(NAME, name);

        return c;
    }

    public int getCongress() {
        return (int) this.get(CONGRESS);
    }

    public String getChamber() {
        return (String) this.get(CHAMBER);
    }

    public String getBioGuide() {
        return (String) this.get(BIO_GUIDE);
    }

    public String getFirstName() {
        return (String) this.get(FIRST_NAME);
    }

    public String getLastName() {
        return (String) this.get(LAST_NAME);
    }

    public String getMiddleName() {
        return (String) this.get(MIDDLE_NAME);
    }

    public String getSuffix() {
        return (String) this.get(SUFFIX);
    }

    public Date getBirthday() {
        return (Date) this.get(BIRTHDAY);
    }

    public String getState() {
        return (String) this.get(STATE);
    }

    public String getParty() {
        return (String) this.get(PARTY);
    }

    public boolean getIncumbent() {
        return (boolean) this.get(INCUMBENT);
    }

    public Date getTermStart() {
        return (Date) this.get(TERM_START);
    }

    public double getAge() {
        return (double) this.get(AGE);
    }
}
