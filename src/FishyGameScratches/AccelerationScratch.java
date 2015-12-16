package FishyGameScratches;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class AccelerationScratch {

    public static void main(String[] args) {
        FraMain fraMain = new FraMain();



    }

    private static class FraMain extends JFrame {

        PanMain panMain = new PanMain();

        public FraMain() {
            add(panMain);

            setTitle("Acceleration Scratch");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
            setSize(500, 500);
        }
    }
}

class PanMain extends JPanel implements ActionListener {

    int nX;
    double dSpd = 0, dX = 50;
    boolean isSlowing = false;

    public PanMain() {
        
        addKeyListener(new KeyInput());
        setFocusable(true);
        Timer timer;
        timer = new Timer(60, this);
        timer.start();
    }

    public void actionPerformed(ActionEvent e) {
        dX += dSpd;
        if (isSlowing) {
            slowSprite();
        }
        repaint();

    }

    public void paint(Graphics g) {
        super.paintComponent(g); 
        g.fillRect((int) dX, 200, 50, 50);

    }

    public void slowSprite() {
        if (dSpd != 0) {
            if (dSpd < 0) {
                dSpd += 0.5;
            } else {
                dSpd += -0.5;
            }
        } else {
            isSlowing = false;
        }

    }

    class KeyInput implements KeyListener {

        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            if (keyCode == KeyEvent.VK_LEFT) {
                if (dSpd == 0) {
                    dSpd = -1.5;
                }
                if (dSpd != -8) {
                    dSpd += -0.5;
                }
            } else if (keyCode == KeyEvent.VK_RIGHT) {
                if (dSpd == 0) {
                    dSpd = 1.5;
                }
                if (dSpd != 8) {
                    dSpd += 0.5;
                }
            }



            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void keyTyped(KeyEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode) {
                case KeyEvent.VK_LEFT:
                    isSlowing = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    isSlowing = true;
                    break;
            }
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
}
