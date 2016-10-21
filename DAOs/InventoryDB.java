/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import pos.InventoryItem;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Omer
 */
public class InventoryDB {
        
    public InventoryDB(){
        
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
    public ArrayList<String> getCategories(){
        ArrayList<String> categories= new ArrayList<>();
        String cat;
        try {
            rs=stmt.executeQuery("select * from INVENTORY");
            while(rs.next()){
                cat=rs.getString("CAT");
                if(!categories.contains(cat))categories.add(cat);
            }
        } catch (SQLException ex) {
            Logger.getLogger(InventoryDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return categories;
    }
    
    public String numOfItems(){
        String numOfItems="";
        try {
            rs=stmt.executeQuery("select COUNT(*) from INVENTORY");
            rs.next();
            numOfItems =rs.getString(1);
        } catch (SQLException ex) {
            Logger.getLogger(UsersDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return numOfItems;
    }

    public ArrayList<InventoryItem> itemsResult(String name, String cat, String id) {
        ArrayList<InventoryItem> result=new ArrayList<>();
        if(!name.isEmpty()){
            SQL="select * from INVENTORY where NAME='"+name+"'";
            if(!cat.isEmpty())SQL+=("and CAT='"+cat+"'");
            if(!id.isEmpty())SQL+=("and ID='"+id+"'");
            }else if(!cat.isEmpty()){
                SQL="select * from INVENTORY where CAT='"+cat+"'";
                if(!id.isEmpty())SQL+=("and ID='"+id+"'");
        }else if(!id.isEmpty())SQL="select * from INVENTORY where ID='"+id+"'";
           
        try {
            rs=stmt.executeQuery(SQL);
            while(rs.next()){
                if("TRUE".equals(rs.getString("Active"))){
                    InventoryItem currentRow=new InventoryItem();
                    currentRow.setName(rs.getString("NAME"));
                    currentRow.setActive(rs.getString("ACTIVE"));
                    currentRow.setCategory(rs.getString("CAT"));
                    currentRow.setDesc(rs.getString("DESC"));
                    currentRow.setId(rs.getString("ID"));
                    currentRow.setOldID(rs.getString("OLDID"));
                    currentRow.setPrice(rs.getString("PRICE"));
                    currentRow.setQty(rs.getString("QNTY"));
                    result.add(currentRow);
                }         
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsersDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result;
    }

    public ArrayList<InventoryItem> itemsResult() {
        ArrayList<InventoryItem> result=new ArrayList<>();
        try {
            rs=stmt.executeQuery("select * from INVENTORY");
            while(rs.next()){
                if("TRUE".equals(rs.getString("Active"))){
                    InventoryItem currentRow=new InventoryItem();
                    currentRow.setName(rs.getString("NAME"));
                    currentRow.setActive(rs.getString("ACTIVE"));
                    currentRow.setCategory(rs.getString("CAT"));
                    currentRow.setDesc(rs.getString("DESC"));
                    currentRow.setId(rs.getString("ID"));
                    currentRow.setOldID(rs.getString("OLDID"));
                    currentRow.setPrice(rs.getString("PRICE"));
                    currentRow.setQty(rs.getString("QNTY"));
                    result.add(currentRow);
                }         
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsersDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
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

    public InventoryItem updateRec(InventoryItem item, String oldID) throws SQLException {
        
        InventoryItem oldItem=itemsResult("","",oldID).get(0);
        
        if(oldItem.getCategory().equals(item.getCategory())){
            
            stmt.execute("update INVENTORY set NAME='"+item.getName()+
                    "',DESC='"+item.getDesc()+"',PRICE='"+item.getPrice()+
                    "', QNTY='"+item.getQty()+"' where ID='"+oldID+"'");
        }else{
            item.setId(newItemID(item.getCategory()));
            if(oldItem.getOldID() == null)oldItem.setOldID("No previous.");
            stmt.execute("update INVENTORY set NAME='"+item.getName()+
                    "',CAT='"+item.getCategory()+"',ID='"+item.getId()+
                    "',PRICE='"+item.getPrice()+"',QNTY='"+item.getQty()+
                    "',DESC='"+item.getDesc()+"', OLDID='"+oldID+
                    "' where ID='"+oldID+"'");
            
            
            stmt.execute("insert into INVENTORY (ID,NAME,PRICE,QNTY,CAT,DESC,"
                    + "ACTIVE,OLDID) values('"
                    +oldItem.getId()+"','"+oldItem.getName()+" -"+Calendar.getInstance().getTime()+"','"+
                    oldItem.getPrice()+"','"+oldItem.getQty()+"','"+oldItem.getCategory()+
                    "','"+oldItem.getDesc()+"','FALSE','"+oldItem.getOldID()+"')"); 
        }
        return item;
    }

    public String newItemID(String category) {
        int id;
        String newID="";
        boolean empty=true;
        int counter=0;
        try {
            SQL="select * from INVENTORY where CAT='"+category+"'";
            rs=stmt.executeQuery(SQL);
            while(rs.next()){
                empty=false;
                counter++;
            }
            if(empty==true){
                newID=category.substring(0, 3)+"-1000001";
            }
            else{
                
                id=counter+1000000+1;
                newID=category.substring(0,3)+"-"+String.valueOf(id);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsersDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return newID;
    }

    public void delRec(String id) throws SQLException {
        stmt.execute("update INVENTORY set Active='FALSE' where ID='"+id+"'");
    }

    public void activateItem(String id) throws SQLException {
        stmt.execute("update INVENTORY set Active='TRUE' where ID='"+id+"'");
    }

    public void addNewItem(InventoryItem item) throws SQLException {
        stmt.execute("insert into INVENTORY (ID,NAME,PRICE,QNTY,CAT,DESC,ACTIVE,OLDID)"
                + " values('"+item.getId()+"','"+item.getName()+"','"+item.getPrice()
                + "','"+item.getQty()+"','"+item.getCategory()+"','"+item.getDesc()
                + "','TRUE','')"); 
    }
    
    //Declarations
    private Connection DB;
    private String uHost;
    private Statement stmt;
    private String SQL;
    private ResultSet rs;
    //End
}
