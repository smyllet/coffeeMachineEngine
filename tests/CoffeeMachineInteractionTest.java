import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoffeeMachineInteractionTest {
    private Drink coffee, hotChocolate, tea;
    private UserOrder simpleCoffee, simpleHotChocolate, simpleTea, coffeeWithSugar, teaWithDoubleSugar;

    @BeforeEach
    final void setUp() {
        coffee = new Drink("Coffee");
        hotChocolate = new Drink("Hot Chocolate");
        tea = new Drink("Tea");

        simpleCoffee = new UserOrder(coffee);
        simpleHotChocolate = new UserOrder(hotChocolate);
        simpleTea = new UserOrder(tea);

        coffeeWithSugar = new UserOrder(coffee, 1);
        teaWithDoubleSugar = new UserOrder(tea, 2);
    }

    @Test
    void getStringOrderFromUserOrder() {
        assertEquals("C::", CoffeeMachineInteraction.getStringOrderFromUserOrder(simpleCoffee));
        assertEquals("H::", CoffeeMachineInteraction.getStringOrderFromUserOrder(simpleHotChocolate));
        assertEquals("T::", CoffeeMachineInteraction.getStringOrderFromUserOrder(simpleTea));

        assertEquals("C:1:0", CoffeeMachineInteraction.getStringOrderFromUserOrder(coffeeWithSugar));
        assertEquals("T:2:0", CoffeeMachineInteraction.getStringOrderFromUserOrder(teaWithDoubleSugar));
    }

    @Test
    void getMessageStringOrder() {
        assertEquals("M:Message de test", CoffeeMachineInteraction.getMessageStringOrder("Message de test"));
    }
}
