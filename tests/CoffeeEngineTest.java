import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoffeeEngineTest {
    private CoffeeEngine coffeeEngine;
    private HotDrink coffee, hotChocolate, tea;
    private Drink orangeJuice, appleJuice;
    private UserOrder simpleCoffee, simpleHotChocolate, simpleTea, simpleOrangeJuice, coffeeWithSugar, teaWithDoubleSugar, coffeeWithLowSolde, coffeeWithJustNeededSolde, veryHotTea, veryHotChocolateWithSugar, appleJuiceNotInEngine;

    @BeforeEach
    final void setUp() {
        coffeeEngine = new CoffeeEngine();

        coffee = new HotDrink("Café", 0.6);
        hotChocolate = new HotDrink("Chocolat Chaud", 'H',0.5);
        tea = new HotDrink("Thé", 0.4);
        orangeJuice = new Drink("Jus d'orange", 'O',0.6);
        appleJuice = new Drink("Jus de pomme", 'P', 0.6);

        coffeeEngine.addDrink(coffee);
        coffeeEngine.addDrink(hotChocolate);
        coffeeEngine.addDrink(tea);
        coffeeEngine.addDrink(orangeJuice);

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

        appleJuiceNotInEngine = new UserOrder(appleJuice, 1);
    }

    @Test
    void getStringOrderFromUserOrder() {
        assertEquals("C::", coffeeEngine.getStringOrderFromUserOrder(simpleCoffee));
        assertEquals("H::", coffeeEngine.getStringOrderFromUserOrder(simpleHotChocolate));
        assertEquals("T::", coffeeEngine.getStringOrderFromUserOrder(simpleTea));
        assertEquals("O::", coffeeEngine.getStringOrderFromUserOrder(simpleOrangeJuice));

        assertEquals("C:1:0", coffeeEngine.getStringOrderFromUserOrder(coffeeWithSugar));
        assertEquals("T:2:0", coffeeEngine.getStringOrderFromUserOrder(teaWithDoubleSugar));

        assertEquals("M:Solde insuffisant, 0.01€ manquant", coffeeEngine.getStringOrderFromUserOrder(coffeeWithLowSolde));
        assertEquals("C::", coffeeEngine.getStringOrderFromUserOrder(coffeeWithJustNeededSolde));

        assertEquals("Th::", coffeeEngine.getStringOrderFromUserOrder(veryHotTea));
        assertEquals("Hh:1:0", coffeeEngine.getStringOrderFromUserOrder(veryHotChocolateWithSugar));

        assertEquals("M:Boisson indisponible", coffeeEngine.getStringOrderFromUserOrder(appleJuiceNotInEngine));
    }

    @Test
    void getMessageStringOrder() {
        assertEquals("M:Message de test", coffeeEngine.getMessageStringOrder("Message de test"));
    }

    @Test
    void getStringReport() {
        assertEquals("Rapport de vente\nCafé : 0\nChocolat Chaud : 0\nThé : 0\nJus d'orange : 0\nTotal des ventes : 0.0€", coffeeEngine.getStringReport());

        coffeeEngine.getStringOrderFromUserOrder(simpleCoffee);
        assertEquals("Rapport de vente\nCafé : 1\nChocolat Chaud : 0\nThé : 0\nJus d'orange : 0\nTotal des ventes : 0.6€", coffeeEngine.getStringReport());

        coffeeEngine.getStringOrderFromUserOrder(simpleCoffee);
        assertEquals("Rapport de vente\nCafé : 2\nChocolat Chaud : 0\nThé : 0\nJus d'orange : 0\nTotal des ventes : 1.2€", coffeeEngine.getStringReport());

        coffeeEngine.getStringOrderFromUserOrder(simpleHotChocolate);
        assertEquals("Rapport de vente\nCafé : 2\nChocolat Chaud : 1\nThé : 0\nJus d'orange : 0\nTotal des ventes : 1.7€", coffeeEngine.getStringReport());

        coffeeEngine.getStringOrderFromUserOrder(simpleOrangeJuice);
        assertEquals("Rapport de vente\nCafé : 2\nChocolat Chaud : 1\nThé : 0\nJus d'orange : 1\nTotal des ventes : 2.3€", coffeeEngine.getStringReport());

        coffeeEngine.getStringOrderFromUserOrder(veryHotTea);
        assertEquals("Rapport de vente\nCafé : 2\nChocolat Chaud : 1\nThé : 1\nJus d'orange : 1\nTotal des ventes : 2.7€", coffeeEngine.getStringReport());
    }
}
