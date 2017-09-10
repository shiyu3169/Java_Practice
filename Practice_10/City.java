// assignment 10
// pair p134
// Singh, Bhavneet
// singhb
// Wang, Shiyu
// shiyu

import java.text.*;  // to get DecimalFormat

/** Represents a City */
class City {
    /** Decimal format to print leading zeros in zip code */
    DecimalFormat zipFormat = new DecimalFormat("00000");
    
    /*Template
     * Fields:
     * this.zip....   --int
     * this.state...  -- String
     * this.name...   -- String
     * this.longitude... -- double
     * this.latitude...  -- double
     * 
     * Methods:
     * this.toString()..... -- String
     * this.equals(Object).... -- boolean
     * this.hashCode()....      -- int
     * 
     * Methods for Fields
     * this.name.hashCode()...  -- int
     * this.state.hashCode()... -- int
     * 
     */

    int zip;
    String name;
    String state;
    double longitude;
    double latitude;

    
    /** The full constructor */
    public City (int zip, String name, String state,
            double longitude, double latitude) {
        this.zip   = zip;
        this.name  = name;
        this.state = state;
        this.longitude = longitude;
        this.latitude  = latitude;
    }    

    /** Represent  city data as a String for printed display */
    public String toString() {
        return ("new City(" + 
                this.zipFormat.format(this.zip) + ", " + 
                this.name  + ", " + this.state + ", " + 
                this.longitude + ", " + this.latitude + ")");
    }
    
    // checks if this City is equal to the given Object
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        City temp = (City)obj;
        return this.name.equals(temp.name) &&
                (this.zip == temp.zip) &&
                this.state.equals(temp.state) &&
                Double.valueOf(this.longitude).equals(
                        Double.valueOf(temp.longitude)) &&
                Double.valueOf(this.latitude).equals(
                        Double.valueOf(temp.latitude));
    }
    
    // get the hashCode of this city
    public int hashCode() {
        return this.name.hashCode() +
                this.state.hashCode() +
                this.zip;
    }
    
    // checks if this city is below the given latitude
    public boolean belowLat(double lat) {
        return this.latitude < lat;
    }
    
    // is this city the same as the given one?
    public boolean sameCity(City that) {
        return this.equals(that);
    }
}