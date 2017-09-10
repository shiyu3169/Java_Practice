// assignment 6
// pair p134
// Singh, Bhavneet
// singhb
// Wang, Shiyu
// shiyu

/*
 *         +----------------------------------+
 *         |               ILoIF              |
 *         +----------------------------------+
 *         +--------------+-------------------+
 *                       / \
 *                      +---+
 *                        |
 *          +-------------+-----------+
 *          |                         |
 *  +---------------+        +-------------------+
 *  |     MTLoIF    |        |     ConsLoIF      |
 *  +---------------+        +-------------------+
 *  +---------------+     +--| ImageFile  first  |
 *                        |  | ILoIF      rest   |
 *                        |  +-------------------+
 *                        v
 *               +---------------+
 *               | ImageFile     |
 *               +---------------+
 *               | String name   |
 *               | int    width  |
 *               | int    height |
 *               | String kind   |
 *               +---------------+
 */

// Represents a list of ImageFiles
interface ILoIF {

    // produce a list of ImageFiles from this list
    // that satisfy the given predicate
    public ILoIF filterImageFile(ISelectImageFile pick);

    // checks if all ImageFiles in this list are smaller than 40000
    public boolean allSmallerThan40000(ISelectImageFile pick);

    // checks if all ImageFiles in this list have names shorter than 4
    public boolean allNamesShorterThan4(ISelectImageFile pick);

    // checks if all ImageFiles in this list are satisfied by
    // the given predicate
    public boolean allSuchImageFiles(ISelectImageFile pick);
    
    // checks if any ImageFiles in this list are satisfied by
    // the given predicate
    public boolean anySuchImageFiles(ISelectImageFile pick);

    // sorts this list of ImageFiles based on the given ordering
    public ILoIF sort(ImageFileComparator comp);

    // inserts the given ImageFile into this list of ImageFiles 
    // based on the given ordering
    public ILoIF insert(ImageFileComparator comp, ImageFile file);
}

// Represents an empty list of ImageFiles
class MtLoIF implements ILoIF {
    MtLoIF() {
    }

    /*TEMPLATE
         * 
         * FIELDS:
         * NONE
         * 
         *METHODS:
         * ...this.filterImageFile(ISelectImageFile)...           --ILoIF
         * ...this.allSmallerThan40000(ISelectImageFile)...       --Boolean
         * ...this.allNamesShorterThan4(ISelectImageFile)...      --Boolean
         * ...this.allSuchImageFiles(ISelectImageFile)...         --Boolean
         * ...this.anySuchImageFiles(ISelectImageFile)...         --Boolean
         * ...this.insert(ImageFileComparator)...                 --ILoIF
         * ...this.sort(ImageFileComparator)...                   --ILoIF
         * 
         * 
         *METHODS FOR FIELDS:
         * Built-in
         */


    // produces a list of ImageFiles from this empty
    // list that satisfy the given predicate
    public ILoIF filterImageFile(ISelectImageFile pick) {
        return this;
    }

    // checks if all ImageFiles in this empty list have sizes 
    // smaller than 40000
    public boolean allSmallerThan40000(ISelectImageFile pick) {
        return true;
    }

    // checks if all ImageFiles in this empty list have names 
    // shorter than 4
    public boolean allNamesShorterThan4(ISelectImageFile pick) {
        return true;
    }
    
   // checks if all ImageFiles in this empty list is satisfied 
   // by the given predicate
    public boolean allSuchImageFiles(ISelectImageFile pick) {
        return true;
    }

    // checks if any ImageFiles in this empty list is satisfied by
    // the given predicate
    public boolean anySuchImageFiles(ISelectImageFile pick) {
        return false;
    }
   
    // insert the given ImageFile into this empty list of ImageFiles
    // based on the given ordering
    public ILoIF insert(ImageFileComparator comp, ImageFile file) {
        return new ConsLoIF(file, this);
    }

    // sort this empty list of ImageFiles given some comparison
    public ILoIF sort(ImageFileComparator comp) {
        return this;
    }
}

// Represents a nonempty list of ImageFiles
class ConsLoIF implements ILoIF {

    public ImageFile first;
    public ILoIF rest;

    public ConsLoIF(ImageFile first, ILoIF rest) {
        this.first = first;
        this.rest = rest;
    }
    

/*TEMPLATE
     * 
     * FIELDS:
     * ...this.first...                                       --ImageFile
     * ...this.rest...                                        --ILoIF
     * 
     *METHODS:
     * ...this.filterImageFile(ISelectImageFile)...           --ILoIF
     * ...this.allSmallerThan40000(ISelectImageFile)...       --Boolean
     * ...this.allNamesShorterThan4(ISelectImageFile)...      --Boolean
     * ...this.allSuchImageFiles(ISelectImageFile)...         --Boolean
     * ...this.anySuchImageFiles(ISelectImageFile)...         --Boolean
     * ...this.insert(ImageFileComparator)...                 --ILoIF
     * ...this.sort(ImageFileComparator)...                   --ILoIF
     * 
     * 
     *METHODS FOR FIELDS:
     * ...this.rest.filterImageFile(ISelectImageFile)...           --ILoIF
     * ...this.rest.allSmallerThan40000(ISelectImageFile)...       --Boolean
     * ...this.rest.allNamesShorterThan4(ISelectImageFile)...      --Boolean
     * ...this.rest.allSuchImageFiles(ISelectImageFile)...         --Boolean
     * ...this.rest.anySuchImageFiles(ISelectImageFile)...         --Boolean
     * ...this.rest.insert(ImageFileComparator)...                 --ILoIF
     * ...this.rest.sort(ImageFileComparator)...                   --ILoIF
     */




    // produces a list of ImageFiles from this non empty
    // list that satisfy the given predicate
    public ILoIF filterImageFile(ISelectImageFile pick) {
        if (pick.select(this.first))
            return new ConsLoIF(this.first, this.rest.filterImageFile(pick));
        else
            return this.rest.filterImageFile(pick);
    }

    // checks if all ImageFiles in this non empty list have sizes 
    // smaller than 40000
    public boolean allSmallerThan40000(ISelectImageFile pick) {
        if (pick.select(this.first))
            return this.rest.allSmallerThan40000(pick);
        else
            return false;
    }

    // checks if all ImageFiles in this non empty list have names 
    // shorter than 4
    public boolean allNamesShorterThan4(ISelectImageFile pick) {
        if (pick.select(this.first))
            return this.rest.allNamesShorterThan4(pick);
        else
            return false;
    }

    // checks if all ImageFiles in this non empty list is satisfied by the
    // given predicate
    public boolean allSuchImageFiles(ISelectImageFile pick) {
        if (pick.select(this.first))
            return this.rest.allSuchImageFiles(pick);
        else
            return false;
    }
    
    // checks if any ImageFiles in this non empty list is satified by the
    // given predicate
    public boolean anySuchImageFiles(ISelectImageFile pick) {
        if (pick.select(this.first))
            return true;
        else
            return this.rest.anySuchImageFiles(pick);
    }
    
    // inserts a given ImageFile into this non empty list of ImageFiles
    // according to the given ordering
    public ILoIF insert(ImageFileComparator comp, ImageFile file) {
        if (comp.compareImageFiles(file, this.first) > 0)
            return new ConsLoIF(this.first, 
                    this.rest.insert(comp, file));
        else return new ConsLoIF(file, this);
    }
    
    // orders this non empty list of ImageFiles in a specified order
    public ILoIF sort(ImageFileComparator comp) {
        return this.rest.sort(comp).insert(comp, this.first);
        
    }
}

// Represents an image file
class ImageFile {
    String name;
    int width;
    int height;
    String kind;

    ImageFile(String name, int width, int height, String kind) {
        this.name = name;
        this.width = width;
        this.height = height;
        this.kind = kind;
    }
    
    /*TEMPLATE
     * 
     * FIELDS:
     * ...this.name...                                             --String
     * ...this.width...                                            --int
     * ...this.height...                                           --int
     * ...this.kind...                                             --String
     * 
     *METHODS:
     * ...this.size()...                                           --int
     * ...this.sameImageFile(ImageFile)...                         --boolean
     * 
     *METHODS FOR FIELDS:
     * Built-in
     */

    // Calculate the size of this image
    public int size() {
        return this.width * this.height;
    }

    // Is this image file the same as the given one?
    public boolean sameImageFile(ImageFile that) {
        return (this.name.equals(that.name) && this.width == that.width
                && this.height == that.height && this.kind.equals(that.kind));
    }
}