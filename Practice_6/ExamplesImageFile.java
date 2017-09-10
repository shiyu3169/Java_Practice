// assignment 6
// pair p134
// Singh, Bhavneet
// singhb
// Wang, Shiyu
// shiyu

import tester.*;

// Test the use of function objects with lists of ImageFiles
public class ExamplesImageFile {

    public ExamplesImageFile() {
    }

    // Sample ImageFiles
    public ImageFile img1 = new ImageFile("dog", 300, 200, "jpg");
    public ImageFile img2 = new ImageFile("cat", 200, 200, "png");
    public ImageFile img3 = new ImageFile("bird", 250, 200, "jpg");
    public ImageFile img4 = new ImageFile("horse", 300, 300, "gif");
    public ImageFile img5 = new ImageFile("goat", 100, 200, "gif");
    public ImageFile img6 = new ImageFile("cow", 150, 200, "jpg");
    public ImageFile img7 = new ImageFile("snake", 200, 300, "jpg");

 // Sample SmallImageFile
    public ISelectImageFile sf = new SmallImageFile();

    // Sample NameShorterThan4
    public ISelectImageFile n = new NameShorterThan4();

    // Sample GivenKind
    public ISelectImageFile g = new GivenKind("jpg");

    // Sample GivenKind
    public ISelectImageFile gif = new GivenKind("gif");

    // Sample Empty List of ImageFiles
    public ILoIF mt = new MtLoIF();
    
    //Sample ImageFileSizeComparator 
    public ImageFileComparator sizecomp = new ImageFileSizeComparator();
    
   //Sample ImageFileNameComparator 
    public ImageFileComparator namecomp = new ImageFileNameComparator();
    

    // Sample Non-empty List of ImageFiles
    public ILoIF imglistall = 
    		new ConsLoIF(this.img1, 
    		new ConsLoIF(this.img2,
            new ConsLoIF(this.img3, 
            new ConsLoIF(this.img4, 
            new ConsLoIF(this.img5, 
            new ConsLoIF(this.img6, 
            new ConsLoIF(this.img7, this.mt)))))));
    
    // List of ImageFiles - short names (less than 4 characters)
    public ILoIF imglistshortnames = 
            new ConsLoIF(this.img1, 
            new ConsLoIF(this.img2, 
            new ConsLoIF(this.img6, this.mt)));
    
    // List of ImageFiles - long names (greater than or equal to 4 characters)
    public ILoIF imglistlongnames = 
            new ConsLoIF(this.img3, 
            new ConsLoIF(this.img4, 
            new ConsLoIF(this.img5, 
            new ConsLoIF(this.img7, mt))));
    
    //List of ImageFiles - same kind as "jpg"
    public ILoIF imglistjpg = 
            new ConsLoIF(this.img1, 
            new ConsLoIF(this.img3,
            new ConsLoIF(this.img6,
            new ConsLoIF(this.img7, mt))));
    
    //List of ImageFiles - same kind as "gif"
    public ILoIF imglistgif = 
            new ConsLoIF(this.img4, 
            new ConsLoIF(this.img5, mt));

    // List of ImageFiles - small size (< 40000)
    public ILoIF imglistsmall = 
    new ConsLoIF(this.img5, 
    new ConsLoIF(this.img6, this.mt));

    // List of ImageFiles -- large images
    public ILoIF imglistlarge = 
    new ConsLoIF(this.img1, 
    new ConsLoIF(this.img2,
    new ConsLoIF(this.img3, this.mt)));

    // Tests the method size in the ImageFile Class
    public boolean testSize(Tester t) {
        return t.checkExpect(this.img1.size(), 60000) 
        && t.checkExpect(this.img2.size(), 40000);
    }

    // Tests the method sameImageFile in the ImageFile Class
    public boolean testSameImageFile(Tester t) {
        return t.checkExpect(this.img1.sameImageFile(img1), true)
        && t.checkExpect(this.img1.sameImageFile(img2), false);
    }

    // TESTS FOR ImageFileSizeComparator
    
    // test the method compareImageFiles in the ImageFileSizeComparator Class
    public boolean testCompareImageFilesSize(Tester t) {
        return 
        t.checkExpect(this.sizecomp.compareImageFiles(img1, img2), 20000)
        && t.checkExpect(this.sizecomp.compareImageFiles(img2, img1), -20000) 
        && t.checkExpect(this.sizecomp.compareImageFiles(img1, img1), 0); 
    }
    
    // TESTS FOR ImageFileNameComparator
    
    // test the method compareImageFiles in the ImageFileNameComparator Class
    public boolean testCompareImageFilesName(Tester t) {
        return t.checkExpect(this.namecomp.compareImageFiles(img1, img2), 1) 
        && t.checkExpect(this.namecomp.compareImageFiles(img2, img1), -1)
        && t.checkExpect(this.namecomp.compareImageFiles(img1, img1), 0); 
    }
    
    // TESTS FOR SmallImageFile

    // test the method select in the SmallImageFile Class
    public boolean testSelectSmall(Tester t) {
        return t.checkExpect(this.sf.select(this.img1), false) 
        && t.checkExpect(this.sf.select(this.img5), true);
    }

    // TESTS FOR NameShorterThan4

    // test the method select in the NameShorterThan4 Class
    public boolean testSelectName(Tester t) {
        return t.checkExpect(this.n.select(this.img1), true)
        && t.checkExpect(this.n.select(this.img4), false);
    }

    // TESTS FOR GivenKind

    // test the method select in the GivenKind Class
    public boolean testSelectKind(Tester t) {
        return t.checkExpect(this.g.select(this.img1), true) 
        && t.checkExpect(this.g.select(this.img2), false);
    }

    // TESTS FOR MtLoIF

    // test the method filterImageFile in the MtLoIF Class
    public boolean testFilterMt(Tester t) {
        return t.checkExpect(this.mt.filterImageFile(sf), mt) 
        && t.checkExpect(this.mt.filterImageFile(n), mt) 
        && t.checkExpect(this.mt.filterImageFile(g), mt)
        && t.checkExpect(this.mt.filterImageFile(gif), mt);
    }

    // test the method allSmallerThan40000 in the MtLoIF Class
    public boolean testAllSmallerThan40000Mt(Tester t) {
        return t.checkExpect(this.mt.allSmallerThan40000(sf), true);
    }

    // test the method allNamesShorterThan4 in the MtLoIF Class
    public boolean testAllNamesShorterThan4Mt(Tester t) {
        return t.checkExpect(this.mt.allNamesShorterThan4(n), true);
    }

    // test the method allSuchImageFiles in the MtLoIF Class
    public boolean testAllSuchImageFilesMt(Tester t) {
        return t.checkExpect(this.mt.allSuchImageFiles(n), true) 
        && t.checkExpect(this.mt.allSuchImageFiles(sf), true)
        && t.checkExpect(this.mt.allSuchImageFiles(g), true)
        && t.checkExpect(this.mt.allSuchImageFiles(gif), true);
    }
    
   // test the method anySuchImageFiles in the MtLoIF Class
    public boolean testAnySuchImageFilesMt(Tester t) {
        return t.checkExpect(this.mt.anySuchImageFiles(n), false) 
        && t.checkExpect(this.mt.anySuchImageFiles(sf), false)
        && t.checkExpect(this.mt.anySuchImageFiles(g), false)
        && t.checkExpect(this.mt.anySuchImageFiles(gif), false);
    }
    
    // test the method insert in the MtLoIF Class
    public boolean testInsertMt(Tester t) {
        return t.checkExpect(mt.insert(sizecomp, img1),
        new ConsLoIF(img1, mt));
    }
    
    // test the method sort in the MtLoIF Class
    public boolean testSortMt(Tester t) {
        return t.checkExpect(mt.sort(sizecomp), mt) 
        && t.checkExpect(mt.sort(namecomp), mt);
    }
    
    // TESTS FOR ConsLoIF

    // test the method filterImageFile in the ConsLoIF Class
    public boolean testFilterCons(Tester t) {
        return t.checkExpect(this.imglistall.filterImageFile(sf), imglistsmall)
        && t.checkExpect(this.imglistall.filterImageFile(n), imglistshortnames)
        && t.checkExpect(this.imglistall.filterImageFile(g), imglistjpg) 
        && t.checkExpect(this.imglistall.filterImageFile(gif), imglistgif);
    }

    // test the method allSmallerThan40000 in the ConsLoIF Class
    public boolean testAllSmallerThan40000Cons(Tester t) {
        return t.checkExpect(this.imglistall.allSmallerThan40000(sf), false) 
        && t.checkExpect(this.imglistsmall.allSmallerThan40000(sf), true);
    }

    // test the method allNamesShorterThan4 in the ConsLoIF Class
    public boolean testAllNamesShorterThan4Cons(Tester t) {
        return t.checkExpect(this.imglistall.allNamesShorterThan4(n), false) 
        && t.checkExpect(this.imglistshortnames.allNamesShorterThan4(n), true);
    }

    // test the method allSuchImageFiles in the ConsLoIF Class
    public boolean testAllSuchImageFilesCons(Tester t) {
        return t.checkExpect(this.imglistall.allSuchImageFiles(sf), false)
        && t.checkExpect(this.imglistsmall.allSuchImageFiles(sf), true)
        && t.checkExpect(this.imglistall.allSuchImageFiles(n), false)
        && t.checkExpect(this.imglistshortnames.allSuchImageFiles(n), true) 
        && t.checkExpect(this.imglistall.allSuchImageFiles(g), false)
        && t.checkExpect(this.imglistjpg.allSuchImageFiles(g), true)
        && t.checkExpect(this.imglistall.allSuchImageFiles(gif), false)
        && t.checkExpect(this.imglistgif.allSuchImageFiles(gif), true);
    }
    
    // test the method anySuchImageFiles in the ConsLoIF Class
    public boolean testAnySuchImageFilesCons(Tester t) {
        return t.checkExpect(this.imglistall.anySuchImageFiles(sf), true)
        && t.checkExpect(this.imglistlarge.anySuchImageFiles(sf), false)
        && t.checkExpect(this.imglistall.anySuchImageFiles(n), true)
        && t.checkExpect(this.imglistlongnames.anySuchImageFiles(n), false) 
        && t.checkExpect(this.imglistall.anySuchImageFiles(g), true)
        && t.checkExpect(this.imglistgif.anySuchImageFiles(g), false)
        && t.checkExpect(this.imglistall.anySuchImageFiles(gif), true)
        && t.checkExpect(this.imglistjpg.anySuchImageFiles(gif), false);
    }
    
    // test the method insert in the ConsILoIF Class
    public boolean testInsertCons(Tester t) {
    return t.checkExpect(imglistall.insert(sizecomp, img1),
                new ConsLoIF(img1, 
                new ConsLoIF(img1,
                new ConsLoIF(img2,
                new ConsLoIF(img3,
                new ConsLoIF(img4,
                new ConsLoIF(img5,
                new ConsLoIF(img6,
                new ConsLoIF(img7, mt)))))))))
           && t.checkExpect(imglistall.insert(sizecomp, img4),
           new ConsLoIF(img1, 
           new ConsLoIF(img2,
           new ConsLoIF(img3,
           new ConsLoIF(img4,
           new ConsLoIF(img4,
           new ConsLoIF(img5,
           new ConsLoIF(img6,
           new ConsLoIF(img7, mt)))))))));
    }
    
    // test the method sort in the ConsLoIF Class
    public boolean testSortCons(Tester t) {
        return t.checkExpect(imglistall.sort(sizecomp), 
                new ConsLoIF(img5, 
                new ConsLoIF(img6,
                new ConsLoIF(img2,
                new ConsLoIF(img3,
                new ConsLoIF(img1,
                new ConsLoIF(img7,
                new ConsLoIF(img4, mt))))))))
                &&
                t.checkExpect(imglistall.sort(namecomp), 
                new ConsLoIF(img3, 
                new ConsLoIF(img2,
                new ConsLoIF(img6,
                new ConsLoIF(img1,
                new ConsLoIF(img5,
                new ConsLoIF(img4,
                new ConsLoIF(img7, mt))))))));
    }

}