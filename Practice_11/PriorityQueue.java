import java.util.*;

// Represents a heap-based priority queue
class PriorityQueue<T> {
    ArrayList<T> list;
    Comparator<T> comp;
    PriorityQueue(ArrayList<T> list, Comparator<T> comp) {
        this.list = list;
        this.comp = comp;
    }
    /*TEMPLATE
     * Fields:
     * this.list...  --ArrayList<T>
     * this.comp...  --Comparator<T>
     * 
     * Methods
     * this.isLeaf(int)... --boolean
     * this.higherPriorityChild... --int
     * this.insert(T).... --void
     * this.parent(int)... int
     * this.remove()....T
     * this.swap(int int)...void
     * 
     * Methods for Field:
     * this.list.size()... int
     * this.list.get(int)....T
     * this.list.set(int, T)...void
     * 
     */
    
    // consumes a node label (an int)
    // and returns true if the node 
    // has no children
    public boolean isLeaf(int nodelabel) {
        return (((2 * nodelabel) + 1) > (this.list.size()));
    }
    
    // consumes a node label of a node and produces it's highest priority child
    // if it is a leaf then throw an exception
    public int higherPriorityChild(int nodelabel) {
        if (this.isLeaf(nodelabel) || nodelabel == 0)
            throw new RuntimeException("this node has no children");
        if ((nodelabel * 2 + 1) <= this.list.size() - 1
                &&
                ((comp.compare(this.list.get(2 * nodelabel + 1),
                              this.list.get(2 * nodelabel))) > 0))
            return 2 * nodelabel + 1;
        
        else return 2 * nodelabel;
                  
    }
    
    
    // EFFECT: insert the node into this heap 
    void insert(T x) {
        Integer i = this.list.size();
        this.list.add(x);
        
        for (int j = i; j > 1; j = this.parent(j))
            if (comp.compare(this.list.get(j),
                    this.list.get(this.parent(j))) > 0) {
                this.swap(j, this.parent(j)); }
            
        
            }
    
    
    //Compute the index of the parent of index i.
    int parent(int i) {
        if (0 == i % 2)
        return (Integer)(i / 2);
        else return  ((i - 1) / 2);
     }
    
    //EFFECT: swaping  the elements at index i and j
    void swap (int i, int j) {
        this.list.set(j, this.list.set(i, this.list.get(j)));
    }
    
    
    //EFFECT: node with the highest priority in the heap
    //produce the highest priority elements 
    public T remove() {
        T temporary = this.list.get(1);
        int q = 1;
        
        
        this.list.set(1, this.list.remove(this.list.size() - 1));
        

         while (!this.isLeaf(q)) {
             int w = this.higherPriorityChild(q);
             if (comp.compare(this.list.get(q), this.list.get(w)) < 0)
             {
              swap(q, w);
              q = w;
               }
              else break;
}
            
            return  temporary;
       
    }
    
   
    
    
    
}

//Represent an Integer Comparator
class ComparatorBySize implements Comparator<Integer> {
    
    /* TEMPLATE
     * Fields:
     * No Fields
     * 
     * Methods:
     * this.compare(int, int)... --int
     * 
     * Methods for Fields:
     * Built-in
     * 
     * 
     */
    
    // compares the two given integers by size, returns an int
    // based on which number is larger
    public int compare(Integer i1, Integer i2) {
        return i1 - i2;
    }
    
}