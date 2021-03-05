class Main {
    public static void line() {
        System.out.println("-----");
    }
    public static void section(String name) {
        line();
        System.out.println(name);
        System.out.println();
    }
    public static void main(String[] args) {
        section("Cereal Processing!");
        CerealFileProcessor.main(args);
    }
}