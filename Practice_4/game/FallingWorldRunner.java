// assignment 4
// pair 043
// Wright Steven
// wrights
// Wang Shiyu
// shiyu

import java.awt.Color;
import javalib.worldimages.*;
import javalib.worldcanvas.*;
import javalib.funworld.*;
import tester.Tester;

// test the display of images for the platform game and run
public class FallingWorldRunner{
    ExamplesFallingWorld efw = new ExamplesFallingWorld();

    WorldCanvas c1 = new WorldCanvas(400, 400);
    WorldImage player = this.efw.play1.image();
    WorldImage platform = this.efw.plat1.image();
    
    //show the player, rock, and the platform on one canvas 
    boolean makeDrawing1 = 
        c1.show() && 
        c1.drawImage(this.player) &&
        c1.drawImage(this.platform);
    // run the game
    boolean run(){
        return this.efw.realWorld.bigBang(400, 400, .1);

    }

    // bootstrap
    public static void main(String [] argv){
        FallingWorldRunner fwr = new FallingWorldRunner();
        fwr.run();
    }
    
    
}
