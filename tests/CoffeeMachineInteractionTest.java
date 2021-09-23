import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoffeeMachineInteractionTest {
    private Drink coffee, hotChocolate, tea;
    private UserOrder simpleCoffee, simpleHotChocolate, simpleTea, coffeeWithSugar, teaWithDoubleSugar, coffeeWithLowSolde, coffeeWithJustNeededSolde;

    @BeforeEach
    final void setUp() {
        coffee = new Drink("Coffee", 0.6);
        hotChocolate = new Drink("Hot Chocolate", 0.5);
        tea = new Drink("Tea", 0.4);

        simpleCoffee = new UserOrder(coffee, 1);
        simpleHotChocolate = new UserOrder(hotChocolate, 1);
        simpleTea = new UserOrder(tea, 1);

        coffeeWithSugar = new UserOrder(coffee, 1, 1);
        teaWithDoubleSugar = new UserOrder(tea, 2, 1);

        coffeeWithLowSolde = new UserOrder(coffee, 0.59);
        coffeeWithJustNeededSolde = new UserOrder(coffee, 0.60);
    }

    @Test
    void getStringOrderFromUserOrder() {
        assertEquals("C::", CoffeeMachineInteraction.getStringOrderFromUserOrder(simpleCoffee));
        assertEquals("H::", CoffeeMachineInteraction.getStringOrderFromUserOrder(simpleHotChocolate));
        assertEquals("T::", CoffeeMachineInteraction.getStringOrderFromUserOrder(simpleTea));

        assertEquals("C:1:0", CoffeeMachineInteraction.getStringOrderFromUserOrder(coffeeWithSugar));
        assertEquals("T:2:0", CoffeeMachineInteraction.getStringOrderFromUserOrder(teaWithDoubleSugar));

        assertEquals("M:Solde insuffisant, 0.01€ manquant", CoffeeMachineInteraction.getStringOrderFromUserOrder(coffeeWithLowSolde));
        assertEquals("C::", CoffeeMachineInteraction.getStringOrderFromUserOrder(coffeeWithJustNeededSolde));
    }

    @Test
    void getMessageStringOrder() {
        assertEquals("M:Message de test", CoffeeMachineInteraction.getMessageStringOrder("Message de test"));
    }
}
