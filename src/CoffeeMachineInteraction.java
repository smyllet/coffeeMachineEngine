public class CoffeeMachineInteraction {
    public static String getStringOrderFromUserOrder(UserOrder userOrder) {
        if(userOrder.getSolde() < userOrder.getDrink().getPrice()) {
            double soldeDif = Math.round(Math.abs(userOrder.getDrink().getPrice() - userOrder.getSolde()) * 100.0) / 100.0;
            return getMessageStringOrder("Solde insuffisant, " + (soldeDif) + "€ manquant");
        } else {
            String result = Character.toString(userOrder.getDrink().getId());
            if(userOrder.isVeryHot()) result += "h";
            if(userOrder.getSugar() > 0) result += ":" + userOrder.getSugar() + ":0";
            else result += "::";
            return result;
        }
    }

    public static String getMessageStringOrder(String message) {
        return "M:" + message;
    }
}
