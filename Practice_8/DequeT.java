import java.util.Comparator;


//assignment 8
//pair p134
//Singh, Bhavneet
//singhb
//Wang, Shiyu
//shiyu

// this class represents a deque
class DequeT<T> {
    SentinelT<T> node;
  public DequeT( ) {
        this.node = new SentinelT <T>( );
    }
  /*TEMPLATE
   * FIELDS:
   * this.node.......................Sentinel
   * 
   * METHODS:
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
   * METHODS FOR FIELDS:
   * this.node.size()..........................int
   * this.node.addAtHead(String)..............void
   * this.node.addDtTail(String)..............void
   * this.node.removeFromHead()...............void
   * this.node.removeFromTail()...............void
   * this.node.getFirst().....................Node
   * this.node.getLast()......................Node
   * this.node.removeSorted(String)...........void
   * this.node.insertSorted(String)...........void
   */
//counts the number of nodes in a list Deque
    public int size() {
        return this.node.size();
    }
    //EFFECT
    //inserts a string at the front of the list
    public void addAtHead(T s) {
        this.node.addAtHead(s);
    }
  //EFFECT
    //remove the first node of the list
    public void removeFromHead() {
        this.node.removeFromHead();
    }
  //EFFECT
    //inserts a string at the end of the list
    public void addAtTail(T s) {
        this.node.addAtTail(s);
    }
  //EFFECT
    //remove the last node of the list
    public void removeFromTail() {
        this.node.removeFromTail();
    }
    //get the first node of the list
    public NodeT<T> getFirst() {
        return this.node.getFirst();
    }
  //get the last node of the list
    public NodeT<T> getLast() {
        return this.node.getLast();
    } 
    //EFFECT
    //remove the node with given data
    public void removeSorted(T s, Comparator<T> comp) {
        this.node.removeSorted(s, comp);
    }
  //EFFECT
    //insert the node with given data into right place of sorted list
    public void insertSorted(T s,  Comparator<T> comp) {
        this.node.insertSorted(s, comp);
    }
    
}
