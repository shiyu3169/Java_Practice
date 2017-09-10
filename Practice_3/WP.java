// assignment 3
// pair 043
// Wright Steven
// wrights
// Wang Shiyu
// shiyu

class WP {
    String url;
    String title;
    ILoI   items;

    WP(String url, String title, ILoI items) {
        this.url = url;
        this.title = title;
        this.items = items;
    }

    // finds totalImageSize of images in WP and all linked WPs
    int totalImageSize() {
        return items.totalImageSize();
    }

    // returns text length of Item
    int textLength() {
        return this.title.length() + items.textLength();
    }

    // returns names of images, separated by a comma
    String images() {
        return items.images();
    }
}

class Text implements Item {
    String contents;

    Text(String contents) {
        this.contents = contents;
    }

    // returns image size for Text (hint 0)
    public int imageSize() {
        return 0;
    }

    // returns text length of Text
    public int textLength() {
        return this.contents.length();
    }

    // returns names of images, separated by a comma
    public String images() {
        return "";
    }
}

class Image implements Item {
    String fileName;
    int    size;
    String fileType;

    Image(String fileName, int size, String fileType) {
        this.fileName = fileName;
        this.size = size;
        this.fileType = fileType;
    }

    // returns text length of Image
    public int textLength() {
        return this.fileName.length() + this.fileType.length();
    }

    // returns image size for Image
    public int imageSize() {
        return this.size;
    }

    // returns names of images, separated by a comma
    public String images() {
        return this.fileName + "." + this.fileType;
    }
}

class Link implements Item {
    String name;
    WP     page;

    Link(String name, WP page) {
        this.name = name;
        this.page = page;
    }

    // returns text length of Link
    public int textLength() {
        return this.name.length() + this.page.textLength();
    }

    // returns image size for Link
    public int imageSize() {
        return this.page.totalImageSize();
    }

    // returns names of images, separated by a comma
    public String images() {
        return this.page.images();
    }

}

class MtLoI implements ILoI {
    MtLoI() {
    }

    // returns image size for empty
    public int totalImageSize() {
        return 0;
    }

    // returns text length for empty
    public int textLength() {
        return 0;
    }

    // returns names of images, separated by a comma
    public String images() {
        return "";
    }
}

class ConsLoI implements ILoI {
    Item first;
    ILoI rest;

    ConsLoI(Item first, ILoI rest) {
        this.first = first;
        this.rest = rest;
    }

    // returns image size for ConsILoI
    public int totalImageSize() {
        return this.first.imageSize() + this.rest.totalImageSize();
    }

    // returns text length for ConsILoI
    public int textLength() {
        return this.first.textLength() + this.rest.textLength();
    }

    // returns names of images, separated by a comma
    public String images() {
        if (this.first.images().length() == 0)
            return this.rest.images();
        
        if (this.rest.images().length() > 0 )
            return this.first.images() + ", " + this.rest.images();
        else
            return this.first.images();
    }
}

interface ILoI {
    // returns image size of list elements
    int totalImageSize();

    // returns text length of ILoI
    int textLength();

    // returns names of images, separated by a comma
    String images();
}

interface Item {
    // returns image size of Item
    int imageSize();

    // returns text length of Item
    int textLength();

    // returns names of images, separated by a comma
    String images();
}