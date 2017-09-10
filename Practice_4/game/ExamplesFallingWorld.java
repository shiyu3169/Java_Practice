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

class ExamplesFallingWorld {

    // two sample CartPt
    CartPt cp0 = new CartPt(10, 10);
    CartPt cp1 = new CartPt(10, 20);
    CartPt cp2 = new CartPt(200, 200);
    CartPt cp3 = cp2.moveBy(0, -100);
    CartPt cp4 = cp2.moveBy(0, -200);
    CartPt cp5 = new CartPt(0, 22);
    CartPt cp6 = new CartPt(200, 200);
    CartPt cp7 = new CartPt(200, 187);
    
 // shapes for rocks, players, platforms

    Rectangle rec0 = new Rectangle(cp0, 10, 20);
    Rectangle rec1 = new Rectangle(cp0, 1, 20);
    Rectangle rec2 = new Rectangle(cp3, 10, 200);
    Rectangle rec3 = new Rectangle(cp4, 100, 20);
    Rectangle rec4 = new Rectangle(cp5, 4, 20);
    Rectangle rec5 = new Rectangle(cp6, 40, 6);
    Rectangle rec6 = new Rectangle(cp7, 6, 20);
   
    // sample player
    Player play0 = new Player(rec0, 10, 5);
    Player play1 = new Player(rec3, 10, 5);
    Player play2 = new Player(rec6, 1, 1);
    
    // sample platform
    Platform plat0 = new Platform(rec1, 10, 20);
    Platform plat1 = new Platform(rec2, 10, 20);
    Platform plat2 = new Platform(rec4, 10, 20);
    Platform plat3 = new Platform(rec5, 1, 20);
    
    MtLoP    mt = new ConsLoP()
    ConsLoP  l0 = new ConsLoP(pl)
    
    // world used for game init.
    FallingWorld realWorld = new FallingWorld(play2, plat3, 0);
    
    // test the method moveBy for the class CartPt
    boolean testMoveByCartPt(Tester t) {
        return t.checkExpect(this.cp0.moveBy(0, 10), this.cp1);
    }

    // test the method distTo for the class CartPt
    boolean testdistToCartPt(Tester t) {
        return t.checkExpect(cp0.distTo(cp1), 10.0);
    }
    
    // test changeY method for class CartPt
    boolean testChangeY(Tester t) {
        return t.checkExpect(cp0.changeY(cp1), 10);
    }
    
    // test changeX method for class CartPt
    boolean testChangeX(Tester t) {
        return t.checkExpect(cp1.changeX(cp2), 190
                );
    }

    // test the method moveBy for the Class Rectangle
    boolean testMoveByIShapes(Tester t) {
return t.checkExpect(rec1.moveBy(1, 1), new Rectangle(rec1.center.moveBy(1, 1), rec1.width, rec1.height));    }

    // test the method HalfHeight for the Class Rectangle
    boolean testHalfHeight(Tester t) {
                return t.checkExpect(rec1.halfHeight(), 10);
    }
    // test the center  for the Class Rectangle
    boolean testCenter(Tester t) {
              return t.checkExpect(rec1.center, cp0);
    }
    //test the method moveLeft for the class Player
    boolean testMoveLeft(Tester t){
        return t.checkExpect(play0.moveLeft(), new Player(play0.shape.moveBy(-10, 0), play0.dy, play0.rateOfChange)) &&
               t.checkExpect(play1.moveLeft(), new Player(play1.shape.moveBy(-10, 0), play1.dy, play1.rateOfChange));
    }
    //test the method moveRight for the class Player
    boolean testMoveRight(Tester t){
        return t.checkExpect(play0.moveRight(), new Player(play0.shape.moveBy(10, 0), play0.dy, play0.rateOfChange)) &&
               t.checkExpect(play1.moveRight(), new Player(play1.shape.moveBy(10, 0), play1.dy, play1.rateOfChange));
    }
    
    //test the method moveRight for the class Player
    boolean testJump(Tester t){
        return t.checkExpect(play0.jump(), new Player(play0.shape, -10, play0.rateOfChange)) &&
               t.checkExpect(play1.jump(), new Player(play1.shape, -10, play1.rateOfChange));
    }
    
    //test onKeyEvent method for the class Player
    boolean testOnKeyEvent(Tester t) {
        return t.checkExpect(play0.onKeyEvent("left", plat0), play0.moveLeft()) &&
                t.checkExpect(play0.onKeyEvent("right", plat0), play0.moveRight()) &&
                t.checkExpect(play0.onKeyEvent("jump", plat0), play0) &&
                t.checkExpect(play2.onKeyEvent("up", plat3), play2.jump());
                
    }
    
    //test updateROC method for the class Player
    boolean testUpdateROC(Tester t) {
        return t.checkExpect(play0.updateROC(0), new Player(play0.shape, play0.dy, 0)) &&
               t.checkExpect(play0.updateROC(10), new Player(play0.shape, play0.dy, 10));
    }
    
    //test updateDy method for the class Player
    boolean testUpdateDy(Tester t) {
        return t.checkExpect(play0.updateDy(0), new Player(play0.shape, 0, play0.rateOfChange)) &&
               t.checkExpect(play0.updateDy(10), new Player(play0.shape, 10, play0.rateOfChange));
    }
    
    //test above method for the class Player
    boolean testAbovePlayer(Tester t) {
        return t.checkExpect(play2.above(plat3), true);
    }
    
    //test the fall method for Platform, and Player
    boolean testFall(Tester t) {
            return t.checkExpect(play0.fall(), new Player(rec0.moveBy(0,10), 15, 5))
            && t.checkExpect(plat0.fall(), new Platform(rec1.moveBy(0, 10), 10, 20));
    }
    
}
