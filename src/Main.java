import Cereal.CerealFileProcessor;
import Congress.CongressFileProcessor;

import java.text.ParseException;

class Main {
    public static void line() {
        System.out.println("-----");
    }
    public static void section(String name) {
        line();
        System.out.println(name);
        System.out.println();
    }
    public static void main(String[] args) throws ParseException {
        section("Cereal Processing!");
        CerealFileProcessor.main(args);
        section("Congress Processing!");
        CongressFileProcessor.main(args);
        line();
    }
}