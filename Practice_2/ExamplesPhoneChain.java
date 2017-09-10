// assignment 2
// pair 043
// Wright Steven
// wrights
// Wang Shiyu
// shiyu
import tester.*;

public class ExamplesPhoneChain {
    public ExamplesPhoneChain() {
    }

    IPCmt  empty = new IPCmt();
    Player tay   = new Player("tay", "0");
    Player kim   = new Player("Kim", "1");
    Player zoe   = new Player("Zoe", "2");
    Player may   = new Player("May", "4");
    Player meg   = new Player("Meg", "5");
    Player pat   = new Player("Pat", "6");
    Player lou   = new Player("Lou", "7");
    Player jen   = new Player("Jen", "8");
    Player cam   = new Player("Cam", "9");
    Player ann   = new Player("Ann", "10");
    Player eve   = new Player("Eve", "11");
    Player bea   = new Player("Bea", "12");
    Player tam   = new Player("Tam", "13");
    Player joy   = new Player("Joy", "14");

    Link   ltay  = new Link(this.tay, this.empty, this.empty);
    Link   lzoe  = new Link(this.zoe, this.empty, this.empty);
    Link   lmeg  = new Link(this.meg, this.empty, this.empty);
    Link   llou  = new Link(this.lou, this.empty, this.empty);
    Link   lcam  = new Link(this.cam, this.empty, this.empty);
    Link   leve  = new Link(this.eve, this.empty, this.empty);
    Link   ltam  = new Link(this.tam, this.empty, this.empty);

    Link   lkim  = new Link(this.kim, this.ltay, this.lzoe);
    Link   lpat  = new Link(this.pat, this.lmeg, this.llou);
    Link   lann  = new Link(this.ann, this.lcam, this.leve);
    Link   ljoy  = new Link(this.joy, this.ltam, this.empty);

    Link   lmay  = new Link(this.may, this.lkim, this.lpat);
    Link   lbea  = new Link(this.bea, this.lann, this.joy);

    Link   ljen  = new Link(this.jen, this.lmay, this.lbea);

    // making sure the code contains at least one test
    boolean testAll(Tester t) {
        ExamplesPhoneChain epc = new ExamplesPhoneChain();
        return t.checkExpect(epc.ann, epc.ann);
    }
}