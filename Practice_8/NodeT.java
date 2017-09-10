import java.util.Comparator;

// assignment 8
// pair p134
// Singh, Bhavneet
// singhb
// Wang, Shiyu
// shiyu

// This class represents a node
class NodeT<T> {
    T data;
    NodeT<T> next;
    NodeT<T> prev;

    public NodeT(T data, NodeT<T> next, NodeT<T> prev) {
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
        return false;
    }
  //counts the number of nodes in a list Deque
    public int size() {
        if (this.prev.isSentinel())
            return 1;
        else
            return 1 + this.prev.size();
    }
  //EFFECT
    //remove the first node of the list
    void removeFromHead(SentinelT<T> sent) {
        this.prev = sent;

    }
    //EFFECT
    //insert the node with given data into right place of sorted list
    void insertSorted(T s, Comparator<T> comp) {
        if (this.prev.isSentinel() ||
                (comp.compare(this.prev.data, s) <= 0)) {
            this.prev.addNext(new NodeT<T>(s, this, this.prev));
            this.prev = this.prev.next;
        } else
            this.prev.insertSorted(s, comp);

    }
  //EFFECT
    //remove the last node of the list
    void removeFromTail(SentinelT<T> sent) {
        this.next = sent;

    }
  //EFFECT
    //remove the node with given data
    public void removeSorted(T s, Comparator<T> comp) {
        if (comp.compare(this.data, s) == 0) {
            this.prev.next = this.next;
            this.next.prev = this.prev;
        } else if (this.prev.isSentinel())
            throw new RuntimeException("No such String in the list");

        else
            this.prev.removeSorted(s, comp);

    }

}
