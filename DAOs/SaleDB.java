/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import pos.InventoryItem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Omer
 */

    
public class SaleDB {
    
    public SaleDB(){
        
        String path=this.getClass().getClassLoader().getResource("").getPath()+"/DataBases/MainDB.accdb";
        uHost="jdbc:ucanaccess:/"+path;
        try {
            
            DB=DriverManager.getConnection(uHost);
            stmt= DB.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                    ResultSet.CONCUR_READ_ONLY);
        } catch (SQLException ex) {
            Logger.getLogger(UsersDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public InventoryItem eFindItem(String id) throws SQLException {
        InventoryItem result=new InventoryItem();
      
        rs=stmt.executeQuery("select * from INVENTORY where ID='"+id+"'");
        rs.next();
        result.setName(rs.getString("NAME"));
        result.setActive(rs.getString("ACTIVE"));
        result.setCategory(rs.getString("CAT"));
        result.setDesc(rs.getString("DESC"));
        result.setId(rs.getString("ID"));
        result.setOldID(rs.getString("OLDID"));
        result.setPrice(rs.getString("PRICE"));
        result.setQty(rs.getString("QNTY"));
                    
        return result;
    }

    public void ReduceQnty(ArrayList<InventoryItem> cart) throws SQLException {
        for (InventoryItem cart1 : cart) {
            SQL = "select * from INVENTORY where ID='" + cart1.getId() + "'";
            rs=stmt.executeQuery(SQL);
            rs.next();
            int Qnty= Integer.valueOf(rs.getString("QNTY"));
            stmt.execute("update INVENTORY set QNTY='" + String.valueOf(Qnty - Integer.valueOf(cart1.getQty())) + "' where ID='" + cart1.getId() + "'");
        }
    }
    
    public void ReturnQnty(ArrayList<InventoryItem> cart) throws SQLException {
        for (InventoryItem cart1 : cart) {
            SQL = "select * from INVENTORY where ID='" + cart1.getId() + "'";
            rs=stmt.executeQuery(SQL);
            rs.next();
            int Qnty= Integer.valueOf(rs.getString("QNTY"));
            stmt.execute("update INVENTORY set QNTY='" + String.valueOf(Qnty + Integer.valueOf(cart1.getQty())) + "' where ID='" + cart1.getId() + "'");
        }
    }
    
    private Connection DB;
    private String uHost;
    private Statement stmt;
    private String SQL;
    private ResultSet rs;
    
}
