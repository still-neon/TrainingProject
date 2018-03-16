package by.stn.java_exercises.modul_2;

import java.applet.Applet;
import java.awt.*;

/*
<applet code="SimpleApplet" width=200 height=60>
</applet>

 */

/**
 * Created by EugenKrasotkin on 3/15/2018.
 */
public class Banner extends Applet implements Runnable {
    String msg = " Java Rules the web ";
    Thread t;
    boolean stopFlag;

    @Override
    public void init() {
        t = null;
    }
    @Override
    public void start() {
        t = new Thread(this);
        stopFlag = false;
        t.start();
    }
    @Override
    public void stop() {
        stopFlag = true;
        t = null;
    }
    @Override
    public void paint(Graphics g) {
        char ch;
        ch = msg.charAt(0);
        msg = msg.substring(1, msg.length());
        msg += ch;
        g.drawString(msg, 50, 50);
        showStatus("Message");
    }

    @Override
    public void run() {
        for (; ; ) {
            try {
                repaint();
                Thread.sleep(250);
                if (stopFlag) {
                    break;
                }
            } catch (InterruptedException exc) {
            }
        }
    }
}