// assignment 1 pair 043 Wang Shiyu shiyu Wright Steven wrights

import javalib.worldimages.*;
import tester.*;

//to represent the class BoundedPt
class BoundedPt extends Posn {
    int width  = 600; // the width of the canvas
    int height = 400; // the height of the canvas

    BoundedPt(int x, int y) {
        super(x, y);

        // if it isn't valid on the left
        if (!validLeft())
            throw new RuntimeException("The given x coordinate was "
                    + Math.abs(x) + " points beyond the left edge");
        else if (!validRight())
            throw new RuntimeException("The given x coordinate was "
                    + (x - width) + " points beyond the right edge");
        else if (!validTop())
            throw new RuntimeException("The given y coordinate was "
                    + Math.abs(y) + " points beyond the bottom edge");
        else if (!validBottom())
            throw new RuntimeException("The given y coordinate was "
                    + (y - height) + " points beyond the top edge");
    }

    /*
     * Fields: this.x......int this.y......int
     * 
     * Methods: this.validLeft....boolean this.valiRight....boolean
     * this.validTop.....boolean this.validBottom..boolean
     * 
     * Methods for fields
     */
    // to consume the x is in the left width
    public boolean validLeft() {
        return this.x >= 0;

    }

    // to consume the x is in the right width
    public boolean validRight() {
        return this.x <= 600;
    }

    // to consume the y is in the top height
    public boolean validTop() {
        return this.y >= 0;
    }

    // to consume the y is in the bottom height
    public boolean validBottom() {
        return this.y <= 400;
    }
}
