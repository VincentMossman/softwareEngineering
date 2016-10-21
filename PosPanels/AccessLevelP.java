/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PosPanels;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import DAOs.CurrentUserDB;
import java.io.File;

/**
 *
 * @author Omer
 */
public class AccessLevelP extends javax.swing.JPanel {

    /**
     * Creates new form accessLevelP
     * @param mainframe
     */
    public AccessLevelP(MainFrame mainframe) {
        this.mainframe=mainframe;
        enable=mainframe.getCurrentUser().getDept();
        initComponents();
        enableBtn();
        try {
            image =ImageIO.read(new File(this.getClass().getClassLoader().getResource("").getPath()+"Commons\\WelcomeScreen.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(LoginPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        inventoryBtn = new javax.swing.JButton();
        usersBtn = new javax.swing.JButton();
        reportsBtn = new javax.swing.JButton();
        logoutB = new javax.swing.JButton();
        refundB = new javax.swing.JButton();
        saleB = new javax.swing.JButton();
        changePWL = new javax.swing.JLabel();
        cPWL = new javax.swing.JLabel();
        nPWL = new javax.swing.JLabel();
        cNPWL = new javax.swing.JLabel();
        currentPWT = new javax.swing.JPasswordField();
        newPWT = new javax.swing.JPasswordField();
        confirmPWT = new javax.swing.JPasswordField();
        pwUpdatedT = new javax.swing.JTextField();
        changeB = new javax.swing.JButton();
        clearB = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(1000, 600));

        inventoryBtn.setText("Inventory");
        inventoryBtn.setEnabled(false);
        inventoryBtn.setMaximumSize(new java.awt.Dimension(90, 23));
        inventoryBtn.setMinimumSize(new java.awt.Dimension(90, 23));
        inventoryBtn.setPreferredSize(new java.awt.Dimension(90, 23));
        inventoryBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inventoryBtnActionPerformed(evt);
            }
        });

        usersBtn.setText("Users");
        usersBtn.setEnabled(false);
        usersBtn.setPreferredSize(new java.awt.Dimension(90, 23));
        usersBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usersBtnActionPerformed(evt);
            }
        });

        reportsBtn.setText("Reports");
        reportsBtn.setEnabled(false);
        reportsBtn.setPreferredSize(new java.awt.Dimension(90, 23));

        logoutB.setText("Logout");
        logoutB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBActionPerformed(evt);
            }
        });

        refundB.setText("Refund");
        refundB.setEnabled(false);
        refundB.setPreferredSize(new java.awt.Dimension(90, 23));

        saleB.setText("Sales");
        saleB.setEnabled(false);
        saleB.setMaximumSize(new java.awt.Dimension(45, 23));
        saleB.setMinimumSize(new java.awt.Dimension(45, 23));
        saleB.setPreferredSize(new java.awt.Dimension(45, 23));
        saleB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saleBActionPerformed(evt);
            }
        });

        changePWL.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        changePWL.setText("Change password:");

        cPWL.setText("Current password:");

        nPWL.setText("New password:");

        cNPWL.setText("Confirm password:");

        currentPWT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                currentPWTKeyReleased(evt);
            }
        });

        newPWT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                newPWTKeyReleased(evt);
            }
        });

        confirmPWT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                confirmPWTKeyReleased(evt);
            }
        });

        pwUpdatedT.setEditable(false);
        pwUpdatedT.setBackground(new java.awt.Color(255, 255, 255));
        pwUpdatedT.setBorder(null);

        changeB.setText("Change");
        changeB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeBActionPerformed(evt);
            }
        });

        clearB.setText("Clear");
        clearB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(912, Short.MAX_VALUE)
                        .addComponent(logoutB, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(300, 300, 300)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(reportsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(refundB, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(saleB, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inventoryBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usersBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cPWL)
                            .addComponent(nPWL)
                            .addComponent(cNPWL))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(confirmPWT, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(newPWT, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(currentPWT, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(changeB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(clearB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(pwUpdatedT)))
                    .addComponent(changePWL))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logoutB)
                .addGap(123, 123, 123)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inventoryBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(refundB, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saleB, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usersBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reportsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(71, 71, 71)
                .addComponent(changePWL)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cPWL)
                    .addComponent(currentPWT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(changeB))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nPWL)
                    .addComponent(newPWT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearB))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cNPWL)
                    .addComponent(confirmPWT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pwUpdatedT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73))
        );
    }// </editor-fold>//GEN-END:initComponents
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0,0, this);
    }
    private void usersBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usersBtnActionPerformed
            mainframe.frameReset();
            mainframe.getContentPane().add(new UserMgmtP(mainframe));
            mainframe.getContentPane().revalidate();
    }//GEN-LAST:event_usersBtnActionPerformed
    private void logoutBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBActionPerformed
        
        mainframe.frameReset();
        mainframe.getContentPane().add(new LoginPanel(mainframe));
        mainframe.getContentPane().revalidate();
    }//GEN-LAST:event_logoutBActionPerformed
    private void inventoryBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inventoryBtnActionPerformed
        mainframe.frameReset();
        mainframe.getContentPane().add(new InventoryP(mainframe));
        mainframe.getContentPane().revalidate();
    }//GEN-LAST:event_inventoryBtnActionPerformed

    private void confirmPWTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_confirmPWTKeyReleased
        if (evt.getKeyCode()==KeyEvent.VK_ENTER){
            changeB.doClick();
        }
        if (evt.getKeyCode()==KeyEvent.VK_QUOTE){
            newPWT.setText("");
            JOptionPane.showMessageDialog(mainframe, "Password cannot contain ( ' )");
        }
    }//GEN-LAST:event_confirmPWTKeyReleased

    private void changeBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeBActionPerformed
        if(currentPWT.getText().isEmpty()||
                newPWT.getText().isEmpty()||
                confirmPWT.getText().isEmpty()){
            pwUpdatedT.setText("Fill in all fields!");
        }else if(!currentPWT.getText().equals(mainframe.getCurrentUser().getPassword())){
            pwUpdatedT.setText("Invalid current password!");
            currentPWT.setText("");
        }else if(newPWT.getText().contains("'")){
            pwUpdatedT.setText("Password cannot contain ( ' )!");
            newPWT.setText("");
            confirmPWT.setText("");
        }else if(!newPWT.getText().equals(confirmPWT.getText())){
            newPWT.setText("");
            confirmPWT.setText("");
            pwUpdatedT.setText("New password does not match!");
        }else if(currentPWT.getText().equals(mainframe.getCurrentUser().getPassword())&&
                newPWT.getText().equals(confirmPWT.getText())){
            new CurrentUserDB().changePW(mainframe.getCurrentUser(),newPWT.getText());
            pwUpdatedT.setText("Password updated!");
            currentPWT.setText("");
            newPWT.setText("");
            confirmPWT.setText("");
        }
    }//GEN-LAST:event_changeBActionPerformed

    private void clearBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBActionPerformed
        currentPWT.setText("");
        newPWT.setText("");
        confirmPWT.setText("");
        pwUpdatedT.setText("");
    }//GEN-LAST:event_clearBActionPerformed

    private void saleBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saleBActionPerformed
        mainframe.frameReset();
        mainframe.getContentPane().add(new SaleP(mainframe));
        mainframe.getContentPane().revalidate();
    }//GEN-LAST:event_saleBActionPerformed

    private void currentPWTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_currentPWTKeyReleased
        if (evt.getKeyCode()==KeyEvent.VK_QUOTE){
            currentPWT.setText(currentPWT.getText().replaceAll("'", ""));}
    }//GEN-LAST:event_currentPWTKeyReleased

    private void newPWTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_newPWTKeyReleased
        if (evt.getKeyCode()==KeyEvent.VK_QUOTE){
            newPWT.setText("");
            JOptionPane.showMessageDialog(mainframe, "Password cannot contain ( ' )");
        }
    }//GEN-LAST:event_newPWTKeyReleased
    private void enableBtn() {
        
        if(null != enable)switch (enable) {
            case "Sales":
                saleB.setEnabled(true);
                refundB.setEnabled(true);
                break;
            case "Inventory":
                inventoryBtn.setEnabled(true);
                break;
            case "Management":
                saleB.setEnabled(true);
                refundB.setEnabled(true);
                reportsBtn.setEnabled(true);
                usersBtn.setEnabled(true);
                inventoryBtn.setEnabled(true);
                break;
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cNPWL;
    private javax.swing.JLabel cPWL;
    private javax.swing.JButton changeB;
    private javax.swing.JLabel changePWL;
    private javax.swing.JButton clearB;
    private javax.swing.JPasswordField confirmPWT;
    private javax.swing.JPasswordField currentPWT;
    private javax.swing.JButton inventoryBtn;
    private javax.swing.JButton logoutB;
    private javax.swing.JLabel nPWL;
    private javax.swing.JPasswordField newPWT;
    private javax.swing.JTextField pwUpdatedT;
    private javax.swing.JButton refundB;
    private javax.swing.JButton reportsBtn;
    private javax.swing.JButton saleB;
    private javax.swing.JButton usersBtn;
    // End of variables declaration//GEN-END:variables
    private final String enable;
    private BufferedImage image;
    private MainFrame mainframe;
}