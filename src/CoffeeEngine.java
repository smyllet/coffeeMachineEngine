import java.util.*;

public class CoffeeEngine {
    private List<Drink> drinks;
    private List<UserOrder> ordersHistory;

    public CoffeeEngine() {
        this.drinks = new ArrayList<>();
        this.ordersHistory = new ArrayList<>();
    }

    public void addDrink(Drink drink) {
        if(!drinks.contains(drink)) drinks.add(drink);
    }

    public String getStringOrderFromUserOrder(UserOrder userOrder) {
        if(!drinks.contains(userOrder.getDrink())) return getMessageStringOrder("Boisson indisponible");
        if(userOrder.getSolde() < userOrder.getDrink().getPrice()) {
            double soldeDif = Math.round(Math.abs(userOrder.getDrink().getPrice() - userOrder.getSolde()) * 100.0) / 100.0;
            return getMessageStringOrder("Solde insuffisant, " + (soldeDif) + "€ manquant");
        } else {
            String result = Character.toString(userOrder.getDrink().getId());
            if(userOrder.isVeryHot()) result += "h";
            if(userOrder.getSugar() > 0) result += ":" + userOrder.getSugar() + ":0";
            else result += "::";

            ordersHistory.add(userOrder);

            return result;
        }
    }

    public String getMessageStringOrder(String message) {
        return "M:" + message;
    }

    public String getStringReport() {
        Map<Drink, Integer> statsForDrink = new HashMap<>();
        double totalSell = 0;

        for(UserOrder userOrder : ordersHistory) {
            statsForDrink.putIfAbsent(userOrder.getDrink(), 0);
            statsForDrink.put(userOrder.getDrink(), statsForDrink.get(userOrder.getDrink()) + 1);
            totalSell += userOrder.getDrink().getPrice();
        }

        StringBuilder result = new StringBuilder("Rapport de vente\n");
        for (Drink drink : drinks) {
            if(statsForDrink.containsKey(drink)) result.append(drink.getName()).append(" : ").append(statsForDrink.get(drink)).append("\n");
            else result.append(drink.getName()).append(" : 0\n");
        }
        result.append("Total des ventes : ").append(Math.round(totalSell * 100.0) / 100.0).append("€");

        return result.toString();
    }
}
