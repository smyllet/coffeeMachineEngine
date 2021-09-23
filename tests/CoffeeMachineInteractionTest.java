import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoffeeMachineInteractionTest {
    private HotDrink coffee, hotChocolate, tea;
    private Drink orangeJuice;
    private UserOrder simpleCoffee, simpleHotChocolate, simpleTea, simpleOrangeJuice, coffeeWithSugar, teaWithDoubleSugar, coffeeWithLowSolde, coffeeWithJustNeededSolde, veryHotTea, veryHotChocolateWithSugar;

    @BeforeEach
    final void setUp() {
        coffee = new HotDrink("Café", 0.6);
        hotChocolate = new HotDrink("Chocolat Chaud", 'H',0.5);
        tea = new HotDrink("Thé", 0.4);
        orangeJuice = new Drink("Jus d'orange", 'O',0.6);

        simpleCoffee = new UserOrder(coffee, 1);
        simpleHotChocolate = new UserOrder(hotChocolate, 1);
        simpleTea = new UserOrder(tea, 1);
        simpleOrangeJuice = new UserOrder(orangeJuice, 1);

        coffeeWithSugar = new UserOrder(coffee, 1, false,1);
        teaWithDoubleSugar = new UserOrder(tea, 2, false, 1);

        coffeeWithLowSolde = new UserOrder(coffee, 0.59);
        coffeeWithJustNeededSolde = new UserOrder(coffee, 0.60);

        veryHotTea = new UserOrder(tea, 0, true, 1);
        veryHotChocolateWithSugar = new UserOrder(hotChocolate, 1, true, 1);
    }

    @Test
    void getStringOrderFromUserOrder() {
        assertEquals("C::", CoffeeMachineInteraction.getStringOrderFromUserOrder(simpleCoffee));
        assertEquals("H::", CoffeeMachineInteraction.getStringOrderFromUserOrder(simpleHotChocolate));
        assertEquals("T::", CoffeeMachineInteraction.getStringOrderFromUserOrder(simpleTea));
        assertEquals("O::", CoffeeMachineInteraction.getStringOrderFromUserOrder(simpleOrangeJuice));

        assertEquals("C:1:0", CoffeeMachineInteraction.getStringOrderFromUserOrder(coffeeWithSugar));
        assertEquals("T:2:0", CoffeeMachineInteraction.getStringOrderFromUserOrder(teaWithDoubleSugar));

        assertEquals("M:Solde insuffisant, 0.01€ manquant", CoffeeMachineInteraction.getStringOrderFromUserOrder(coffeeWithLowSolde));
        assertEquals("C::", CoffeeMachineInteraction.getStringOrderFromUserOrder(coffeeWithJustNeededSolde));

        assertEquals("Th::", CoffeeMachineInteraction.getStringOrderFromUserOrder(veryHotTea));
        assertEquals("Hh:1:0", CoffeeMachineInteraction.getStringOrderFromUserOrder(veryHotChocolateWithSugar));
    }

    @Test
    void getMessageStringOrder() {
        assertEquals("M:Message de test", CoffeeMachineInteraction.getMessageStringOrder("Message de test"));
    }
}
