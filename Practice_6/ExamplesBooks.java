// assignment 6
// pair p134
// Singh, Bhavneet
// singhb
// Wang, Shiyu
// shiyu

import tester.*;

//to represent the example class
class ExamplesBooks {

    // sample IBookComparators of each type/class
    IBookComparator booksByTitle = new BooksByTitle();
    IBookComparator booksByAuthor = new BooksByAuthor();
    IBookComparator booksByPrice = new BooksByPrice();
 
    // sample books  MY authors have awesome names
    Book w1 = new Book("w1", "funk volume", 50);
    Book w2 = new Book("w2", "Mr Cat in the Hat", 20);
    Book w3 = new Book("w3", "Hate Monger", 10);
    Book w4 = new Book("w4", "The Man who has no I's", 40);
    Book w5 = new Book("w5", "Zorn's Lemma", 30);
    Book w6 = new Book("w6", "Alex Smith", 1000);
    
    Book b1 = new Book("b1", "bb1", 50);
    Book b2 = new Book("b2", "bb1", 20);
    Book b3 = new Book("b3", "bb1", 10);
    Book b4 = new Book("b4", "bb1", 40);
    Book b5 = new Book("b5", "bb1", 30);
    
    // sample List of Books
    ILoBook mt = new MtLoBook();
    ILoBook low1 = new ConsLoBook(w1, mt);
    ILoBook low2 = new ConsLoBook(w2, low1);
    ILoBook low3 = new ConsLoBook(w3, low2);
    ILoBook low4 = new ConsLoBook(w6, low3);
    ILoBook low5 = new ConsLoBook(w6, mt);
    ILoBook low6 = new ConsLoBook(w3, low5);
    ILoBook lob7 = new ConsLoBook(w2, low6);
    ILoBook lob8 = new ConsLoBook(w1, lob7);
    ILoBook lobx = new ConsLoBook(w6, low1);
    
    
    // sample ABST's
    ABST l1 = new Leaf(booksByTitle);
    ABST l2 = new Leaf(booksByAuthor);
    ABST l3 = new Leaf(booksByPrice);
    
    // sample ABST arranged by Title
    ABST n0 = new Node(w6, l1, l1);
    ABST n1 = new Node(w1, l1, l1);
    ABST n2 = new Node(w3, l1, n0);
    ABST n3 = new Node(w2, n1, n2);

    ABST na = new Node(w6, l1, l1);
    ABST nb = new Node(w1, l1, l1);
    ABST nc = new Node(w2, nb, l1);
    ABST nd = new Node(w3, nc, na);
    
    ABST t1 = new Node(w2, l1, l1);
    ABST t2 = new Node(w3, l1, l1);
    ABST t3 = new Node(w1, l1, n0);
    ABST t4 = new Node(w6, n1, n2);
    
    // sample ABST arranged by Author
    ABST n4 = new Node(w5, l2, l2);
    ABST n5 = new Node(w6, l2, l2);
    ABST n6 = new Node(w2, l2, n4);
    ABST n7 = new Node(w1, n5, l2);
    ABST n8 = new Node(w3, n7, n6);
    
    ABST a1 = new Node(w2, l2, l2);
    ABST a2 = new Node(w3, a1, l2);
    ABST a3 = new Node(w6, l2, l2);
    ABST a4 = new Node(w1, a2, a3);
    
    // sample ABST arranged by Price, highest to lowest
    ABST n9 = new Node(w3, l3, l3);
    ABST n10 = new Node(w6, l3, l3);
    ABST n11 = new Node(w1, n10, l3);
    ABST n12 = new Node(w5, n11, n9);
    
    ABST nz = new Node(w6, l3, l3);
    ABST ny = new Node(w1, nz, l3);
    ABST nx = new Node(w5, ny, l3);
    ABST nw = new Node(w3, nx, l3);
    
    // TESTS FOR BooksByTitle
    
    //  test the method compare in the BooksByTitle Class
    public boolean testBookByTitle(Tester t) {
        return t.checkExpect(this.booksByTitle.compare(w1, w2), 1)
        && t.checkExpect(this.booksByTitle.compare(w2, w1), -1)
        && t.checkExpect(this.booksByTitle.compare(w1, w1), 0);
    }

    // TESTS FOR BooksByAuthor
    
    //  test the method compare in the BooksByAuthor Class
    public boolean testBookByAuthor(Tester t) {
        return t.checkExpect(this.booksByAuthor.compare(w1, w1), 0)
        && t.checkExpect(this.booksByAuthor.compare(w1, w6), -37)
        && t.checkExpect(this.booksByAuthor.compare(w6, w2), 12)
        && t.checkExpect(this.booksByAuthor.compare(w3, w2), 5);
    }

    // TESTS FOR BooksByPrice
    
    // test the method compare in the BooksByPrice Class
    public boolean testBookByPrice(Tester t) {
        return t.checkExpect(this.booksByPrice.compare(w1, w2), 30)
        && t.checkExpect(this.booksByPrice.compare(w2, w1), -30)
        && t.checkExpect(this.booksByPrice.compare(w2, w2), 0);
    }
    
    //TESTS FOR Leaf
    
    // test the method insert in the Leaf Class
    public boolean testInsertLeaf(Tester t) {
        return t.checkExpect(l1.insert(w1), new Node(w1, l1, l1))
        && t.checkExpect(l2.insert(w2), new Node(w2, l2, l2))
        && t.checkExpect(l3.insert(w3), new Node(w3, l3, l3));
    }
    
    // test the method getFirst in the Leaf Class
    public boolean testGetFirstLeaf(Tester t) {
        return t.checkException(
        new RuntimeException("No first in an empty tree"), l1, "getFirst")
        && t.checkException(
        new RuntimeException("No first in an empty tree"), l2, "getFirst")
        && t.checkException(
        new RuntimeException("No first in an empty tree"), l3, "getFirst");
    }

    // test the method getRest in the Leaf Class
    public boolean testGetRestLeaf(Tester t) {
        return t.checkException(
        new RuntimeException("No rest of an empty tree"), l1, "getRest")
        && t.checkException(
        new RuntimeException("No rest of an empty tree"), l2, "getRest")
        && t.checkException(
        new RuntimeException("No rest of an empty tree"), l3, "getRest");
    }

    // test the method isLeaf in the Leaf Class
    public boolean testIsLeafLeaf(Tester t) {
        return t.checkExpect(l1.isLeaf(), true)
        && t.checkExpect(l2.isLeaf(), true)
        && t.checkExpect(l3.isLeaf(), true);
    }
    
    // test the method giveLeft in the Leaf Class
    public boolean testGiveLeftLeaf(Tester t) {
        return t.checkException(
        new RuntimeException("No left in an empty tree"), l1, "giveLeft")
        && t.checkException(
        new RuntimeException("No left in an empty tree"), l2, "giveLeft")
        && t.checkException(
        new RuntimeException("No left in an empty tree"), l3, "giveLeft");
    }
    
    // test the method giveRight in the Leaf Class
    public boolean testGiveRightLeaf(Tester t) {
        return t.checkException(
        new RuntimeException("No right in an empty tree"), l1, "giveRight")
        && t.checkException(
        new RuntimeException("No right in an empty tree"), l2, "giveRight")
        && t.checkException(
        new RuntimeException("No right in an empty tree"), l3, "giveRight");
    }
    
    // test the method giveData in the Leaf Class
    public boolean testGiveDataLeaf(Tester t) {
        return t.checkException(
        new RuntimeException("No data in an empty tree"), l1, "giveData")
        && t.checkException(
        new RuntimeException("No data in an empty tree"), l2, "giveData")
        && t.checkException(
        new RuntimeException("No data in an empty tree"), l3, "giveData");
    }
    
    // test the method sameTree in the Leaf Class
    public boolean testSameTreeLeaf(Tester t) {
        return t.checkExpect(l1.sameTree(l1), true)
        && t.checkExpect(l2.sameTree(l2), true)
        && t.checkExpect(l3.sameTree(l3), true)
        && t.checkExpect(l1.sameTree(l2), false)
        && t.checkExpect(l2.sameTree(l3), false)
        && t.checkExpect(l3.sameTree(l1), false)
        && t.checkExpect(l1.sameTree(n1), false)
        && t.checkExpect(l2.sameTree(n1), false)
        && t.checkExpect(l3.sameTree(n1), false);
    }
    
    // test the method sameData in the Leaf Class
    public boolean testSameDataLeaf(Tester t) {
        return t.checkExpect(l1.sameData(l1), true)
        && t.checkExpect(l2.sameData(l2), true)
        && t.checkExpect(l3.sameData(l3), true)
        && t.checkExpect(l1.sameData(l2), false)
        && t.checkExpect(l2.sameData(l3), false)
        && t.checkExpect(l3.sameData(l1), false)
        && t.checkExpect(l1.sameData(n1), false)
        && t.checkExpect(l2.sameData(n1), false)
        && t.checkExpect(l3.sameData(n1), false);
    }
    
    
    // test the method buildList in the Leaf Class
    public boolean testBuildListLeaf(Tester t) {
        return t.checkExpect(l1.buildList(mt), mt)
        && t.checkExpect(l2.buildList(mt), mt)
        && t.checkExpect(l3.buildList(mt), mt)
        && t.checkExpect(l1.buildList(low1), low1)
        && t.checkExpect(l2.buildList(low2), low2)
        && t.checkExpect(l3.buildList(low3), low3);
    }
    
    // test the method sameAsList in the Leaf Class
    public boolean testSameAsListLeaf(Tester t) {
        return t.checkExpect(l1.sameAsList(mt), true)
        && t.checkExpect(l2.sameAsList(mt), true)
        && t.checkExpect(l3.sameAsList(mt), true)
        && t.checkExpect(l1.sameAsList(low1), false)
        && t.checkExpect(l2.sameAsList(low2), false)
        && t.checkExpect(l3.sameAsList(low3), false);
    }
    
    // TEST FOR Node
    
    // test the method insert in the Node Class
    public boolean testInsertNode(Tester t) {
        return t.checkExpect(n12.insert(w1),
        new Node(
        
        w5,
        new Node(
                 w1,
                 n10,
                 new Node(
                          w1,
                          l3,
                          l3)),
        n9))
        &&
        t.checkExpect(n8.insert(w1),
        new Node(
                 w3,
                 new Node(
                          w1,
                          new Node(
                                   w6,
                                   l2,
                                   l2),
                          l2),
        new Node(
                 w2,
                 l2,
                 new Node(
                 w5,
                 l2,
                 new Node(
                 w1,
                 l2,
                 l2)))));
    }
    
    // test the method getFirst in the Node Class
    public boolean testGetFirstNode(Tester t) {
        return t.checkExpect(n12.getFirst(), w6)
        && t.checkExpect(n8.getFirst(), w6)
        && t.checkExpect(n3.getFirst(), w1);
    }

    // test the method getRest in the Node Class
    public boolean testGetRestNode(Tester t) {
        return t.checkExpect(n3.getRest(), 
        new Node(
                 w2,
                 l1,
                 n2))
        && t.checkExpect(n8.getRest(), 
        new Node(
                 w3,
                 new Node(
                          w1,
                          l2,
                          l2),
                 n6))
        && t.checkExpect(n12.getRest(),
        new Node(
        w5,
        new Node(
                 w1,
                 l3,
                 l3),
        n9));
    }

    // test the method isLeaf in the Node Class
    public boolean testIsLeafNode(Tester t) {
        return t.checkExpect(n12.isLeaf(), false)
        && t.checkExpect(n3.isLeaf(), false)
        && t.checkExpect(n8.isLeaf(), false);
    }
    
    // test the method giveLeft in the Node Class
    public boolean testGiveLeftNode(Tester t) {
        return t.checkExpect(n12.giveLeft(), n11)
        && t.checkExpect(n8.giveLeft(), n7)
        && t.checkExpect(n3.giveLeft(), n1);
    }
    
    // test the method giveRight in the Node Class
    public boolean testGiveRightNode(Tester t) {
        return t.checkExpect(n12.giveRight(), n9)
        && t.checkExpect(n8.giveRight(), n6)
        && t.checkExpect(n3.giveRight(), n2);
    }
    
    // test the method giveData in the Node Class
    public boolean testGiveDataNode(Tester t) {
        return t.checkExpect(n12.giveData(), w5)
        && t.checkExpect(n8.giveData(), w3)
        && t.checkExpect(n3.giveData(), w2);
    }
    
    // test the method sameTree in the Node Class
    public boolean testSameTreeNode(Tester t) {
        return t.checkExpect(n12.sameTree(n12), true)
        && t.checkExpect(n12.sameTree(n11), false)
        && t.checkExpect(n12.sameTree(l3), false)
        && t.checkExpect(n8.sameTree(n8), true)
        && t.checkExpect(n8.sameTree(n12), false)
        && t.checkExpect(n8.sameTree(l2), false)
        && t.checkExpect(n3.sameTree(n3), true)
        && t.checkExpect(n3.sameTree(n7), false)
        && t.checkExpect(n3.sameTree(l1), false);
    }
    
    // test the method sameData in the Node Class
    public boolean testSameDataNode(Tester t) {
        return t.checkExpect(n3.sameData(nd), true)
        && t.checkExpect(n3.sameData(n12), false)
        && t.checkExpect(n3.sameData(l3), false)
        && t.checkExpect(n12.sameData(nw), true)
        && t.checkExpect(n12.sameData(n5), false)
        && t.checkExpect(n12.sameData(l1), false)
        && t.checkExpect(n8.sameData(n8), true)
        && t.checkExpect(n8.sameData(n1), false)
        && t.checkExpect(n8.sameData(l1), false);
    }
    
    
    // test the method buildList in the Node Class
    public boolean testBuildListNode(Tester t) {
        return t.checkExpect(n3.buildList(mt), 
        new ConsLoBook(w6, 
        new ConsLoBook(w3,
        new ConsLoBook(w2,
        new ConsLoBook(w1, mt)))))
        && t.checkExpect(n3.buildList(low1), 
        new ConsLoBook(w6, 
        new ConsLoBook(w3,
        new ConsLoBook(w2,
        new ConsLoBook(w1, low1)))))
        && t.checkExpect(n8.buildList(mt), 
        new ConsLoBook(w5, 
        new ConsLoBook(w2,
        new ConsLoBook(w3,
        new ConsLoBook(w1,
        new ConsLoBook(w6, mt))))))
        && t.checkExpect(n8.buildList(low2),
        new ConsLoBook(w5, 
        new ConsLoBook(w2,
        new ConsLoBook(w3,
        new ConsLoBook(w1,
        new ConsLoBook(w6, low2))))))
        && t.checkExpect(n12.buildList(mt), 
        new ConsLoBook(w3, 
        new ConsLoBook(w5,
        new ConsLoBook(w1,
        new ConsLoBook(w6, mt)))))
        && t.checkExpect(n12.buildList(low3),
        new ConsLoBook(w3, 
        new ConsLoBook(w5,
        new ConsLoBook(w1,
        new ConsLoBook(w6, low3)))));
    }
    
    // test the method sameAsList in the Node Class
    public boolean testSameAsListNode(Tester t) {
        return t.checkExpect(n3.sameAsList(mt), false)
        && t.checkExpect(n3.sameAsList(lob8), true);
    }
    
    // TEST FOR MtLoBook
    
    // test the method buildTree in the MtLoBook Class
    public boolean testBuildTreeMT(Tester t) {
    
        return t.checkExpect(mt.buildTree(n8), n8)
        && t.checkExpect(mt.buildTree(n12), n12)
        && t.checkExpect(mt.buildTree(n3), n3);
        
    }
    
    // test the method getFirst in the MtLoBook Class
    public boolean testGetFirstMT(Tester t) {
    
    return t.checkException(new RuntimeException("No first in an empty list"),
           mt, "getFirst");
}
    
    // test the method getRest in the MtLoBook Class
    public boolean testGetRestMT(Tester t) {
    
    return t.checkException(new RuntimeException("No rest in an empty list"),
    mt, "getRest");
    
}
    
    // test the method isEmpty in the MtLoBook Class
    public boolean testIsEmptyMT(Tester t) {
    
    return t.checkExpect(mt.isEmpty(), true);
    
}
    
    // TEST FOR ConsLoBook
    
    // test the method buildTree in the MtLoBook Class
    public boolean testBuildTreeCons(Tester t) {
    
        return t.checkExpect(lobx.buildTree(l3),
        new Node(
                 w6,
                 l3,
                 new Node(
                 w1,
                 l3,
                 l3)));
        
    }
    
    // test the method getFirst in the MtLoBook Class
    public boolean testGetFirstCons(Tester t) {
    
        return t.checkExpect(low1.getFirst(), w1)
        && t.checkExpect(low4.getFirst(), w6);
        
    }
    
    // test the method getRest in the MtLoBook Class
    public boolean testGetRestCons(Tester t) {
    
        return t.checkExpect(low1.getRest(), mt)
        && t.checkExpect(low4.getRest(), low3);
    
    }
    
    // test the method isEmpty in the MtLoBook Class
    public boolean testIsEmptyCons(Tester t) {
    
        return t.checkExpect(low1.isEmpty(), false);
  
    }
    
}
