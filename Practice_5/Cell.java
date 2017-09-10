// assignment 1
// pair 043
// Wang Shiyu
// shiyu
// Wright Steven
// wrights

// to represent the class cell
class Cell {
    String row;
    String column;
    IData  item;

    Cell(String row, String column, IData item) {
        this.row = row;
        this.column = column;
        this.item = item;
    }

    /*
     * Fields: this.row..........String this.column.......String
     * this.item.........IData
     * 
     * Methodthis.value().............intthis.sameSpace(Cell).....boolean
     * this.makeList()..........ILoCthis.isFormula().........boolean
     * 
     * Method for fields this.value.item().............int
     * this.sameSpace.row(Cell).....boolean
     * this.sameSpace.column(Cell).....boolean
     * this.makeList.item()..........ILoC this.isFormula.item().........boolean
     */
    // computes the value of this cell
    public int value() {
        return this.item.value();
    }

    // returns true if the cells have same location
    boolean sameSpace(Cell c) {
        return this.row.equals(c.row) && this.column.equals(c.column);
    }

    // produces a list of the Numbers referenced by this Cell
    ILoC makeList() {
        return new ConsLoC(this, new MtLoC()).append(this.item.makeList());
    }

    // return true if the item of cell is a formula
    public boolean isFormula() {
        return item.isFormula();
    }
}

// to represent the interface ExcelCells
interface IData {
    // computes the value of this cell
    int value();

    // produces a list of the Cells referenced by this IData
    ILoC makeList();

    // return true iff formula
    boolean isFormula();

    // return number of args contianed in IData
    int countArgs();
}

// to represent the class number
class Number implements IData {
    int num;

    Number(int num) {
        this.num = num;
    }

    /*
     * Fields: this.num......int
     * 
     * Method: this.value().............int this.makeList()..........ILoC
     * this.isFormula().........boolean
     * 
     * Method for fields:
     */

    // computes the value of this cell
    public int value() {
        return this.num;
    }

    // produces the list of Cells reference by this Number
    public ILoC makeList() {
        return new MtLoC();
    }

    // return true iff formula
    public boolean isFormula() {
        return false;
    }

    // returns number of Args contained
    public int countArgs() {
        return 1;
    }
}

// to represent the class Formula
class Formula implements IData {
    String op;
    Cell   first;
    Cell   second;

    Formula(String op, Cell first, Cell second) {
        this.op = op;
        this.first = first;
        this.second = second;
    }

    /*
     * Fields: this.op.........String this.first......Cell this.second.....Cell
     * 
     * Method: this.value().............int this.makeList()..........ILoC
     * this.isFormula().........boolean
     * 
     * Method for Fields: this.first.item.value()....int
     * this.second.item.value()...int this.first.makeList()....ILoC
     * this.second.makeList()...ILoC
     */

    // computes the value of this cell
    public int value() {
        if (this.op.equals("max"))
            return Math.max(this.first.item.value(), this.second.item.value());
        if (this.op.equals("+"))
            return this.first.item.value() + this.second.item.value();
        else
            return this.first.item.value() * this.second.item.value();
    }

    // produces the list of Numbers reference by this Formula
    public ILoC makeList() {
        return new MtLoC().append(this.first.makeList()).append(
                this.second.makeList());
    }

    // return true if it is a formula
    public boolean isFormula() {
        return true;
    }

    // return number of args contained
    public int countArgs() {
        return this.makeList().unique().countArgs();
    }
}

// to represent a list of cells
interface ILoC {

    // returns a list of cells that are unique
    ILoC unique();

    // returns true if the list contains a given cell
    boolean contains(Cell c);

    // counts elements in the list
    int countArgs();

    // appends this list onto given list
    ILoC append(ILoC c);
}

class MtLoC implements ILoC {
    MtLoC() {
    };

    /*
     * Fields:
     * 
     * Methods: this.unique().........ILoC this.contains(Cell)...boolean
     * this.append(ILoC).....ILoC this.cuntArgs().......int
     * 
     * Methods for fields:
     */

    // terminates a list of cells that are unique
    public ILoC unique() {
        return this;
    }

    // returns true if this MtLoC contains the given cell
    public boolean contains(Cell c) {
        return false;
    }

    // counts elements of the list
    public int countArgs() {
        return 0;
    }

    // appends Cell onto empty
    public ILoC append(ILoC c) {
        return c;
    }
}

class ConsLoC implements ILoC {
    Cell first;
    ILoC rest;

    ConsLoC(Cell first, ILoC rest) {
        this.first = first;
        this.rest = rest;
    }

    /*
     * Fields this.first.....Cell this.rest......ILoC
     * 
     * Methods this.unique().........ILoC this.contains(Cell)...boolean
     * this.append(ILoC).....ILoC this.cuntArgs().......int
     * 
     * Methods for fields this.rest.unique().........ILoC
     * this.rest.contains(Cell)...boolean this.rest.append(ILoC).....ILoC
     * this.rest.cuntArgs().......int
     */

    // count elements of the list
    public int countArgs() {
        return 1 + this.rest.countArgs();
    }

    // return a list of cells that are unique and numbers
    public ILoC unique() {
        if (this.rest.contains(this.first) || this.first.isFormula())
            return this.rest.unique();
        else
            return new ConsLoC(this.first, this.rest.unique());
    }

    // return true if the list contains a given cell
    public boolean contains(Cell c) {
        return this.first.sameSpace(c) || this.rest.contains(c);
    }

    // appends Cell onto ConsLoC
    public ILoC append(ILoC c) {
        return new ConsLoC(this.first, this.rest.append(c));
    }
}