/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package FishyGameV1;

import java.io.IOException;
import javax.swing.JFrame;

/**
 *
 * @author schie3227
 */
class FraMain extends JFrame{
    FraMain() throws IOException{
        PanMain panMain = new PanMain();
        add(panMain);
        setTitle("Fishy Game");
        setSize(java.awt.Toolkit.getDefaultToolkit().getScreenSize().width,java.awt.Toolkit.getDefaultToolkit().getScreenSize().height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }
}
