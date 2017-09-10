import tester.*;


//assignment 8
//pair p134
//Singh, Bhavneet
//singhb
//Wang, Shiyu
//shiyu

public class ExamplesDequeT {

    // sample deque of pizzas
    DequeT<Pizza> d;

    // sample sentinels and nodes of pizzas
    SentinelT<Pizza> s;
    NodeT<Pizza> abcnode;
    NodeT<Pizza> bcdnode;
    NodeT<Pizza> cdenode;
    NodeT<Pizza> defnode;

    // sample deque of strings
    DequeT<String> ddd;

    // sample sentinels and nodes of strings
    SentinelT<String> sss;
    NodeT<String> anode;
    NodeT<String> bnode;
    NodeT<String> cnode;
    NodeT<String> dnode;

    // sample pizzas
    Pizza blue = new Pizza("blue");
    Pizza che = new Pizza("cheese");
    Pizza mus = new Pizza("mushroom");
    Pizza pep = new Pizza("pepperoni");
    Pizza steak = new Pizza("steak");

    // sample CompareByStringLex
    CompareStringLex csl = new CompareStringLex();

    // sample CompareStringSize
    CompareStringSize css = new CompareStringSize();

    // sample ComparePizzaTypeLex
    ComparePizzaTypeLex cp = new ComparePizzaTypeLex();

    // reset the pizza data
    void resetPizza() {
        s = new SentinelT<Pizza>();
        d = new DequeT<Pizza>();
        d.node = s;
        abcnode = new NodeT<Pizza>(che, null, null);
        bcdnode = new NodeT<Pizza>(mus, null, null);
        cdenode = new NodeT<Pizza>(pep, null, null);
        defnode = new NodeT<Pizza>(steak, null, null);
    }

    // reset the string data
    void resetString() {
        sss = new SentinelT<String>();
        ddd = new DequeT<String>();
        ddd.node = sss;
        anode = new NodeT<String>("ab", null, null);
        bnode = new NodeT<String>("abc", null, null);
        cnode = new NodeT<String>("abcd", null, null);
        dnode = new NodeT<String>("abcde", null, null);
    }

    // ordered pizza nodes
    void list1() {
        resetPizza();

        s.addPrev(defnode);
        s.addNext(abcnode);

        abcnode.addPrev(s);
        abcnode.addNext(bcdnode);

        bcdnode.addPrev(abcnode);
        bcdnode.addNext(cdenode);

        cdenode.addPrev(bcdnode);
        cdenode.addNext(defnode);

        defnode.addPrev(cdenode);
        defnode.addNext(s);
    }

    // unordered pizza nodes
    void list2() {
        resetPizza();

        s.addPrev(abcnode);
        s.addNext(defnode);

        abcnode.addNext(s);
        abcnode.addPrev(cdenode);
        bcdnode.addNext(cdenode);
        bcdnode.addPrev(defnode);
        cdenode.addNext(abcnode);
        cdenode.addPrev(bcdnode);
        defnode.addNext(bcdnode);
        defnode.addPrev(s);
    }

    // ordered string nodes
    void listOs() {
        resetString();

        sss.addPrev(dnode);
        sss.addNext(anode);

        anode.addPrev(sss);
        anode.addNext(bnode);

        bnode.addPrev(anode);
        bnode.addNext(cnode);

        cnode.addPrev(bnode);
        cnode.addNext(dnode);

        dnode.addPrev(cnode);
        dnode.addNext(sss);
    }

    // unordered string nodes
    void listUns() {
        resetString();

        sss.addPrev(anode);
        sss.addNext(dnode);

        anode.addNext(sss);
        anode.addPrev(cnode);
        bnode.addNext(cnode);
        bnode.addPrev(dnode);
        cnode.addNext(anode);
        cnode.addPrev(bnode);
        dnode.addNext(bnode);
        dnode.addPrev(sss);
    }

    // test all methods for DequeT, NodeT, SentinelT, ComparatorT
    void testAll(Tester t) {

        // ORDERED LIST
        list1();

        // size
        t.checkExpect(d.size(), 4);

        // addAtHead(using getFirst and size to check)
        d.addAtHead(che);

        // getFirst
        t.checkExpect(d.getFirst(), new NodeT<Pizza>(che, abcnode, s));

        // size
        t.checkExpect(d.size(), 5);

        // addAtTail(using getlast and size to check)
        d.addAtTail(che);

        // getLast
        t.checkExpect(d.getLast(), new NodeT<Pizza>(che, s, defnode));

        // size
        t.checkExpect(d.size(), 6);

        // removeFromHead(check it by size and getfirst)
        list1();
        d.removeFromHead();

        // size
        t.checkExpect(d.size(), 3);

        // getFirst
        t.checkExpect(d.getFirst(), new NodeT<Pizza>(mus, cdenode, s));

        // removeFromTail(check it by size and getlast)
        d.removeFromTail();

        // size
        t.checkExpect(d.size(), 2);

        // getLast
        t.checkExpect(d.getLast(), new NodeT<Pizza>(pep, s, bcdnode));

        // insertSorted
        list1();
        d.insertSorted(blue, cp);
        t.checkExpect(d.size(), 5);
        t.checkExpect(d.getFirst(), new NodeT<Pizza>(blue, abcnode, s));

        d.insertSorted(steak, cp);
        t.checkExpect(d.size(), 6);
        t.checkExpect(d.getLast(), new NodeT<Pizza>(steak, s, defnode));

        // removeSorted
        list1();
        d.removeSorted(che, cp);
        t.checkExpect(d.size(), 3);
        t.checkExpect(d.getFirst(), new NodeT<Pizza>(mus, cdenode, s));
        t.checkException(new RuntimeException("No such String in the list"),
                d,
                "removeSorted", che, cp);

        // *****************************************

        // ORDERED LIST OF STRINGS
        listOs();

        // size
        t.checkExpect(ddd.size(), 4);

        // addAtHead(using getFirst and size to check)
        ddd.addAtHead("a");

        // getFirst
        t.checkExpect(ddd.getFirst(), new NodeT<String>("a", anode, sss));

        // size
        t.checkExpect(ddd.size(), 5);

        // addAtTail(using getlast and size to check)
        ddd.addAtTail("a");

        // getLast
        t.checkExpect(ddd.getLast(), new NodeT<String>("a", sss, dnode));

        // size
        t.checkExpect(ddd.size(), 6);

        // removeFromHead(check it by size and getfirst)
        listOs();
        ddd.removeFromHead();

        // size
        t.checkExpect(ddd.size(), 3);

        // getFirst
        t.checkExpect(ddd.getFirst(), new NodeT<String>("abc", cnode, sss));

        // removeFromTail(check it by size and getlast)
        ddd.removeFromTail();

        // size
        t.checkExpect(ddd.size(), 2);

        // getLast
        t.checkExpect(ddd.getLast(), new NodeT<String>("abcd", sss, bnode));

        // insertSorted
        listOs();
        ddd.insertSorted("a", csl);
        t.checkExpect(ddd.size(), 5);
        t.checkExpect(ddd.getFirst(), new NodeT<String>("a", anode, sss));

        ddd.insertSorted("q", csl);
        t.checkExpect(ddd.size(), 6);
        t.checkExpect(ddd.getLast(), new NodeT<String>("q", sss, dnode));

        listOs();
        ddd.insertSorted("a", css);
        t.checkExpect(ddd.size(), 5);
        t.checkExpect(ddd.getFirst(), new NodeT<String>("a", anode, sss));

        ddd.insertSorted("qqqqqqqqqq", css);
        t.checkExpect(ddd.size(), 6);
        t.checkExpect(ddd.getLast(),
                new NodeT<String>("qqqqqqqqqq", sss, dnode));

        // removeSorted
        listOs();
        ddd.removeSorted("ab", csl);
        t.checkExpect(ddd.size(), 3);
        t.checkExpect(ddd.getFirst(), new NodeT<String>("abc", cnode, sss));
        t.checkException(new RuntimeException("No such String in the list"),
                ddd, "removeSorted", "ab", csl);

        // ***********************************

        // UNORDERED LIST OF PIZZAS
        list2();

        // size
        t.checkExpect(d.size(), 4);

        // addAtHead(using getFirst and size to check)
        list2();
        d.addAtHead(steak);
        // getFirst
        t.checkExpect(d.getFirst(), new NodeT<Pizza>(steak, defnode, s));

        // size
        t.checkExpect(d.size(), 5);

        // addAtTail(using getLast and size to check)
        d.addAtTail(steak);

        // getLast
        t.checkExpect(d.getLast(), new NodeT<Pizza>(steak, s, abcnode));

        // size
        t.checkExpect(d.size(), 6);

        // removeFromHead(check it by size and getFirst)
        list2();
        d.removeFromHead();

        // size
        t.checkExpect(d.size(), 3);

        // getFirst
        t.checkExpect(d.getFirst(), new NodeT<Pizza>(mus, cdenode, s));

        // removeFromTail(check it by size and getlast)
        d.removeFromTail();

        // size
        t.checkExpect(d.size(), 2);

        // getLast
        t.checkExpect(d.getLast(), new NodeT<Pizza>(pep, s, bcdnode));

        // *********************************

        // UNORDERED LIST OF STRINGS
        listUns();

        // size
        t.checkExpect(ddd.size(), 4);

        // addAtHead(using getFirst and size to check)
        listUns();
        ddd.addAtHead("abcde");

        // getFirst
        t.checkExpect(ddd.getFirst(), new NodeT<String>("abcde", dnode, sss));

        // size
        t.checkExpect(ddd.size(), 5);

        // addAtTail(using getLast and size to check)
        ddd.addAtTail("abcde");

        // getLast
        t.checkExpect(ddd.getLast(), new NodeT<String>("abcde", sss, anode));

        // size
        t.checkExpect(ddd.size(), 6);

        // removeFromHead(check it by size and getFirst)
        listUns();
        ddd.removeFromHead();

        // size
        t.checkExpect(ddd.size(), 3);

        // getFirst
        t.checkExpect(ddd.getFirst(), new NodeT<String>("abc", cnode, sss));

        // removeFromTail(check it by size and getlast)
        ddd.removeFromTail();

        // size
        t.checkExpect(ddd.size(), 2);

        // getLast
        t.checkExpect(ddd.getLast(), new NodeT<String>("abcd", sss, bnode));

        // **********************************

        // EMPTY LIST OF PIZZAS
        resetString();

        // size
        t.checkExpect(ddd.size(), 0);

        // getFirst
        t.checkException(new RuntimeException(
                "Cannot get the first of an empty list"), ddd, "getFirst");

        // getLast
        t.checkException(new RuntimeException(
                "Cannot get the last of an empty list"), ddd, "getLast");

        // removeFromHead
        t.checkException(new RuntimeException(
                "Cannot remove the first of an empty list"), ddd,
                "removeFromHead");

        // removeFromTail
        t.checkException(new RuntimeException(
                "Cannot remove the last of an empty list"), ddd,
                "removeFromTail");

        resetString();
        // addAtHead (using getFirst and getLast size to check it)
        ddd.addAtHead("ab");

        // size
        t.checkExpect(ddd.size(), 1);

        // getFirst
        t.checkExpect(ddd.getFirst(), new NodeT<String>("ab", sss, sss));

        // getLast
        t.checkExpect(ddd.getLast(), new NodeT<String>("ab", sss, sss));

        // addAtTail (using getFirst and getLast and size to check)
        resetString();
        ddd.addAtTail("ab");

        // getFirst
        t.checkExpect(ddd.getFirst(), new NodeT<String>("ab", sss, sss));

        // getLast
        t.checkExpect(ddd.getLast(), new NodeT<String>("ab", sss, sss));

        // size
        t.checkExpect(ddd.size(), 1);

        // insertSorted
        resetString();
        ddd.insertSorted("abcde", css);
        t.checkExpect(ddd.size(), 1);
        t.checkExpect(ddd.getFirst(), new NodeT<String>("abcde", sss, sss));
        t.checkExpect(ddd.getLast(), new NodeT<String>("abcde", sss, sss));

        // removeSorted
        resetString();
        t.checkException(new RuntimeException("No such String in the list"),
                ddd, "removeSorted", "ab", css);

        // insertSorted
        resetString();
        ddd.insertSorted("abcde", csl);
        t.checkExpect(ddd.size(), 1);
        t.checkExpect(ddd.getFirst(), new NodeT<String>("abcde", sss, sss));
        t.checkExpect(ddd.getLast(), new NodeT<String>("abcde", sss, sss));

        // removeSorted
        resetString();
        t.checkException(new RuntimeException("No such String in the list"),
                ddd, "removeSorted", "ab", csl);

        // *********

        // EMPTY LIST OF STRINGS
        resetPizza();

        // size
        t.checkExpect(d.size(), 0);

        // getFirst
        t.checkException(new RuntimeException(
                "Cannot get the first of an empty list"), d, "getFirst");

        // getLast
        t.checkException(new RuntimeException(
                "Cannot get the last of an empty list"), d, "getLast");

        // removeFromHead
        t.checkException(new RuntimeException(
                "Cannot remove the first of an empty list"), d,
                "removeFromHead");

        // removeFromTail
        t.checkException(new RuntimeException(
                "Cannot remove the last of an empty list"), d, 
                "removeFromTail");

        resetPizza();
        // addAtHead (using getFirst and getLast size to check it)
        d.addAtHead(che);

        // size
        t.checkExpect(d.size(), 1);

        // getFirst
        t.checkExpect(d.getFirst(), new NodeT<Pizza>(che, s, s));

        // getLast
        t.checkExpect(d.getLast(), new NodeT<Pizza>(che, s, s));

        // addAtTail (using getFirst and getLast and size to check)
        resetPizza();
        d.addAtTail(che);

        // getFirst
        t.checkExpect(d.getFirst(), new NodeT<Pizza>(che, s, s));

        // getLast
        t.checkExpect(d.getLast(), new NodeT<Pizza>(che, s, s));

        // size
        t.checkExpect(d.size(), 1);

        // insertSorted
        resetPizza();
        d.insertSorted(steak, cp);
        t.checkExpect(d.size(), 1);
        t.checkExpect(d.getFirst(), new NodeT<Pizza>(steak, s, s));
        t.checkExpect(d.getLast(), new NodeT<Pizza>(steak, s, s));

        // removeSorted
        resetPizza();
        t.checkException(new RuntimeException("No such String in the list"), d,
                "removeSorted", che, cp);

    }

}