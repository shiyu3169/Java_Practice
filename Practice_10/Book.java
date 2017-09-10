// assignment 9
// pair p134
// Singh, Bhavneet
// singhb
// Wang, Shiyu
// shiyu

// Represents a Book
public class Book implements MakeString, IValue {
    String title;
    String author;
    int price;     // in dollars
    
    public Book(String title, String author, int price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }
    
    /* Template
     *   Fields
     *     ... this.title ...       -- String
     *     ... this.author ...      -- String
     *     ... this.price ...       -- int
     *
     *   Methods 
     *     ... this.value() ...       -- int
     *     ... this.makeString() ...  -- String
     *     ... authorName() ...       -- String
     */
    
    // Compute the value of this Book, i.e., its price
    public int value() {
        return this.price;
    }
    
    // Make a String of this Book
    public String makeString() {
        return "Book: " + this.title + " by "
        + this.author + "\ncosts: $" + this.price;
    }
}