import java.util.*;
import tester.*;

// This class represents testing for heap and associated methods/classes
class ExamplesHeap {

    // sample heaps
    HeapExamples heap = new HeapExamples();

    // sample comparators
    ComparatorBySize ci = new ComparatorBySize();
    
    // sample priority queues
    PriorityQueue<Integer> p1;
    PriorityQueue<Integer> p2;
    PriorityQueue<Integer> p3;
    PriorityQueue<Integer> p4;
    
    // initialize priority queues
    void initPriority() {
        p1 = new PriorityQueue<Integer>(heap.myheap, ci);
        p2 = new PriorityQueue<Integer>(heap.myheap2, ci);
        p3 = new PriorityQueue<Integer>(heap.myheap3, ci);
        p4 = new PriorityQueue<Integer>(heap.myheap4, ci);
    }
    
    // Test the method isLeaf in the PriorityQueue Class
    void testIsLeaf(Tester t) {
        
        heap.initHeaps();
        this.initPriority();
        
        t.checkExpect(p1.isLeaf(0), false);
        t.checkExpect(p1.isLeaf(1), false);
        t.checkExpect(p1.isLeaf(2), false);
        t.checkExpect(p1.isLeaf(3), false);
        t.checkExpect(p1.isLeaf(4), true);
        t.checkExpect(p1.isLeaf(5), true);
        t.checkExpect(p1.isLeaf(6), true);
        
        t.checkExpect(p2.isLeaf(0), false);
        t.checkExpect(p2.isLeaf(1), false);
        t.checkExpect(p2.isLeaf(2), false);
        t.checkExpect(p2.isLeaf(3), true);
        t.checkExpect(p2.isLeaf(4), true);
        t.checkExpect(p2.isLeaf(5), true);
        
        t.checkExpect(p3.isLeaf(0), false);
        t.checkExpect(p3.isLeaf(1), false);
        t.checkExpect(p3.isLeaf(2), false);
        t.checkExpect(p3.isLeaf(3), false);
        t.checkExpect(p3.isLeaf(4), true);
        t.checkExpect(p3.isLeaf(5), true);
        t.checkExpect(p3.isLeaf(6), true);
    }
    
    // Test the method highestPriorityChild in the PriorityQueue Class
    void testHighest(Tester t) {
        
        heap.initHeaps();
        this.initPriority();

        t.checkException(new RuntimeException(
                "this node has no children"), p1, "higherPriorityChild", 0);
        t.checkExpect(p1.higherPriorityChild(1), 2);
        t.checkExpect(p1.higherPriorityChild(2), 4);
        t.checkExpect(p1.higherPriorityChild(3), 6);
        t.checkException(new RuntimeException(
                "this node has no children"), p1, "higherPriorityChild", 4);
        t.checkException(new RuntimeException(
                "this node has no children"), p1, "higherPriorityChild", 5);
        t.checkException(new RuntimeException(
                "this node has no children"), p1, "higherPriorityChild", 6);
        
        t.checkException(new RuntimeException(
                "this node has no children"), p2, "higherPriorityChild", 0);
        t.checkExpect(p2.higherPriorityChild(1), 2);
        t.checkExpect(p2.higherPriorityChild(2), 4);
        t.checkException(new RuntimeException(
                "this node has no children"), p2, "higherPriorityChild", 3);
        t.checkException(new RuntimeException(
                "this node has no children"), p2, "higherPriorityChild", 4);
        t.checkException(new RuntimeException(
                "this node has no children"), p2, "higherPriorityChild", 5);
        
        t.checkException(new RuntimeException(
                "this node has no children"), p3, "higherPriorityChild", 0);
        t.checkExpect(p3.higherPriorityChild(1), 3);
        t.checkExpect(p3.higherPriorityChild(2), 4);
        t.checkExpect(p3.higherPriorityChild(3), 6);
        t.checkException(new RuntimeException(
                "this node has no children"), p3, "higherPriorityChild", 4);
        t.checkException(new RuntimeException(
                "this node has no children"), p3, "higherPriorityChild", 5);
        t.checkException(new RuntimeException(
                "this node has no children"), p3, "higherPriorityChild", 6);
        
        }
    
    //test the parent method
    void testParent(Tester t) {
        heap.initHeaps();
        this.initPriority();
        
        t.checkExpect(p1.parent(4), 2);
        t.checkExpect(p1.parent(2), 1);
        t.checkExpect(p1.parent(5), 2);
    }
    
    //test the insert methid
    void testInsert(Tester t) {
        heap.initHeaps();
        this.initPriority();
        
        //sample arrayList
        ArrayList<Integer> a = new ArrayList<Integer>();
        
        p4.insert(5);
        a.add(null);
        a.add(5);
        t.checkExpect(p4.list, a);
        
        a.add(3);
        p4.insert(3);
        t.checkExpect(p4.list, a);
        
        p4.insert(10);
        a.set(1, 10);
        a.add(5);
        t.checkExpect(p4.list, a);
        
        p4.insert(8);
        a.set(2, 8);
        a.add(3);
        t.checkExpect(p4.list, a);
        
        
    }
    
    //test the remove method
    void testRemove(Tester t) {
        heap.initHeaps();
        this.initPriority();
        //sample arrayList
        ArrayList<Integer> b = new ArrayList<Integer>();
        ArrayList<Integer> c = new ArrayList<Integer>();
        ArrayList<Integer> d = new ArrayList<Integer>();
        
        b.add(null);
        b.add(50);
        b.add(45);
        b.add(40);
        b.add(30);
        b.add(20);
                
        c.add(null);
        c.add(45);
        c.add(30);
        c.add(40);
        c.add(20);
        
        d.add(null);
        d.add(50);
        d.add(45);
        d.add(40);
        d.add(30);
        d.add(20);
        
       
       t.checkExpect(p1.remove(), 80);
       t.checkExpect(p1.list, b);
       
       t.checkExpect(p2.remove(), 50);
       t.checkExpect(p2.list, c);
       
       t.checkExpect(p3.remove(), 70);
       t.checkExpect(p3.list, d);
        
        
    }
}
