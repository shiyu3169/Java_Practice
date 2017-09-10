// assignment 6
// pair p134
// Singh, Bhavneet
// singhb
// Wang, Shiyu
// shiyu

/*
 * 
 * 
 *           ----------------------------------
 *           |       ImageFileComparator      |
 *           ----------------------------------
 *                           / \
 *                           ---
 *                            |
 *                            |-----------------------
 *                                                   |
*            ----------------------------------      |
 *           |     ImageFileSizeComparator    |-------
 *           ----------------------------------      |
 *                                                   |
 *           ----------------------------------      |
 *           |     ImageFileNameComparator    |-------
 *           ----------------------------------
 * 
 */




// represents predicates for the ImageFile-s 
interface ImageFileComparator {
    // consumes two ImageFiles and produces an integer less that zero,
    // if the first item is comes before the second in our ordering, 
    // produces a zero, if the two items are equal in our ordering, 
    // and produces a positive integer if the second item comes before
    //the first one in our ordering
    public int compareImageFiles(ImageFile first, ImageFile second);
}

class ImageFileSizeComparator implements ImageFileComparator {
    

    /*TEMPLATE
    * 
    * FIELDS:
    * NONE
    * 
    *METHODS:
    * ...compareImageFiles(ImageFile, ImgageFile)...              --int
    * 
    *METHODS FOR FIELDS:
    * Built-in
    */


    
    // consumes two ImageFiles and produces an integer less that zero,
    // if the first item is comes before the second in our ordering, 
    // produces a zero, if the two items are equal in our ordering, 
    // and produces a positive integer if the second item comes before
    //the first one in our ordering
    public int compareImageFiles(ImageFile first, ImageFile second) {
        return first.size() - second.size();
    }
    
}

class ImageFileNameComparator implements ImageFileComparator {

     /*TEMPLATE
     * 
     * FIELDS:
     * NONE
     * 
     *METHODS:
     * ...compareImageFiles(ImageFile, ImgageFile)...              --int
     * 
     *METHODS FOR FIELDS:
     * Built-in
     */
    

    // consumes two ImageFiles and produces an integer less that zero,
    // if the first item is comes before the second in our ordering, 
    // produces a zero, if the two items are equal in our ordering, 
    // and produces a positive integer if the second item comes before
    //the first one in our ordering
    public int compareImageFiles(ImageFile first, ImageFile second) {
        return first.name.compareTo(second.name);
    }
    
}

