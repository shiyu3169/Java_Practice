// assignment 8
// pair p134
// Singh, Bhavneet
// singhb
// Wang, Shiyu
// shiyu

// This class represents a node
class Node {
    String data;
    Node next;
    Node prev;
   public Node(String data, Node next, Node prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
   
   /*TEMPELATE
    * FIELDS:
    * this.data.......data
    * this.next.......node
    * 
    * METHODS:
    * this.addNext(Node)....................void
    * this.addPrev(Node)....................void
    * this.isSentinel()..................Boolean
    * this.size()............................int
    * this.removeFromHead(Sentinel).........void
    * this.insertSorted(String).............void
    * this.removeFromTail(String, Sentinel).void
    * this.removeSorted(String).............void
    * 
    * METHODS FOR FIELDS:
    * this.prev.isSentinel()................void
    * this.prev.size().......................int
    * this.prev.addNext(Node)...............void
    * this.prev.insertSorted(s).............void
    * this.prev.removeSorted(s).............void
    */
    
    //EFFECT
    //change next into given node.
    void addNext(Node node) {
        this.next = node;
    }
    //EFFECT
    //change prev into given node.
    void addPrev(Node node) {
        this.prev = node;
    }
    //determine whether it is this a Sentinel
    public boolean isSentinel() {
        return false;
    }
   //counts the number of nodes in a list Deque
    public int size() {
        if (this.prev.isSentinel())
            return 1;
            else return 1 + this.prev.size();
    }
    
    
    //EFFECT
    //remove the first node of the list
    void removeFromHead(Sentinel sent) {
       this.prev = sent;
        
    }
    
    //EFFECT
    //insert the node with given data into right place of sorted list
    void insertSorted(String s) {
        if (this.prev.isSentinel() ||
           (this.prev.data.compareTo(s) <= 0))
            { this.prev.addNext(new Node(s, this, this.prev));
              this.prev = this.prev.next; }
        else this.prev.insertSorted(s);
            
    }
    //EFFECT
    //remove the last node of the list
    void removeFromTail(Sentinel sent) {
        this.next = sent;
         
     }
    //EFFECT
    //remove the node with given data
    public void removeSorted(String s) {
        if (this.data.equals(s))
        { this.prev.next = this.next;
          this.next.prev = this.prev; }
       else if (this.prev.isSentinel())
           throw new RuntimeException("No such String in the list");
           
       else   
            this.prev.removeSorted(s);
        
    }
                
   
}
