import java.util.Comparator;

// assignment 8
// pair p134
// Singh, Bhavneet
// singhb
// Wang, Shiyu
// shiyu

// This class represents a sentinel
class SentinelT<T> extends NodeT<T> {
   public SentinelT() {
        super(null, null, null);
        this.next = this;
        this.prev = this;
    }
   /*TEMPLATE
    * FIELDS:
    * this.data............................""
    * this.next............................this
    * this.prev............................this
    * 
    * METHODS:
    * this.isSentinel()................boolean
    * this.addNext(Node)..................void
    * this.addPrev(Node)..................void
    * this.size()..........................int
    * this.addAtHead(String)..............void
    * this.addDtTail(String)..............void
    * this.removeFromHead()...............void
    * this.removeFromTail()...............void
    * this.getFirst().....................Node
    * this.getLast()......................Node
    * this.removeSorted(String)...........void
    * this.insertSorted(String)...........void
    * 
    * METHODS FOR FIELDS
    * this.prev.size().................... int
    * this.next.addprev(Node).............void
    * this.next.isSentinel()...........boolean
    * this.prev.addnext(Node).............void
    * this.next.removeFromHead(String)....void
    * this.prev.removeFromTail(String)....void
    * this.prev.insertSorted(String)......void
    * this.prev.removeSorted(String)......void
    * 
    */
 //EFFECT
   //change next into given node.
    void addNext(NodeT<T> node) {
        this.next = node;
    }
  //EFFECT
    //change prev into given node.
    void addPrev(NodeT<T> node) {
        this.prev = node;
    }
  //determine whether it is this a Sentinel
    public boolean isSentinel() {
        return true;
    }
  //counts the number of nodes in a list Deque
    public int size() {
        if (this.prev.isSentinel())
        return 0;
        else return this.prev.size();
    }
    
  //EFFECT
    //inserts a string at the front of the list
    void addAtHead(T s) {
      
            this.next.addPrev(new NodeT<T>(s, this.next, this));
            this.next = this.next.prev;
       
           
            
     }
  //EFFECT
    //remove the first node of the list
    public void removeFromHead() {
        if (this.next.isSentinel() &&
            this.next.prev.isSentinel())
            throw new RuntimeException
            ("Cannot remove the first of an empty list");
        else this.next.next.removeFromHead(this);
            this.next = new NodeT<T>
                    (this.next.next.data, this.next.next.next, this);
             
    }
    //EFFECT
    //inserts a string at the end of the list
    void addAtTail(T s) {
    
            this.prev.addNext(new NodeT<T>(s, this, this.prev));
            this.prev = this.prev.next;
           
            
    }
    //EFFECT
    //remove the last node of the list
    public void removeFromTail() {
        if (this.next.isSentinel() &&
            this.next.prev.isSentinel())
            throw new RuntimeException
            ("Cannot remove the last of an empty list");
        else this.prev.prev.removeFromTail(this);
            this.prev = new NodeT<T>
                    (this.prev.prev.data, this, this.prev.prev.prev);
             
    }
  //get the first node of the list
    public NodeT<T> getFirst() {
        if (this.next.isSentinel())
            throw new RuntimeException
            ("Cannot get the first of an empty list");
        else return this.next;
    }
  //get the last node of the list
    public NodeT<T> getLast() {
        if (this.prev.isSentinel())
            throw new RuntimeException
            ("Cannot get the last of an empty list");
        else return this.prev;
    }
    //EFFECT
    //insert the node with given data into right place of sorted list
    public void insertSorted(T s, Comparator<T> comp) {
        if (this.prev.isSentinel() ||
           (comp.compare(this.prev.data, s) <= 0))
            addAtTail(s);
        else this.prev.insertSorted(s, comp);
      
            
    }
  //EFFECT
    //remove the node with given data
    public void removeSorted(T s,  Comparator<T> comp) {
        if (this.prev.isSentinel())
            throw new RuntimeException("No such String in the list");
        
        else this.prev.removeSorted(s, comp);
        
    }
    
}
