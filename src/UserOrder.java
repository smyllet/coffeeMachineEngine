public class UserOrder {
    private final Drink drink;
    private final int sugar;

    public UserOrder(Drink drink, int sugar) {
        this.drink = drink;
        this.sugar = sugar;
    }

    public UserOrder(Drink drink) {
        this(drink, 0);
    }

    public Drink getDrink() {
        return drink;
    }

    public int getSugar() {
        return sugar;
    }
}
