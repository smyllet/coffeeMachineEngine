public class CoffeeMachineInteraction {
    public static String getStringOrderFromUserOrder(UserOrder userOrder) {
        if(userOrder.getSugar() > 0) {
            return userOrder.getDrink().getId() + ":" + userOrder.getSugar() + ":0";
        } else return userOrder.getDrink().getId() + "::";
    }

    public static String getMessageStringOrder(String message) {
        return "M:" + message;
    }
}
