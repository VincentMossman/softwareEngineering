/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos;

/**
 *
 * @author Omer
 */
public class User {
    
    public User(){
        username="";password="";dept="";id="";active="";oldID="";
    }
    
    public User(String username,String password,String dept,String id,
            String active,String oldID){
        this.username=username;
        this.password=password;
        this.dept=dept;
        this.id=id;
        this.active=active;
        this.oldID=oldID;  
    }
    public String getUsername(){
        return username;        
    }
    public String getPassword(){
        return password;
    }
    public String getDept(){
        return dept;
    }
    public String getId(){
        return id;
    }
    public String getActive(){
        return active;
    }
    public String getOldID(){
        return oldID;
    }
    public void setUsername(String username){
        this.username=username;
    }
    public void setPassword(String password){
        this.password=password;
    }
    public void setDept(String dept){
        this.dept=dept;
    }
    public void setID(String id){
        this.id=id; 
    }
    public void setActive(String active){
        this.active=active;      
    }
    public void setOldID(String oldID){
        this.oldID=oldID;  
    }
    public User copyUser(User userToPaste){
        userToPaste.setActive(active);
        userToPaste.setDept(dept);
        userToPaste.setID(id);
        userToPaste.setPassword(password);
        userToPaste.setUsername(username);
        return userToPaste;
    }    
    
    private String username,password,dept,id,active,oldID;
}
