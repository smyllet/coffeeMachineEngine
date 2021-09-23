import java.util.Locale;

public class Drink {
    private final String name;
    private final char id;

    public Drink(String name, char id) {
        this.name = name;
        this.id = id;
    }

    public Drink(String name) {
        this(name, name.toUpperCase().charAt(0));
    }

    public String getName() {
        return name;
    }

    public char getId() {
        return id;
    }
}
