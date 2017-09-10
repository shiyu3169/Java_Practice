// assignment 6
// pair p134
// Singh, Bhavneet
// singhb
// Wang, Shiyu
// shiyu

//this abstract class represents a binary-search-tree of books
abstract class ABST {
    IBookComparator order;

    ABST(IBookComparator order) {
        this.order = order;
    
    }
    
    // insert the given Book into this binary-search-tree
    public abstract ABST insert(Book given);
    
    // give the first book of this binary-search-tree
    public abstract Book getFirst();
    
    //give the rest of this binary-search-tree
    public abstract ABST getRest();
    
    // is this binary-search-tree a leaf?
    public abstract boolean isLeaf();
    
    // give the left of this binary-search-tree
    public abstract ABST giveLeft();

    // give the right of this binary-search-tree
    public abstract ABST giveRight();
    
    // give the data of this leaf
    public abstract Book giveData();

    // is this binary-search-tree the same as the given one?
    public abstract boolean sameTree(ABST given);
    
    // does this binary-search-tree have the same data as the given one?
    public abstract boolean sameData(ABST given);
    
    // build a List of Books out of this binary-search-tree
    public abstract ILoBook buildList(ILoBook given);
    
    // is this binary-search-tree the same as the given list of books 
    // (same order)?
    public abstract boolean sameAsList(ILoBook given);
    
}



// this class represents a leaf
class Leaf extends ABST {
   
	Leaf(IBookComparator order) {
        super(order);
  
	}
	
	/* TEMPLATE:
     * 
     * FIELDS:
     * 
     * ...this.order...                              -- IBookComparator
     * 
     * METHODS:
     * 
     * ...this.insert(Book)...                       -- ABST
     * ...this.getFirst()...                         -- Book
     * ...this.getRest()...                          -- ABST
     * ...this.isLeaf()...                           -- Boolean
     * ...this.giveLeft()...                         -- ABST
     * ...this.giveRight()...                        -- ABST
     * ...this.giveData()...                         -- Book
     * ...this.sameTree(ABST)...                     -- Boolean
     * ...this.sameData(ABST)...                     -- Boolean
     * ...this.buildList(ILoBook)...                 -- ILoBook
     * ...this.sameAsList(ILoBook)...                -- Boolean
     * 
     * METHODS FOR FIELDS:
     * ...this.order.compare(Book, Book)...          --int
     * 
     */
  
    // insert the given Book into this leaf
    public ABST insert(Book given) {
     
    	return new Node(given, this, this);
    
    }

    
    
    // give the first book of this leaf
    public Book getFirst() {
      
    	throw new RuntimeException("No first in an empty tree");
    
    }
    
    
    
    //give the rest of this leaf
    public ABST getRest() {
    
    	throw new RuntimeException("No rest of an empty tree");
    
    }
    
    
    
    // is this binary-search-tree a leaf?
    public boolean isLeaf() {
    
    	return true;
    
    }
   
    
    
    // give the left of this leaf
    public ABST giveLeft() {
    
    	throw new RuntimeException("No left in an empty tree");
    
    }

    
    
    // give the right of this leaf
    public ABST giveRight() {
    
    	throw new RuntimeException("No right in an empty tree");
    
    }

    
    
    // give the data of this leaf
    public Book giveData() {
    
    	throw new RuntimeException("No data in an empty tree");
    
    }
    
    
    
    // is this leaf the same as the given binary-search-tree?
    public boolean sameTree(ABST given) {
    
    	return given.isLeaf() && this.order.equals(given.order);
    
    }
    
    
    
    //does this leaf contain the same data as the given binary-search-tree?
    public boolean sameData(ABST given) {
    
    	return given.isLeaf() && this.order.equals(given.order);
    
    }
    
    
    
    // build a List of Books out of this binary-search-tree
    public ILoBook buildList(ILoBook given) {
    
    	return given;
    
    }
    
    
    
    // is this leaf the same as the given list of books?
    public boolean sameAsList(ILoBook given) {
    
    	return given.isEmpty();
    
    }
    
}


// this class represents a node
class Node extends ABST {
 
	Book data;
    ABST left;
    ABST right;

    Node(Book data, ABST left, ABST right) {
        
    	super(left.order);
        this.data = data;
        this.left = left;
        this.right = right;
   
    }
    
    /* TEMPLATE:
     * 
     * FIELDS:
     * 
     * ...this.order...                              -- IBookComparator
     * ...this.data...                               -- Book
     * ...this.left...                               -- ABST
     * ...this.right...                              -- ABST
     * 
     * METHODS:
     * 
     * ...this.insert(Book)...                       -- ABST
     * ...this.getFirst()...                         -- Book
     * ...this.getRest()...                          -- ABST
     * ...this.isLeaf()...                           -- Boolean
     * ...this.giveLeft()...                         -- ABST
     * ...this.giveRight()...                        -- ABST
     * ...this.giveData()...                         -- Book
     * ...this.sameTree(ABST)...                     -- Boolean
     * ...this.sameData(ABST)...                     -- Boolean
     * ...this.buildList(ILoBook)...                 -- ILoBook
     * ...this.sameAsList(ILoBook)...                -- Boolean
     *
     * METHODS FOR FIELDS:
     * 
     * ...this.order.compare(Book, Book)...          -- int
     * ...this.left.isLeaf()...                      -- Boolean
     * ...this.left.getFirst()...                    -- Book
     * ...this.left.getRest()...                     -- ABST
     * ...this.left.insert(Book)...                  -- ABST
     * ...this.left.sameTree(ABST)...                -- ABST
     * ...this.right.isLeaf()...                      -- Boolean
     * ...this.right.getFirst()...                    -- Book
     * ...this.right.getRest()...                     -- ABST
     * ...this.right.insert(Book)...                  -- ABST
     * ...this.right.sameTree(ABST)...                -- ABST
     *
     */

    // give the first of this node
    public Book getFirst() {
        
    	if (this.left.isLeaf())
        
        	return this.data;
    
        else return this.left.getFirst();
    }
    
    
    
    // give the rest of this node
    public ABST getRest() {
        
    	if (this.left.isLeaf())
    
        	return this.right;
    
        else return new Node(this.data,
        this.left.getRest(), this.right);
    
    }

    
    
    // is this node a leaf?
    public boolean isLeaf() {

    	return false;
    
    }
    
    
    
    // insert the given Book into this node
    public ABST insert(Book given) {
       
    	if (this.order.compare(this.data, given) < 0)
        	
        return new Node(this.data,
        this.left.insert(given), this.right);
        
        else return new Node(this.data,
        this.left, this.right.insert(given));
    	
    }

    
    
    // give the left of this node
    public ABST giveLeft() {
    	
        return this.left;
    
    }

    
    
    // give the right of this node
    public ABST giveRight() {
    	
        return this.right;
    
    }
    
    
    
    // give the data of this node
    public Book giveData() {
    	
    	return this.data;
    
    }
    
    
    
    // is this node the same as the given binary-search-tree?
    public boolean sameTree(ABST given) {
    	
        if (given.isLeaf())
        	
            return false;
        
        else if (this.data.equals(given.giveData()))
        	
                 return (this.left.sameTree(given.giveLeft()) 
                 
                 && this.right.sameTree(given.giveRight()));
        
                 else return false;
        
    }
    
    
     
    // does this node have the same data as the given binary-search-tree?
    public boolean sameData(ABST given) {
        
        if (given.isLeaf())
        
        return false;
    	
        else return this.getFirst().equals(given.getFirst()) && 
        
        this.getRest().sameData(given.getRest());
    
    }
    
    // build a List of Books out of this binary-search-tree
    public ILoBook buildList(ILoBook given) {
    
    	return this.getRest().buildList(
    	new ConsLoBook(this.getFirst(), given));
    
    }
    
    // is this leaf the same as the given list of books?
    public boolean sameAsList(ILoBook given) {
    
    	return !given.isEmpty() 
    	
    	&& this.getFirst().equals(given.getFirst())
    	
    	&& this.getRest().sameAsList(given.getRest());
    	
    	}

}



// this interface represents a way to pass methods as arguments
// to methods dealing with books
interface IBookComparator {

    // compares two given books on some basis
    public int compare(Book b1, Book b2);

}



// this class represents a method to compare books by title
class BooksByTitle implements IBookComparator {

    /*TEMPLATE:
     * FIELDS:
     * None
     * 
     * METHODS:
     * ...this.compare(book, book)...           -- int
     * 
     * 
     * METHODS FOR FIELDS
     * Built-in
     */

    // compares two given books by title
    public int compare(Book b1, Book b2) {
        
    	return b2.title.compareTo(b1.title);

    }

}



// this class represents a method to compare books by author
class BooksByAuthor implements IBookComparator {

    
    /*TEMPLATE:
     * FIELDS:
     * None
     * 
     * METHODS:
     * ...this.compare(book, book)...           -- int
     * 
     * 
     * METHODS FOR FIELDS
     * Built-in
     */
    
    // compares two given books by author
    public int compare(Book b1, Book b2) {
       
    	return b2.author.compareTo(b1.author);
    
    }

}


// this class represents a method to compare books by price
class BooksByPrice implements IBookComparator {

    
    /*TEMPLATE:
     * FIELDS:
     * None
     * 
     * METHODS:
     * ...this.compare(book, book)...           -- int
     * 
     * 
     * METHODS FOR FIELDS
     * Built-in
     */

    // compares two given books by price
    public int compare(Book b1, Book b2) {
      
    	return b1.price - b2.price;
    
    }
    
}



// this class represents a book
class Book {
	
    String title;
    String author;
    int price;

    Book(String title, String author, int price) {
        this.title = title;
        this.author = author;
        this.price = price;
   
    }
    
    /*TEMPLATE:
     * FIELDS:
     * ...this.title...                   --String
     * ...this.auhor...                   --String
     * ...this.price...                   --int
     * 
     * METHODS:
     * None
     * 
     * 
     * METHODS FOR FIELDS
     * Built-in
     */
 
}



// this interface represents a ILoBook
interface ILoBook {
	
	// make an ordered binary-search-tree out of this list of books
	public ABST buildTree(ABST tree);
	
	// give the first of this list of books
	public Book getFirst();
	
	// give the rest of this list of books
	public ILoBook getRest();
	
	// is this list of books empty?
	public boolean isEmpty();
	
}



//this class represents a MtLoBook
class MtLoBook implements ILoBook {
	
    /*TEMPLATE:
     * FIELDS:
     * None
     * 
     * METHODS:
     * ...this.buildTree(ABST)...         -- ABST
     * ...this.getFirst()...              -- Book
     * ...this.getRest()...               -- ILoBook 
     * ...this.isEmpty()...               -- Boolean 
     *
     * METHODS FOR FIELDS
     * Built-in
     */
    
	// make an ordered binary-search-tree out of this empty list of books
	public ABST buildTree(ABST tree) {
		
		return tree;
		
	}
    
	
	
    // give the first of this list of books
    public Book getFirst() {
    
    throw new RuntimeException("No first in an empty list");
    
    }
    
    
    
    // give the rest of this list of books
    public ILoBook getRest() {
    
    throw new RuntimeException("No rest in an empty list");
    
    }
    
    
    
    // is this list of books empty?
    public boolean isEmpty() {
    
    return true;
    
    }
	
    
    
}



// this class represents a ConsLoBook
class ConsLoBook implements ILoBook{
	
	Book first;
	ILoBook rest;
	
	ConsLoBook(Book first, ILoBook rest) {
		this.first = first;
		this.rest = rest;
		
	}
	
    /*TEMPLATE:
     * FIELDS:
     * None
     * 
     * METHODS:
     * ...this.buildTree(ABST)...         -- ABST
     * ...this.getFirst()...              -- Book
     * ...this.getRest()...               -- ILoBook 
     * ...this.isEmpty()...               -- Boolean 
     * 
     * 
     * METHODS FOR FIELDS
     * ...this.rest.buildTree(ABST)...         -- ABST
     * ...this.rest.getFirst()...              -- Book
     * ...this.rest.getRest()...               -- ILoBook 
     * ...this.rest.isEmpty()...               -- Boolean 
     */
	
	// make an ordered binary-search-tree out of this empty list of books
		public ABST buildTree(ABST tree) {
			
			return this.rest.buildTree(tree.insert(this.first));
			
		}
	

	// give the first of this list of books
	public Book getFirst() {
	
	    return this.first;
	}
	    
	// give the rest of this list of books
	public ILoBook getRest() {
	    
	    return this.rest;
	    
	}
	    
	// is this list of books empty?
	public boolean isEmpty() {
	    
	return false;
	
	}

}



