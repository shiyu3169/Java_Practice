// assignment 4
// pair 043
// Wright Steven
// wrights
// Wang Shiyu
// shiyu

interface IBook {
    // computes days overdue. if not due returns negative number
    // of days remaining
    public int daysOverdue(int today);
    
    // returns true if book is overdue
    public boolean isOverdue(int today);
    
    // computes the fine of an overdue book
    public int computeFine(int today);
};

abstract class ABook implements IBook {
    String title;
    int    dayTaken;
    
    ABook(String title, int dayTaken) {
        this.title = title;
        this.dayTaken = dayTaken;
    }
    
    // computes days overdue. If not due gives negative number
    // with days remaining
    public int daysOverdue(int today) {
        return today - dayTaken - 14;
    }
    
    // returns true if book is overdue
    public boolean isOverdue(int today) {
        if (this.daysOverdue(today) > 0)
            return true;
        else 
            return false;
    }
    
    // returns fine in cents of book if overdue
    public int computeFine(int today) {
        if (this.daysOverdue(today) > 0)
            return this.daysOverdue(today) * 10;
        else
            return 0;
    }
}

class Book extends ABook {
    String author;
    Book(String title, String author, int dayTaken) {
        super(title, dayTaken);
        this.author = author;
    }
}

class RefBook extends ABook {
    RefBook(String title, int dayTaken) {
        super(title, dayTaken);
    }
    
    // returns days overdue for reference books
    public int daysOverdue(int today) {
        return today - dayTaken - 2;
    }
}

class AudioBook extends ABook {
    String author;
    AudioBook(String title, String author, int dayTaken) {
        super(title, dayTaken);
        this.author = author;
    }
    
    // returns fine in cents of book if audio book is overdue
    public int computeFine(int today) {
        if (this.daysOverdue(today) > 0)
            return this.daysOverdue(today) * 20;
        else
            return 0;
    }
}

