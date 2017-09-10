// assignment 2
// pair 043
// Wright Steven
// wrights
// Wang Shiyu
// shiyu
import tester.*;

public class ExamplesPerson {
    public ExamplesPerson() {
    }

    Address concordNH = new Address("Concord", "NH");
    Address concordMA = new Address("Concord", "MA");
    Address bostonMA  = new Address("Boston", "MA");
    Address nashuaNH  = new Address("Nashua", "NH");

    Person  tim       = new Person("Tim", 20, "M", this.concordNH);
    Person  ann       = new Person("Ann", 19, "F", this.concordMA);
    Person  pat       = new Person("Pat", 19, "F", this.bostonMA);
    Person  kim       = new Person("Kim", 17, "F", this.bostonMA);
    Person  dan       = new Person("Dan", 22, "M", this.nashuaNH);
    Person  lee       = new Person("Lee", 19, "M", this.concordMA);
    Person  jan       = new Person("Jan", 19, "F", this.concordMA);

    // making sure the code contains at least one test
    boolean testAll(Tester t) {
        ExamplesPerson ep = new ExamplesPerson();
        return t.checkExpect(ep.tim.sameCity(ep.tim), true)
                && t.checkExpect(ep.tim.sameCity(ep.pat), false) &&

                t.checkExpect(ep.tim.sameStateOnly(ep.dan), true)
                && t.checkExpect(ep.tim.sameStateOnly(ep.ann), false)
                && t.checkExpect(ep.tim.sameStateOnly(ep.pat), false)
                && t.checkExpect(ep.tim.sameStateOnly(ep.tim), false);
    }
}