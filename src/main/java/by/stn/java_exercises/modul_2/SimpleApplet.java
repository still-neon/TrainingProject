package by.stn.java_exercises.modul_2;

import java.applet.Applet;
import java.awt.*;
/*
<applet code="SimpleApplet" width=200 height=60>
</applet>

 */

/**
 * Created by EugenKrasotkin on 3/13/2018.
 */
public class SimpleApplet extends Applet {
    public void paint(Graphics g) {
        g.drawString("Hello applet!", 20, 20);
    }
}
