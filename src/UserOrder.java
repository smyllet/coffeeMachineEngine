public class UserOrder {
    private final Drink drink;
    private final int sugar;
    private final double solde;
    private final boolean veryHot;

    public UserOrder(HotDrink drink, int sugar, boolean veryHot, double solde) {
        this.drink = drink;
        this.sugar = sugar;
        this.solde = solde;
        this.veryHot = veryHot;
    }

    public UserOrder(Drink drink, double solde) {
        this.drink = drink;
        this.sugar = 0;
        this.solde = solde;
        this.veryHot = false;
    }

    public Drink getDrink() {
        return drink;
    }

    public int getSugar() {
        return sugar;
    }

    public boolean isVeryHot() {
        return veryHot;
    }

    public double getSolde() {
        return solde;
    }
}
