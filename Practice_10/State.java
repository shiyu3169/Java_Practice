// assignment 10
// pair p134
// Singh, Bhavneet
// singhb
// Wang, Shiyu
// shiyu

import java.util.*;

/** Class to represent one US State with its capital. */
public class State{
    
    /* Template
     * Fields
     * this.name...      --String
     * this.capital...   --City
     * this.neighbors... --ArrayList<String>
     * 
     * Methods:
     * this.toString().... -- String
     * 
     * Methods of Fields
     * Built-in
     * 
     */
    
    String name;
    City capital;
    ArrayList<String> neighbors;

    /** Full constructor */
    State(String name, City capital, ArrayList<String> neighbors) {
        this.name = name;
        this.capital = capital; 
        this.neighbors = neighbors;
    }

    /** Print the State to a String */
    public String toString() {
        return ("new State(" + 
                this.name  + ", " + 
                this.capital + ", " + 
                this.neighbors + ")\n");
    }
}