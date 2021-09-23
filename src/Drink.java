import java.util.Locale;

public class Drink {
    private final String name;
    private final char id;
    private final double price;

    public Drink(String name, char id, double price) {
        this.name = name;
        this.id = id;
        this.price = price;
    }

    public Drink(String name, double price) {
        this(name, name.toUpperCase().charAt(0), price);
    }

    public String getName() {
        return name;
    }

    public char getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }
}
