import tester.Tester;

// assignment 1
// pair 043
// Wang Shiyu
// shiyu
// Wright Steven
// wrights

class ExamplesBoundedPt {
    BoundedPt p0 = new BoundedPt(300, 300);

    public boolean testExecptions(Tester t) {
        return t.checkConstructorException(new RuntimeException(
                "The given x coordinate was 1 points beyond the left edge"),
                "BoundedPt", -1, 300)
                && t.checkConstructorException(
                        new RuntimeException(
                 "The given x coordinate was 1 points beyond the right edge"),
                        "BoundedPt", 601, 300)
                && t.checkConstructorException(
                        new RuntimeException(
                 "The given y coordinate was 1 points beyond the bottom edge"),
                        "BoundedPt", 300, -1)
                && t.checkConstructorException(
                        new RuntimeException(
                 "The given y coordinate was 1 points beyond the top edge"),
                        "BoundedPt", 300, 401);

    }
}