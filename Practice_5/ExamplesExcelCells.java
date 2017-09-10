// assignment 1
// pair 043
// Wang Shiyu
// shiyu
// Wright Steven
// wrights

import tester.*;

//to represent ExamplesExcelCells class
class ExamplesExcelCells {
    IData a1     = new Number(8);
    Cell  cellA1 = new Cell("1", "A", a1);
    IData b1     = new Number(3);
    Cell  cellB1 = new Cell("1", "B", b1);
    IData c1     = new Number(4);
    Cell  cellC1 = new Cell("1", "C", c1);
    IData d1     = new Number(2);
    Cell  cellD1 = new Cell("1", "D", d1);
    IData e1     = new Number(2);
    Cell  cellE1 = new Cell("1", "E", e1);
    IData a2     = new Formula("max", cellB1, cellE1);
    Cell  cellA2 = new Cell("2", "A", a2);
    IData a3     = new Formula("*", cellA1, cellA2);
    Cell  cellA3 = new Cell("3", "A", a3);
    IData b2     = new Formula("+", cellA3, cellC1);
    Cell  cellB2 = new Cell("2", "B", b2);
    IData b3     = new Formula("+", cellB2, cellE1);
    Cell  cellB3 = new Cell("3", "B", b3);
    IData b4     = new Formula("+", cellB3, cellB2);
    Cell  cellB4 = new Cell("4", "B", b4);
    IData b5     = new Formula("+", cellB4, cellB3);
    Cell  cellB5 = new Cell("5", "B", b5);
    IData e2     = new Formula("*", cellB2, cellD1);
    Cell  cellE2 = new Cell("3", "E", e2);
    IData e3     = new Formula("max", cellB3, cellD1);
    Cell  cellE3 = new Cell("3", "E", e3);
    IData e4     = new Formula("max", cellB4, cellE3);
    Cell  cellE4 = new Cell("4", "E", e4);
    IData e5     = new Formula("*", cellB5, cellE4);
    Cell  cellE5 = new Cell("5", "E", e5);
    ILoC  mt     = new MtLoC();
    ILoC  l1     = new ConsLoC(cellB1, mt);
    ILoC  l2     = new ConsLoC(cellB3, (new ConsLoC(cellB2, (new ConsLoC(
                         cellB1, (new ConsLoC(cellA2, (new ConsLoC(cellA1,
                                 (new ConsLoC(cellB1, mt)))))))))));

    boolean testValue(Tester t) {
        return t.checkExpect(new Cell("2", "A", a2).value(), 3)
                && t.checkExpect(new Cell("3", "A", a3).value(), 24)
                && t.checkExpect(new Cell("1", "A", a1).value(), 8)
                && t.checkExpect(new Cell("2", "B", b2).value(), 28);
    }

    boolean testSameSpace(Tester t) {
        return t.checkExpect(cellA2.sameSpace(cellA3), false)
                && t.checkExpect(cellA1.sameSpace(cellA1), true)
                && t.checkExpect(cellE4.sameSpace(cellE1), false)
                && t.checkExpect(cellB1.sameSpace(cellB5), false);
    }

    boolean testMakeList(Tester t) {
        return t.checkExpect(cellA1.makeList(), new ConsLoC(cellA1, mt))
                && t.checkExpect(cellA2.makeList(), new ConsLoC(cellA2,
                        (new ConsLoC(cellB1, (new ConsLoC(cellE1, mt))))))
                && t.checkExpect(
                        cellB3.makeList(),
                        (new ConsLoC(
                        cellB3,
                        (new ConsLoC(
                        cellB2,
                        (new ConsLoC(
                        cellA3,
                        new ConsLoC(
                        cellA1,
                        (new ConsLoC(
                        cellA2,
                        (new ConsLoC(
                        cellB1,
                        (new ConsLoC(
                        cellE1,
                        (new ConsLoC(
                        cellC1,
                        (new ConsLoC(
                        cellE1,
                        mt))))))))))))))))));

    }

    boolean testIsFormula(Tester t) {
        return t.checkExpect(cellA1.isFormula(), false)
                && t.checkExpect(cellE3.isFormula(), true);
    }

    boolean testContains(Tester t) {
        return t.checkExpect(l1.contains(cellB1), true)
                && t.checkExpect(l2.contains(cellE2), false);
    }

    boolean testUnique(Tester t) {
        return t.checkExpect(l1.unique(), l1)
                && t.checkExpect(l2.unique(), new ConsLoC(cellA1, (new ConsLoC(
                        cellB1, mt))));
    }

    boolean testAppend(Tester t) {
        return t.checkExpect(l1.append(l1), (new ConsLoC(cellB1, (new ConsLoC(
                cellB1, mt)))))
                && t.checkExpect(
                        l1.append(l2),
                        (new ConsLoC(
                        cellB1,
                        (new ConsLoC(
                        cellB3,
                        (new ConsLoC(
                        cellB2,
                        (new ConsLoC(
                        cellB1,
                        (new ConsLoC(
                        cellA2,
                        (new ConsLoC(
                        cellA1,
                        (new ConsLoC(
                        cellB1,
                        mt)))))))))))))));
    }

    // test countArgs for ILoC
    boolean testCountArgs(Tester t) {
        return t.checkExpect(l1.countArgs(), 1)
                && t.checkExpect(l2.countArgs(), 6);
    }

    // test countArgs for IData
    boolean testCountArgsIData(Tester t) {
        return t.checkExpect(e5.countArgs(), 5)
				&& t.checkExpect(a1.countArgs(), 1);
    }
}
