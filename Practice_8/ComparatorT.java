import java.util.Comparator;


//assignment 8
//pair p134
//Singh, Bhavneet
//singhb
//Wang, Shiyu
//shiyu

// compare two strings lexographically
// return < 0 if t1 < t2
// return 0 if t1 equals t2
// return > 0 if t1 > t2 
class CompareStringLex implements Comparator<String> {

    // Template

    // Methods:
    // ...this.compare(String, String)... --int

    public int compare(String s1, String s2) {
        return s1.compareTo(s2);

    }

}

// compare two strings by size
// return < 0 if t1 < t2
// return 0 if t1 equals t2
// return > 0 if t1 > t2
class CompareStringSize implements Comparator<String> {

    // Template

    // Methods:
    // ...this.compare(String, String)... --int

    public int compare(String s1, String s2) {
        return s1.length() - s2.length();
    }

}

// compare two pizzas lexographically
// return < 0 if t1 < t2
// return 0 if t1 equals t2
// return > 0 if t1 > t2
class ComparePizzaTypeLex implements Comparator<Pizza> {

    // Template

    // Methods:
    // ...this.compare(String, String)... --int

    public int compare(Pizza s1, Pizza s2) {
        return s1.type.compareTo(s2.type);
    }

}