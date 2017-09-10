import tester.Tester;

// assignment 3
// pair 043
// Wright Steven
// wrights
// Wang Shiyu
// shiyu

class ExamplesWP {
    ILoI empty     = new MtLoI();
    Item subtitlek = new Text("This is my cat");
    Item kitty     = new Image("kitty", 400, "png");
    Item subtitled = new Text("This is my dog");
    Item rover     = new Image("doggie", 430, "jpeg");
    Item subtitleg = new Text("My gerbil");
    Item gerbil    = new Image("cutie", 500, "png");
    ILoI list0     = new ConsLoI(subtitleg, new ConsLoI(gerbil, empty));
    WP   bobsPets  = new WP("bob-pets.org", "Bob's Pets", list0);
    Item link      = new Link("Here are Bob's pets", bobsPets);
    ILoI list1     = new ConsLoI(this.link, new ConsLoI(this.rover,
                           new ConsLoI(this.subtitled, new ConsLoI(
                                   this.kitty, new ConsLoI(this.subtitlek,
                                           empty)))));
    WP   myPets    = new WP("mypets.org", "My Pets", list1);

    // Test imageSize for interface Item
    boolean testImageSizeItem(Tester t) {
        ExamplesWP wp = new ExamplesWP();
        return t.checkExpect(wp.subtitlek.imageSize(), 0)
                && t.checkExpect(wp.kitty.imageSize(), 400)
                && t.checkExpect(wp.link.imageSize(), 500);
    }

    // Test imageSize for interface ILoI
    boolean testImageSizeILoI(Tester t) {
        ExamplesWP wp = new ExamplesWP();
        return t.checkExpect(wp.empty.totalImageSize(), 0)
                && t.checkExpect(wp.list1.totalImageSize(), 1330);
    }

    // Test textLength for interface Item
    boolean testTextLengthILoI(Tester t) {
        ExamplesWP wp = new ExamplesWP();
        return t.checkExpect(wp.subtitlek.textLength(), 14)
                && t.checkExpect(wp.kitty.textLength(), 8)
                && t.checkExpect(wp.link.textLength(), 46);
    }

    boolean testImages(Tester t) {
        ExamplesWP wp = new ExamplesWP();
        return t.checkExpect(wp.subtitlek.images(), "")
                && t.checkExpect(wp.kitty.images(), "kitty.png")
                && t.checkExpect(wp.list1.images(), 
                        "cutie.png, doggie.jpeg, kitty.png");
    }

}