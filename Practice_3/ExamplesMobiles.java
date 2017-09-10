// assignment 3
// pair 043
// Wright Steven
// wrights
// Wang Shiyu
// shiyu

import tester.*;
import javalib.colors.*;

class ExamplesMobiles {
    ExamplesMobiles() {
    }
    IMobile  simp1 = new Simple(2, 10, new Blue());
    IMobile  simp2 = new Simple(3, 50, new Green());
    IMobile  simp3 = new Simple(1, 10, new Red());
    IMobile comp1 = new Complex(1, 6, 6, this.simp3, this.simp1);
    IMobile comp2 = new Complex(3, 12, 5, this.comp1, this.simp2);
    IMobile comp3 = new Complex(3, 12, 6, this.comp1, this.comp2);
    IMobile comp3c = new Complex(3, 12, 6, this.simp2, this.comp1);
    IMobile comp1b = this.simp3.buildMobile(this.simp1, 1, 12);
    IMobile comp3b = this.comp1.buildMobile(this.simp2, 3, 18);
    
    Simple  b0 = new Simple(2, 10, new Blue());
    Simple  b1 = new Simple(2, 20, new Blue());

    // Test totalWeight method of IMobile interface
    boolean testTotalWeight(Tester t) {
        ExamplesMobiles em = new ExamplesMobiles();
        return t.checkExpect(em.simp1.totalWeight(), 10)
                && t.checkExpect(em.comp1.totalWeight(), 20);
    }

    // Test totalHeight method of IMobile interface
    boolean testTotalHeight(Tester t) {
        ExamplesMobiles em = new ExamplesMobiles();
        return t.checkExpect(em.simp1.totalHeight(), 2)
                && t.checkExpect(em.comp1.totalHeight(), 3);
    }

    // Test isBalanced method of IMobile interface
    boolean testIsBalanced(Tester t) {
        ExamplesMobiles em = new ExamplesMobiles();
        return t.checkExpect(em.simp1.isBalanced(), true)
                && t.checkExpect(em.comp1.isBalanced(), true)
                && t.checkExpect(em.comp3.isBalanced(), false);
    }

    // Test maxWidth method of IMobile interface
    boolean testMaxWidth(Tester t) {
        ExamplesMobiles em = new ExamplesMobiles();
        return t.checkExpect(em.simp1.maxWidth(), 1)
                && t.checkExpect(em.comp1.maxWidth(), 7);
    }

    // Test buildMobile method of IMobile interface
    // Test fails if it isn't possible to balance the two with integer math
    boolean testBuildMobile(Tester t) {
        ExamplesMobiles em = new ExamplesMobiles();
        return t.checkExpect(em.b0.buildMobile(b1, 2, 6).isBalanced())
                && t.checkExpect(em.b0.buildMobile(b0, 1, 10).isBalanced())
                && t.checkExpect(em.comp1.buildMobile(b0, 1, 6).isBalanced());
                
    }
}