// assignment 4
// pair 043
// Wright Steven
// wrights
// Wang Shiyu
// shiyu

import tester.*;

class ExamplesIBook {
    ExamplesIBook() {
    }

    Book      b0  = new Book("Java", "Steven", 0);
    Book      b1  = new Book("Java", "Steven", 15);
    RefBook   rb0 = new RefBook("Java for Dummies", 0);
    RefBook   rb1 = new RefBook("Java for Dummies", 3);
    AudioBook ab0 = new AudioBook("AudioBook", "James", 0);
    AudioBook ab1 = new AudioBook("AudioBook", "James", 15);

    public boolean testDaysOverdue(Tester t) {
        ExamplesIBook eb = new ExamplesIBook();
        return t.checkExpect(eb.b0.daysOverdue(17), 3)
                && t.checkExpect(eb.b1.daysOverdue(17), -12)
                && t.checkExpect(eb.rb0.daysOverdue(5), 3)
                && t.checkExpect(eb.rb1.daysOverdue(5), 0)
                && t.checkExpect(eb.ab0.daysOverdue(17), 3)
                && t.checkExpect(eb.ab1.daysOverdue(17), -12);
    }

    public boolean testIsOverdue(Tester t) {
        ExamplesIBook eb = new ExamplesIBook();
        return t.checkExpect(eb.b0.isOverdue(17), true)
                && t.checkExpect(eb.b1.isOverdue(17), false)
                && t.checkExpect(eb.rb0.isOverdue(5), true)
                && t.checkExpect(eb.rb1.isOverdue(5), false)
                && t.checkExpect(eb.ab0.isOverdue(17), true)
                && t.checkExpect(eb.ab1.isOverdue(17), false);
    }

    public boolean testComputeFine(Tester t) {
        ExamplesIBook eb = new ExamplesIBook();
        return t.checkExpect(eb.b0.computeFine(17), 30)
                && t.checkExpect(eb.b1.computeFine(17), 0)
                && t.checkExpect(eb.rb0.computeFine(5), 30)
                && t.checkExpect(eb.rb1.computeFine(5), 0)
                && t.checkExpect(eb.ab0.computeFine(17), 60)
                && t.checkExpect(eb.ab1.computeFine(17), 0);
    }
}