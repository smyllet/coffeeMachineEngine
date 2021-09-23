public class CoffeeMachineInteraction {
    public static String getStringOrderFromUserOrder(UserOrder userOrder) {
        if(userOrder.getSolde() < userOrder.getDrink().getPrice()) {
            double soldeDif = Math.round(Math.abs(userOrder.getDrink().getPrice() - userOrder.getSolde()) * 100.0) / 100.0;
            return getMessageStringOrder("Solde insuffisant, " + (soldeDif) + "€ manquant");
        }
        else if(userOrder.getSugar() > 0) return userOrder.getDrink().getId() + ":" + userOrder.getSugar() + ":0";
        else return userOrder.getDrink().getId() + "::";
    }

    public static String getMessageStringOrder(String message) {
        return "M:" + message;
    }
}
