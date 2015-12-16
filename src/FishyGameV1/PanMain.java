/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package FishyGameV1;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;

/**
 *
 * @author schie3227
 */
class PanMain extends JPanel implements ActionListener {

    Image FishBG;
    Image FishR;
    Image FishL;
    Image FishMain;
    double dFishX = 350, dFishY = 270;
    double dSpdHoriz = 0, dSpdVert = 0;
    int nSize = 100;
    boolean isSlowingHoriz = false, isSlowingVert = false;

    PanMain() throws IOException {
        FishBG = ImageIO.read(new File("FishBackground.png"));
        FishR = ImageIO.read(new File("FishRight.png"));
        FishL = ImageIO.read(new File("FishLeft.png"));
        FishMain = FishR;
        //KeyInput keyInput = new KeyInput();
        //add(FishBG);
        addKeyListener(new KeyInput());
        setFocusable(true);
        Timer timer;
        timer = new Timer(5, this);
        timer.start();
    }

    public void actionPerformed(ActionEvent e) {
        dFishX += dSpdHoriz;
        dFishY += dSpdVert;
        if (isSlowingHoriz) {
            slowSpriteHoriz();
        }
        if (isSlowingVert) {
            slowSpriteVert();
        }
        repaint();


    }

    @Override
    public void paint(Graphics g) {
        // Draws the img to the BackgroundPanel.
        g.drawImage(FishBG, 0, 0, getWidth(), getHeight(), null);
        g.drawImage(FishMain, (int)dFishX, (int)dFishY, nSize, nSize, null);

    }

    public void slowSpriteHoriz() {
        if (dSpdHoriz != 0) {
            if (dSpdHoriz < 0) {
                dSpdHoriz += 1;
            } else {
                dSpdHoriz += -1;
            }
        } else {
            isSlowingHoriz = false;
        }

    }
    public void slowSpriteVert() {
        if (dSpdVert != 0) {
            if (dSpdVert < 0) {
                dSpdVert += 1;
            } else {
                dSpdVert += -1;
            }
        } else {
            isSlowingVert = false;
        }

    }

    class KeyInput implements KeyListener {

        String sInput;
        char chInput;

        @Override
        public void keyTyped(KeyEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void keyPressed(KeyEvent e) {

            int keyCode = e.getKeyCode();
            switch (keyCode) {
                case KeyEvent.VK_UP:
                    if (dSpdVert == 0) {
                        dSpdVert = -5;
                    }
                    if (dSpdVert != -10) {
                        dSpdVert += -0.5;
                    }
                    break;


                case KeyEvent.VK_DOWN:
                    if (dSpdVert == 0) {
                        dSpdVert = 5;
                    }
                    if (dSpdVert != 10) {
                        dSpdVert += 0.5;
                    }
                    break;
                case KeyEvent.VK_LEFT:
                    FishMain = FishL;
                    if (dSpdHoriz == 0) {
                        dSpdHoriz = -5;
                    }
                    if (dSpdHoriz != -15) {
                        dSpdHoriz += -0.5;
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    FishMain = FishR;
                    if (dSpdHoriz == 0) {
                        dSpdHoriz = 5;
                    }
                    if (dSpdHoriz != 15) {
                        dSpdHoriz += 0.5;
                    }
                    break;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode) {
                case KeyEvent.VK_UP:
                    isSlowingVert = true;
                    //System.out.println(nFishY);
                    break;
                case KeyEvent.VK_DOWN:
                    isSlowingVert = true;
                    break;
                case KeyEvent.VK_LEFT:
                    isSlowingHoriz = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    isSlowingHoriz = true;
                    break;
            }


        }
    }
}
