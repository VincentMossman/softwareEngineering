/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PosPanels;

import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import DAOs.InventoryDB;
import pos.InventoryItem;

/**
 *
 * @author Omer
 */
public class AddItemFrame extends javax.swing.JFrame {

    /**
     * Creates new form AddItemFrame
     * @param inventoryP
     */
    public AddItemFrame(InventoryP inventoryP) {
        this.inventoryP=inventoryP;
        initComponents();
        initComponents2();
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addItemPanel = new javax.swing.JPanel();
        itemNameL = new javax.swing.JLabel();
        itemNameT = new javax.swing.JTextField();
        itemPriceL = new javax.swing.JLabel();
        itemPriceT = new javax.swing.JTextField();
        itemQntyL = new javax.swing.JLabel();
        itemQntyT = new javax.swing.JTextField();
        itemCatL = new javax.swing.JLabel();
        catMenuDDM = new javax.swing.JComboBox();
        addCatT = new javax.swing.JTextField();
        itemDescL = new javax.swing.JLabel();
        itemDescP = new javax.swing.JScrollPane();
        itemDescT = new javax.swing.JTextArea();
        itemDetailsL = new javax.swing.JLabel();
        addItemB = new javax.swing.JButton();
        clearB = new javax.swing.JButton();
        addCatB = new javax.swing.JButton();
        addSucc = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add New Item");
        setBounds(new java.awt.Rectangle(150, 150, 452, 406));
        setMinimumSize(new java.awt.Dimension(452, 406));
        setResizable(false);

        addItemPanel.setBackground(new java.awt.Color(255, 255, 255));

        itemNameL.setText("Item name:");

        itemNameT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                itemNameTKeyReleased(evt);
            }
        });

        itemPriceL.setText("Item price:");

        itemPriceT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                itemPriceTKeyReleased(evt);
            }
        });

        itemQntyL.setText("Item Quantity:");

        itemQntyT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                itemQntyTKeyReleased(evt);
            }
        });

        itemCatL.setText("Item Category:");

        addCatT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                addCatTKeyReleased(evt);
            }
        });

        itemDescL.setText("Item Description:");

        itemDescT.setColumns(20);
        itemDescT.setRows(5);
        itemDescT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                itemDescTKeyReleased(evt);
            }
        });
        itemDescP.setViewportView(itemDescT);

        itemDetailsL.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        itemDetailsL.setText("Item Details");

        addItemB.setText("ADD");
        addItemB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addItemBActionPerformed(evt);
            }
        });

        clearB.setText("Clear");
        clearB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBActionPerformed(evt);
            }
        });

        addCatB.setText("Add Cat");
        addCatB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCatBActionPerformed(evt);
            }
        });

        addSucc.setEditable(false);
        addSucc.setBackground(new java.awt.Color(255, 255, 255));
        addSucc.setBorder(null);

        javax.swing.GroupLayout addItemPanelLayout = new javax.swing.GroupLayout(addItemPanel);
        addItemPanel.setLayout(addItemPanelLayout);
        addItemPanelLayout.setHorizontalGroup(
            addItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addItemPanelLayout.createSequentialGroup()
                .addGroup(addItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addItemPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(addItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(addItemPanelLayout.createSequentialGroup()
                                .addGroup(addItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(itemNameL)
                                    .addComponent(itemPriceL)
                                    .addGroup(addItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(itemQntyL)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addItemPanelLayout.createSequentialGroup()
                                            .addComponent(itemCatL)
                                            .addGap(1, 1, 1))))
                                .addGap(18, 18, 18)
                                .addGroup(addItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(addItemPanelLayout.createSequentialGroup()
                                        .addComponent(addCatT, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(addCatB, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(addItemPanelLayout.createSequentialGroup()
                                        .addGroup(addItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(catMenuDDM, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(itemQntyT, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(itemNameT, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(itemPriceT, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addComponent(clearB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addComponent(itemDetailsL)
                            .addGroup(addItemPanelLayout.createSequentialGroup()
                                .addComponent(itemDescL)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(addItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(addSucc)
                                    .addComponent(itemDescP, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)))))
                    .addGroup(addItemPanelLayout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(addItemB, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        addItemPanelLayout.setVerticalGroup(
            addItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addItemPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(itemDetailsL)
                .addGap(22, 22, 22)
                .addGroup(addItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(itemNameL)
                    .addComponent(itemNameT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearB))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(itemPriceL)
                    .addComponent(itemPriceT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(itemQntyL)
                    .addComponent(itemQntyT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(itemCatL)
                    .addComponent(catMenuDDM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(addCatT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addCatB))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(itemDescL)
                    .addComponent(itemDescP, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addSucc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addItemB)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(addItemPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(addItemPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void initComponents2() {
        DB=new InventoryDB();
        ArrayList<String> cat=DB.getCategories();
        catMenuDDM.addItem("");
        cat.stream().forEach((cat1) -> {
            catMenuDDM.addItem(cat1);
        });
    }
    private void addItemBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addItemBActionPerformed
        if(!itemNameT.getText().isEmpty()&&
           !itemPriceT.getText().isEmpty()&&
           !itemQntyT.getText().isEmpty()&&
           !itemDescT.getText().isEmpty()&&
           isNumeric(itemPriceT.getText())&&
           isNumeric(itemQntyT.getText())&&
           !catMenuDDM.getSelectedItem().equals("")){
            int n = JOptionPane.showConfirmDialog(this,"Add item user?","Confimation",JOptionPane.YES_NO_OPTION);
            if(n==0){
            try {
                String newItemID = DB.newItemID(catMenuDDM.getSelectedItem().toString());
                InventoryItem item=new InventoryItem(newItemID,itemNameT.getText(),
                        catMenuDDM.getSelectedItem().toString(),itemDescT.getText(),
                        "TRUE",itemQntyT.getText(),itemPriceT.getText(),"");
                DB.addNewItem(item);
                JOptionPane.showMessageDialog(this, "New item: '"+itemNameT.getText()+"' added!");
                
                catMenuDDM.setSelectedItem("");
                itemPriceT.setText("");
                itemQntyT.setText("");
                itemDescT.setText("");
                itemNameT.requestFocus();
                addCatT.setText("");
                addSucc.setText("Item "+itemNameT.getText()+" is Added!");
                itemNameT.setText("");
                inventoryP.setResultTable(item.getName(),item.getCategory(),item.getId());
                
            } catch (SQLException ex) {
                addSucc.setText("Invalid information!");
            }}
        }else addSucc.setText("Please fill all fields with valid info!");
    }//GEN-LAST:event_addItemBActionPerformed

    private void addCatBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCatBActionPerformed
        if(!addCatT.getText().isEmpty()){
            catMenuDDM.addItem(addCatT.getText());
            inventoryP.catMenuDDM.addItem(addCatT.getText());
            inventoryP.catMenuDDM1.addItem(addCatT.getText());
            catMenuDDM.setSelectedItem(addCatT.getText());
            itemDescT.requestFocus();
            addCatT.setText("");
        }
        
    }//GEN-LAST:event_addCatBActionPerformed

    private void clearBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBActionPerformed
        catMenuDDM.setSelectedItem("");
        itemPriceT.setText("");
        itemQntyT.setText("");
        itemDescT.setText("");
        addCatT.setText("");
        addSucc.setText("");
        itemNameT.setText("");
    }//GEN-LAST:event_clearBActionPerformed

    private void itemNameTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_itemNameTKeyReleased
        if (evt.getKeyCode()==KeyEvent.VK_QUOTE){
            itemNameT.setText(itemNameT.getText().replaceAll("'", ""));}
    }//GEN-LAST:event_itemNameTKeyReleased

    private void itemPriceTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_itemPriceTKeyReleased
        if (evt.getKeyCode()==KeyEvent.VK_QUOTE){
            itemPriceT.setText(itemPriceT.getText().replaceAll("'", ""));}
    }//GEN-LAST:event_itemPriceTKeyReleased

    private void itemQntyTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_itemQntyTKeyReleased
        if (evt.getKeyCode()==KeyEvent.VK_QUOTE){
            itemQntyT.setText(itemQntyT.getText().replaceAll("'", ""));}
    }//GEN-LAST:event_itemQntyTKeyReleased

    private void addCatTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_addCatTKeyReleased
        if (evt.getKeyCode()==KeyEvent.VK_QUOTE){
            addCatT.setText(addCatT.getText().replaceAll("'", ""));}
        if (evt.getKeyCode()==KeyEvent.VK_ENTER){
            addCatB.doClick();}
    }//GEN-LAST:event_addCatTKeyReleased

    private void itemDescTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_itemDescTKeyReleased
        if (evt.getKeyCode()==KeyEvent.VK_QUOTE){
            itemDescT.setText(itemDescT.getText().replaceAll("'", ""));}
         if (evt.getKeyCode()==KeyEvent.VK_ENTER){
            addItemB.doClick();}
    }//GEN-LAST:event_itemDescTKeyReleased
    public static boolean isNumeric(String str){  
      try{  
        double d = Double.parseDouble(str);  
      } catch(NumberFormatException e){  
        return false;  
      }  
      return true;  
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addCatB;
    private javax.swing.JTextField addCatT;
    private javax.swing.JButton addItemB;
    private javax.swing.JPanel addItemPanel;
    private javax.swing.JTextField addSucc;
    private javax.swing.JComboBox catMenuDDM;
    private javax.swing.JButton clearB;
    private javax.swing.JLabel itemCatL;
    private javax.swing.JLabel itemDescL;
    private javax.swing.JScrollPane itemDescP;
    private javax.swing.JTextArea itemDescT;
    private javax.swing.JLabel itemDetailsL;
    private javax.swing.JLabel itemNameL;
    private javax.swing.JTextField itemNameT;
    private javax.swing.JLabel itemPriceL;
    private javax.swing.JTextField itemPriceT;
    private javax.swing.JLabel itemQntyL;
    private javax.swing.JTextField itemQntyT;
    // End of variables declaration//GEN-END:variables
    private InventoryDB DB;
    private final InventoryP inventoryP;
}
