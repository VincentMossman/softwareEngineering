/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos;

import PosPanels.LoginPanel;
import PosPanels.MainFrame;

/**
 *
 * @author Omer
 */
public class POS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MainFrame mainframe = new MainFrame();
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                
                
                mainframe.setVisible(true);
                mainframe.add(new LoginPanel(mainframe));
            }
        });
    }
    
}