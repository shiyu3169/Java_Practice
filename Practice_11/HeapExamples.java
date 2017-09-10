import java.util.*;

// This class represents three examples of heaps
class HeapExamples {
    
    // sample heaps
    ArrayList<Integer> myheap;
    ArrayList<Integer> myheap2;
    ArrayList<Integer> myheap3;
    ArrayList<Integer> myheap4;
    
    void reset() {
        myheap = new ArrayList<Integer>();
        myheap2 = new ArrayList<Integer>();
        myheap3 = new ArrayList<Integer>();
        myheap4 = new ArrayList<Integer>();
    }
    
    // initialize the heap data
    void initHeaps() {

        reset();
        
      this.myheap.add(null); // the unused first item
      this.myheap.add(80);
      this.myheap.add(50);
      this.myheap.add(40);
      this.myheap.add(45);
      this.myheap.add(20);
      this.myheap.add(30);

      
      this.myheap2.add(null); // the unused first item
      this.myheap2.add(50);
      this.myheap2.add(45);
      this.myheap2.add(40);
      this.myheap2.add(30);
      this.myheap2.add(20);
      
      this.myheap3.add(null); // the unused first item
      this.myheap3.add(70);
      this.myheap3.add(45);
      this.myheap3.add(50);
      this.myheap3.add(30);
      this.myheap3.add(20);
      this.myheap3.add(40);   
      
      this.myheap4.add(null);
      
    }
    
}
