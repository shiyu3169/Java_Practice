// assignment 2
// pair 043
// Wright Steven
// wrights
// Wang Shiyu
// shiyu
import tester.*;

public class ExamplesPizza {
    public ExamplesPizza() {
    }

    Plain  thinMoz = new Plain("thin crust", "mozarella");
    Plain  deepMix = new Plain("deep dish", "mixed cheese");
    IPizza order1  = new Fancy(new Fancy(this.thinMoz, "mushrooms"), "olives");
    IPizza order2  = new Fancy(new Fancy(this.deepMix, "pepperoni"), "onions");

    // making sure the code contains at least one test
    boolean testAll(Tester t) {
        ExamplesPizza ep = new ExamplesPizza();
        return t.checkExpect(ep.order1, ep.order1);
    }
}