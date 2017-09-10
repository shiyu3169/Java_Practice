// assignment 10
// pair p134
// Singh, Bhavneet
// singhb
// Wang, Shiyu
// shiyu

// An interface for classes that can compute their value
interface IValue {
    // Compute the value of this instance
    public int value();
}

// An interface for classes that can represent their values as a String
interface MakeString {
    // produce a String that represents this object
    public String makeString();
}

// Represents a list of items of type T
interface ILo<T> {

    // Compute the total size (length) of this list
    public int size();

    // Compute the total value of the items in this list
    public int totalValue();

    // accept the visitor that produces the result of the type R
    public <R> R accept(ILoVisitor<R, T> ilov);
    
    // make a string of this list
    public ILo<String> makeStrings();
}

// Represents an empty list of items of type T
class MtLo<T> implements ILo<T> {
     
    /*Template
     * Fields:
     * No fields
     * 
     * Methods:
     * this.size()....  -- int
     * this.totalValue()... int
     * this.accepet(ILoVisitor<R, T>)... -- R
     * this.makeStrings()...  --ILo<String>
     * 
     * Methods for Fields
     * Built-in
     * 
     */
   
    MtLo() {
    }

    // Compute the total size (length) of this empty list
    public int size() {
        return 0;
    }

    // Compute the total value of this empty list
    public int totalValue() {
        return 0;
    }

    // accept the visitor that produces the result of the type R
    public <R> R accept(ILoVisitor<R, T> ilov) {
        return ilov.forMt();
    }
    
    // make a string of this empty list
    public ILo<String> makeStrings() {
        return new MtLo<String>();
    }
    
}

// Represents a nonempty list of items of type T
class ConsLo<T> implements ILo<T> {
    
   
    
    T first;
    ILo<T> rest;

    ConsLo(T first, ILo<T> rest) {
        this.first = first;
        this.rest = rest;
    }

    /*
     * Template: 
     *  Fields: 
     *  ... this.first ... -- T 
     *  ... this.rest ... -- ILo<T>
     * 
     * Methods: 
     * ... this.size() ... -- int 
     * ... this.totalValue() ... -- int
     * ... this.accept(ILoVisitor<R, T>)... R
     * ... this.makeString().... -- ILo<String>
     * 
     * Methods for Fields:
     *  ...this.rest.size() ... -- int 
     *  ...this.rest.totalValue() ... -- int
     *  ...this.first.makeString()... -- String
     *  ...this.rest.makeString().... -- ILo<String>
     *  
     */

    // Compute the total size (length) of this nonempty list
    public int size() {
        return 1 + this.rest.size();
    }

    // Compute the total value of this nonempty list
    public int totalValue() {
        return ((IValue) this.first).value() + this.rest.totalValue();
    }

    // accept the visitor that produces the result of the type R
    public <R> R accept(ILoVisitor<R, T> ilov) {
        return ilov.forCons(this.first, this.rest);
    }
    
    // make a string of this empty list
    public ILo<String> makeStrings() {
        return new ConsLo<String>(((
                MakeString) this.first).makeString(), this.rest.makeStrings());
    }
}
