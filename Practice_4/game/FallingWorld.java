// assignment 4
// pair 043
// Wright Steven
// wrights
// Wang Shiyu
// shiyu

import tester.*;
import javalib.funworld.*;
import javalib.worldcanvas.*;
import javalib.worldimages.*;
import javalib.colors.*;
import java.awt.Color;

// contains the whole world!
class FallingWorld extends World {
    Player     player;
    ILoP   platform;
    int        score;

    // CONSTANTS:
    Color      SKYBLUE    = new Color(50, 150, 255);
    int        WIDTH      = 400;
    int        HEIGHT     = 400;
    WorldImage BACKGROUND = new RectangleImage(new Posn(WIDTH / 2, HEIGHT / 2),
                                  WIDTH, HEIGHT, SKYBLUE);

    public WorldImage makeImage() {
        return BACKGROUND.overlayImages(this.platform.image(),  this.player.image(),
                new TextImage(new Posn(WIDTH / 2, 30),
                        "Score: " + this.score, Color.red));
    }
    // After each tick, check if the player hit the ground
    // if yes, end the game
    public WorldEnd worldEnds() {
        if (this.score == 10000 || this.player.shape.center.y > 400)
            return new WorldEnd(true, this.makeImage().overlayImages(
                    new TextImage(new Posn(WIDTH / 2, HEIGHT / 2),
                            "Game Over", Color.red)));
        else
            return (new WorldEnd(false, this.makeImage()));
        }
    // handle events, player needs to know things about platform so we passed it
    // here.
    public FallingWorld onKeyEvent(String ke) {
        return new FallingWorld(this.player.onKeyEvent(ke, platform), this.platform, this.score);
    }

    // onTick
    public FallingWorld onTick() {
        if (this.platform.above(this.player))
            return new FallingWorld(this.player.updateDy(1).fall(), this.platform.fall(), this.score + 1);
        else
            return new FallingWorld(this.player.fall().updateROC(1),
                    this.platform.fall(), this.score + 1);
    }

    FallingWorld(Player player, ILoP platform, int score) {
        this.player = player;
        this.platform = platform;
        this.score = score;
    }
}

// luckily certain objects share properties
abstract class AObject {
    Rectangle shape;
    int    dy;

    AObject(Rectangle shape, int dy) {
        this.shape = shape;
        this.dy = dy;
    }

    WorldImage image() {
        return shape.image();
    }

    int height() {
        return shape.halfHeight();
    }
}

// I'm a rectange
class Rectangle {
    CartPt center;
    int    width;
    int    height;

    Rectangle(CartPt center, int width, int height) {
        this.center = center;
        this.width = width;
        this.height = height;
    }

    // moves a rectangle
    public Rectangle moveBy(int x, int y) {
        return new Rectangle(this.center.moveBy(x, y), this.width, this.height);
    }

    // produces this rectangles image
    public WorldImage image() {
        return new RectangleImage(this.center, this.width, this.height,
                new Blue());
    }

    // reveals half the height of the rectangle
    public int halfHeight() {
        return (this.height / 2);
    }

    // reveals half the width of the rectangle
    public int halfWidth() {
        return (this.width / 2);
    }

}

// extension of the Posn class with move methods
class CartPt extends Posn {
    CartPt(int x, int y) {
        super(x, y);
    }

    // produce a point moved by the given distance from this point
    CartPt moveBy(int dx, int dy) {
        return new CartPt(this.x + dx, this.y + dy);
    }

    // Compute the distance from this point to the given one
    double distTo(CartPt that) {
        return Math.sqrt((this.x - that.x) * (this.x - that.x)
                + (this.y - that.y) * (this.y - that.y));
    }

    // Compute the change in Y from this point to the given one
    // if + then that is below this
    // if - then that is above this
    int changeY(CartPt that) {
        return that.y - this.y;
    }

    // Compute the change in X from this point to the given one
    // if + then that is left of this
    // if - then that is right of this
    int changeX(CartPt that) {
        return that.x - this.x;
    }
}

// represents a player
class Player extends AObject {
    int rateOfChange;

    Player(Rectangle shape, int dy, int rateOfChange) {
        super(shape, dy);
        this.rateOfChange = rateOfChange;
    }

    Player onKeyEvent(String ke, ILoP p) {
        if (ke.equals("left"))
            return this.moveLeft();
        if (ke.equals("right"))
            return this.moveRight();
        if (ke.equals("up") && p.above(this))
            return this.jump();
        else
            return this;
    }

    // from this player produce a new player. moves left a bit
    Player moveLeft() {
        return new Player(this.shape.moveBy(-10, 0), this.dy, this.rateOfChange);
    }

    // from this player produce a new player. moves right a bit
    Player moveRight() {
        return new Player(this.shape.moveBy(10, 0), this.dy, this.rateOfChange);
    }

    // from this player produce a new player. jump up a bit
    Player jump() {
        return new Player(this.shape.moveBy(0, -7), -10, this.rateOfChange);
    }

    // falls the player
    public Player fall() {
        return new Player(this.shape.moveBy(0, dy), (dy + rateOfChange),
                this.rateOfChange);
    }

    // updates the Rate of Change of players fall
    public Player updateROC(int value) {
        return new Player(this.shape, this.dy, value);
    }

    // update the y-velocity of a player
    public Player updateDy(int value) {
        return new Player(this.shape, value, this.rateOfChange);
    }

}

// i'm a platform
class Platform extends AObject {
    int startingHeight;

    Platform(Rectangle shape, int dy, int startingHeight) {
        super(shape, dy);
        this.startingHeight = startingHeight;
    }

    // returns true if player is above some platform
    public boolean above(Player p) {
        if (p.shape.center.changeY(this.shape.center) > 0)
            return (Math.abs(p.shape.center.changeX(this.shape.center)) < this.shape
                    .halfWidth())
                    && p.shape.center.changeY(this.shape.center) < p.shape
                            .halfHeight()
                            + this.shape.halfHeight();
        else
            return false;
    }
    
    
    // platforms fall
    public Platform fall() {
        return new Platform(this.shape.moveBy(0, dy), this.dy,
                this.startingHeight);
    }
}

interface ILoP{
    // is a player above a platform?
    boolean above(Player p);
    // render the images
    WorldImage image();
    // is the list empty
    boolean isEmpty();
    // fall em all
    ILoP fall();
    // align the player
};

class ConsLoP implements ILoP {
    Platform first;
    ILoP  rest;
    ConsLoP(Platform first, ILoP rest) {
        this.first = first;
        this.rest = rest;
    }
    
    // return true if player is above any platform
    public boolean above(Player p) {
        return first.above(p) || rest.above(p);
    }
    
    // render the image
    public WorldImage image(){
        if (this.rest.isEmpty())
            return this.first.image();
        else
            return this.first.image().overlayImages(rest.image());
    }
    
    // return false, always
    public boolean isEmpty(){
        return false;
    }
    
    // fall em all
    public ILoP fall() {
        return new ConsLoP(first.fall(), rest.fall());
    }
}



class MtLoP implements ILoP {
    MtLoP(){}
    
    public WorldImage image(){
        return null;
    }
    // return false, always
    public boolean above(Player p) {
        return false;
    }
    
    // return true, always
    public boolean isEmpty(){
        return true;
    }
    
    // fall em all.
    public ILoP fall() {
        return this;
    }
            
 }