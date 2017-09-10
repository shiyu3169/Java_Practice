// assignment 3
// pair 043
// Wright Steven
// wrights
// Wang Shiyu
// shiyu
/*
             +---------+
             | IMobile |<---------------+
             +---------+                |
             +---------+                |
                 |                      |
                / \                     |
                ---                     |
                 |                      |
       ---------------------            |
       |                   |            |
+--------------+   +---------------+    |
| Simple       |   | Complex       |    |
+--------------+   +---------------+    |
| int length   |   | int length    |    |
| int weight   |   | int leftside  |    |
| String color |   | int rightside |    |
+--------------+   | IMobile left  |----+
                   | IMobile right |----+
                   +---------------+
*/

import javalib.colors.*;

interface IMobile {
    // what is the total weight?
    int totalWeight();

    // what is the total height?
    int totalHeight();

    // is this mobile balanced?
    boolean isBalanced();

    // how much space is required?
    int maxWidth();

    // combine two balanced IMobiles
    IMobile buildMobile(IMobile other, int string, int strut);
};

class Simple implements IMobile {
    int    length;
    int    weight;
    IColor  color;

    Simple(int length, int weight, IColor color) {
        this.length = length;
        this.weight = weight;
        this.color = color;
    }

    // what is the total weight?
    public int totalWeight() {
        return this.weight;
    }

    // what is the total height?
    public int totalHeight() {
        return this.length;
    }

    // what is this mobile balanced?
    public boolean isBalanced() {
        return true;
    }

    // what is the maximum width of this mobile?
    public int maxWidth() {
        return this.weight / 10;
    }

    // combine Balanced IMobiles
    public IMobile buildMobile(IMobile other, int string, int strut) {
        int rightside = (other.totalWeight() * strut)
                / (this.totalWeight() + other.totalWeight());
        int leftside = strut - rightside;
        return new Complex(string, leftside, rightside, this, other);
    }
}

class Complex implements IMobile {
    int     length;
    int     leftside;
    int     rightside;
    IMobile left;
    IMobile right;

    Complex(int length, int leftside, int rightside, IMobile left, 
            IMobile right) {
        this.length = length;
        this.leftside = leftside;
        this.rightside = rightside;
        this.left = left;
        this.right = right;
    }

    /*
     * Fields:
     * ...this.length...
     * ...this.leftside...
     * ...this.rightside...
     * ...this.left...
     * ...this.right...
     * 
     * Methods:
     * ...totalWeight...
     * ...totalHeight...
     * ...isBalanced...
     * ...buildMobile...
     * ...maxWidth...
     */

    // what is the total weight?
    public int totalWeight() {
        return (this.left.totalWeight() + this.right.totalWeight());
    }

    // what is the total height?
    public int totalHeight() {
        return (this.length + Math.max(this.left.totalHeight(),
                this.right.totalHeight()));
    }

    // what is the total weight?
    public boolean isBalanced() {
        int leftweight = this.left.totalWeight() * this.rightside;
        int rightweight = this.right.totalWeight() * this.leftside;
        return leftweight == rightweight;
    }

    // what is the maximum radius of this mobile?
    public int maxWidth() {
        return Math.max((this.leftside + left.maxWidth()),
                (this.rightside + right.maxWidth()));
    }

    // combine Balanced IMobiles
    public IMobile buildMobile(IMobile other, int string, int strut) {
        return new Complex(string,
                strut - (other.totalWeight() * strut) 
                / (this.totalWeight() + other.totalWeight()),
                (other.totalWeight() * strut) 
                / (this.totalWeight() + other.totalWeight()),
                this, other);
    }
}
