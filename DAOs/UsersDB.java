/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;
import pos.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Omer
 */
public class UsersDB {
    
    /**
     *
     */
    public UsersDB() {
        
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
    public String NumOfUsers(){
        String NumOfUsers="";
        try {
            rs=stmt.executeQuery("select COUNT(*) from LOGINTABLE1");
            rs.next();
            NumOfUsers =rs.getString(1);
        } catch (SQLException ex) {
            Logger.getLogger(UsersDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return NumOfUsers;
    }
    public String newUserID(String dep){
        int id;
        String newID="";
        boolean empty=true;
        int counter=0;
        try {
            SQL="select * from LOGINTABLE1 where ACCESS='"+dep+"'";
            rs=stmt.executeQuery(SQL);
            while(rs.next()){
                empty=false;
                counter++;
            }
            if(empty==true){
                switch(dep){
                    case "Sales": dep="S-"; break;
                    case "Inventory": dep="I-"; break;
                    case "Management": dep="M-"; break;
                }
                newID=dep+"100001";
            }
            else{
                id=counter+100000+1;
                newID=dep.substring(0, 1)+"-"+String.valueOf(id);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsersDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return newID;
    }
    public ArrayList<User> usersResult() {
        ArrayList<User> result=new ArrayList<>();
        try {

            rs=stmt.executeQuery("select * from LOGINTABLE1");
            while(rs.next()){
                if("TRUE".equals(rs.getString("Active"))){
                    User currentRow=new User();
                    currentRow.setUsername(rs.getString("USERNAME"));
                    currentRow.setDept(rs.getString("ACCESS"));
                    currentRow.setID(rs.getString("ID"));
                    currentRow.setOldID(rs.getString("OLDID"));
                    currentRow.setActive(rs.getString("Active"));
                    currentRow.setPassword(rs.getString("PASSWORD"));
                    result.add(currentRow);
                }         
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsersDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    public ArrayList<User> usersResult(String userN, String dep, String ID) {
        ArrayList<User> result=new ArrayList<>();
        if(!userN.isEmpty()){
            SQL="select * from LOGINTABLE1 where USERNAME='"+userN+"'";
            if(!dep.isEmpty())SQL+=("and ACCESS='"+dep+"'");
            if(!ID.isEmpty())SQL+=("and ID='"+ID+"'");
            }else if(!dep.isEmpty()){
                SQL="select * from LOGINTABLE1 where ACCESS='"+dep+"'";
                if(!ID.isEmpty())SQL+=("and ID='"+ID+"'");
        }else if(!ID.isEmpty())SQL="select * from LOGINTABLE1 where ID='"+ID+"'";
           
        try {
            rs=stmt.executeQuery(SQL);
            while(rs.next()){
                if("TRUE".equals(rs.getString("Active"))){
                    User currentRow=new User();
                    currentRow.setUsername(rs.getString("USERNAME"));
                    currentRow.setDept(rs.getString("ACCESS"));
                    currentRow.setID(rs.getString("ID"));
                    currentRow.setOldID(rs.getString("OLDID"));
                    currentRow.setActive(rs.getString("Active"));
                    currentRow.setPassword(rs.getString("PASSWORD"));
                    result.add(currentRow);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsersDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result;
    }
    public User eFindUser(String id) throws SQLException{
        User result=new User();
      
        rs=stmt.executeQuery("select * from LOGINTABLE1 where ID='"+id+"'");
        rs.next();
        result.setUsername(rs.getString("USERNAME"));
        result.setDept(rs.getString("ACCESS"));
        result.setID(rs.getString("ID"));
        result.setActive(rs.getString("Active"));
        result.setOldID(rs.getString("OLDID"));
        result.setPassword(rs.getString("PASSWORD"));
            
        return result;
    }
    public void activateUser(String id) throws SQLException{
        stmt.execute("update LOGINTABLE1 set Active='TRUE' where ID='"+id+"'");
    }
    public void delRec(String id) throws SQLException{

        stmt.execute("update LOGINTABLE1 set Active='FALSE' where ID='"+id+"'");
    }
    public void updateRec(String userN,String dept,String oldID) throws SQLException {
        String newID=newUserID(dept);
        User oldUser=usersResult("","",oldID).get(0);
        
        if(oldUser.getDept().equals(dept)){
            stmt.execute("update LOGINTABLE1 set USERNAME='"+userN+"' where ID='"+oldID+"'");
        }else{
            if(oldUser.getOldID() == null)oldUser.setOldID("No previous.");
            stmt.execute("update LOGINTABLE1 set USERNAME='"+userN+"',ACCESS='"+dept+
                    "',ID='"+newID+"', OLDID='"+oldID+"' where ID='"+oldID+"'");
            stmt.execute("insert into LOGINTABLE1 (USERNAME,PASSWORD,ACCESS,ID,Active,OLDID) values('"
                +userN+" -"+Calendar.getInstance().getTime()+"','"+"Disabled"+"','"+oldUser.getDept()+
                    "','"+oldID+"','FALSE','"+oldUser.getOldID()+"')"); 
        }
    }
    public void addNewUser(String userN,String dept, String id,String pass) throws SQLException{
        stmt.execute("insert into LOGINTABLE1 (USERNAME,PASSWORD,ACCESS,ID) values('"
                +userN+"','"+pass+"','"+dept+"','"+id+"')"); 
    }
    
    private Connection DB;
    private String uHost;
    private Statement stmt;
    private String SQL;
    private ResultSet rs;
}
