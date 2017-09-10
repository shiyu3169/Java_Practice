// assignment 6
// pair p134
// Singh, Bhavneet
// singhb
// Wang, Shiyu
// shiyu

/*
 * 
 * 
 *           -------------------------------
 *           |       ISelectImageFile      |
 *           -------------------------------
 *                           / \
 *                           ---
 *                            |
 *                            |-----------------------
 *                                                   |
*            -------------------------               |
 *           |     SmallImageFile    |---------------|
 *           -------------------------               |
 *                                                   |
 *           ---------------------------             |
 *           |     NameShorterThan4    |-------------|
 *           ---------------------------             |
 *                                                   |
 *           --------------------                    |
 *           |     GivenKind    |---------------------
 *           --------------------    
 * 
 */

// to represent a predicate for ImageFile-s
public interface ISelectImageFile {

    // Return true if the given ImageFile
    // should be selected
    public boolean select(ImageFile f);

}

// Select image files smaller than 40000
class SmallImageFile implements ISelectImageFile {

    /*TEMPLATE
     * 
     * FIELDS:
     * NONE
     * 
     *METHODS:
     * ...select(ImageFile)...              --boolean
     * 
     *METHODS FOR FIELDS:
     * Built-in
     */

    // Return true if the given ImageFile is smaller than 40000
    public boolean select(ImageFile f) {
        return f.size() < 40000;
    }

}

// Select image files whose names are shorter than 4
class NameShorterThan4 implements ISelectImageFile {
    
     /*TEMPLATE
     * 
     * FIELDS:
     * NONE
     * 
     *METHODS:
     * ...select(ImageFile)...              --boolean
     * 
     *METHODS FOR FIELDS:
     * Built-in
     */
    

    // Return true if the given ImageFile has a name shorter than 4
    public boolean select(ImageFile f) {
        return f.name.length() < 4;
    }

}

// Select image files whose names are shorter than 4
class GivenKind implements ISelectImageFile {
    String kind;

    GivenKind(String kind) {
        this.kind = kind;
    }
    
    /*TEMPLATE
     * 
     * FIELDS:
     * this.kind...                         --String
     * 
     *METHODS:
     * ...select(ImageFile)...              --boolean
     * 
     *METHODS FOR FIELDS:
     * Built-in
     */

    // Return true if the given ImageFile has the same kind as this 
    // GivenKind's kind
    public boolean select(ImageFile f) {
        return f.kind.equals(this.kind);
    }
}