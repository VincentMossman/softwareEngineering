/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import pos.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Omer
 */
public class CurrentUserDB {

    /**
     *
     */
    public CurrentUserDB() {
        
        path=this.getClass().getClassLoader().getResource("").getPath()+"/DataBases/MainDB.accdb";
        uHost="jdbc:ucanaccess:/"+path;
        try {
            DB=DriverManager.getConnection(uHost);
            stmt= DB.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                    ResultSet.CONCUR_READ_ONLY);
        } catch (SQLException ex) {
            Logger.getLogger(UsersDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public User getUser() throws SQLException{
        User user=new User(rs.getString("USERNAME"),rs.getString("PASSWORD"),
                            rs.getString("ACCESS"),rs.getString("ID"),
                            rs.getString("Active"),rs.getString("OLDID"));
        rs.close();
        stmt.close();
        DB.close();
        return user;
    }
    /**
     *
     * @param username
     * @param password
     * @return
     */
    public boolean login(String username, String password) {
        SQL="select * from LOGINTABLE1 where USERNAME='"+username+"'";
        try {
            rs=stmt.executeQuery(SQL);
            if(rs.next()){
                return password.equalsIgnoreCase(rs.getString("PASSWORD"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsersDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public void changePW(User user,String PW){
        try {
            DB=DriverManager.getConnection(uHost);
            stmt= DB.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                    ResultSet.CONCUR_READ_ONLY);
            stmt.execute("update LOGINTABLE1 set PASSWORD='"+PW+"' where ID='"+user.getId()+"'");
            stmt.close();
            DB.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsersDB.class.getName()).log(Level.SEVERE, null, ex);
        }
              
    }
    
    //Declarations
    private Connection DB;
    private String uHost;
    private Statement stmt;
    private String SQL;
    private ResultSet rs;
    private String path;
    //End of declarations
}
