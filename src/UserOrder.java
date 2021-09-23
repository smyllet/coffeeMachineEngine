public class UserOrder {
    private final Drink drink;
    private final int sugar;
    private final double solde;

    public UserOrder(Drink drink, int sugar, double solde) {
        this.drink = drink;
        this.sugar = sugar;
        this.solde = solde;
    }

    public UserOrder(Drink drink, double solde) {
        this(drink, 0, solde);
    }

    public Drink getDrink() {
        return drink;
    }

    public int getSugar() {
        return sugar;
    }

    public double getSolde() {
        return solde;
    }
}
