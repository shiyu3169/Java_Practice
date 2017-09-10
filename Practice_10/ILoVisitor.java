// assignment 10
// pair p134
// Singh, Bhavneet
// singhb
// Wang, Shiyu
// shiyu

// A visitor for the ILo<T> classes that 
// and produces the result of the type R
interface ILoVisitor<R, T> {
    
    // method for the empty list
    public R forMt();

    // method for the nonempty list
    public R forCons(T first, ILo<T> rest);
}

// A visitor that computes the total download time for all files
// in the list of image files
class ILoImageDownloadTimeVisitor implements ILoVisitor<Integer, Image> {
    
    
    /* Template
     *   Fields
     *   this.speed.........   -- int
     *     
     *
     *   Methods
     *   this.forMt().......   -- int
     *   this.forCons(image, ILo<Image>)......  -- int
     *   
     *   Methods for Fields
     *   this.rest.accept(ILoImageDownloadTimeVisitor).... -- int
     *   this.first.filesize()..........     -- int
     *     
     */

    int speed;

    ILoImageDownloadTimeVisitor(int speed) {
        this.speed = speed;
    }

    // method for the empty list
    public Integer forMt() {
        return 0;
    }

    // method for the nonempty list
    public Integer forCons(Image first, ILo<Image> rest) {
        return first.fileSize / speed + rest.accept(this);
    }
}

// A visitor that lists all the titles of songs
class ILoSongTitlesVisitor implements ILoVisitor<ILo<String>, Song> {
    
    /* Template
     *   Fields
     *   No fields
     *     
     *
     *   Methods
     *   this.forMt().......   -- ILo<String>
     *   this.forCons(Song, ILo<Song>)......  -- ILo<String>
     *   
     *   Methods for Fields
     *   this.rest.accept(ILoSongTitlesVisitor).... -- String
     *   this.first.title()..........     -- String
     *     
     */

    // method for the empty list
    public ILo<String> forMt() {
        return new MtLo<String>();
    }

    // method for the nonempty list
    public ILo<String> forCons(Song first, ILo<Song> rest) {
        return new ConsLo<String>(first.title, rest.accept(this));
    }
}

// A visitor that makes one long string that contains the titles of all 
// books
class ILoBookVisitor implements ILoVisitor<String, Book> {
    
    /* Template
     *   Fields
     *   No fields
     *     
     *
     *   Methods
     *   this.forMt().......   -- String
     *   this.forCons(Book, ILo<Book>)......  -- String
     *   
     *   Methods for Fields
     *   this.rest.accept(ILoBookVisitor).... -- String
     *   this.first.title()..........     -- String
     *     
     */

 // method for the empty list
 public String forMt() {
     return "";
 }

 // method for the nonempty list
 public String forCons(Book first, ILo<Book> rest) {
     return first.title + "\n" + rest.accept(this);
 }
}