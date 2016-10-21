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
public class InventoryItem {

    
    public InventoryItem(){
        id="";
        name="";
        category="";
        desc="";
        active="";
        qty="";
        price="";
        oldId=""; 
    }
    public InventoryItem(String id,
                        String name,
                        String category,
                        String desc,
                        String active,
                        String qty,
                        String price,
                        String oldCat){
        this.id=id;
        this.name=name;
        this.category=category;
        this.desc=desc;
        this.active=active;
        this.qty=qty;
        this.price=price;
        this.oldId=oldCat; 
    }
    public String getId (){
        return id;        
    }
    public String getName (){
        return name;
    }
    public String getCategory (){
        return category;
    }
    public String getOldID (){
        return oldId;
    }
    public String getActive (){
        return active;
    }
    public String getPrice (){
        return price;
    }
    public String getQty (){
        return qty;
    }
    public String getDesc (){
        return desc;
    }
    public void setName (String name){
        this.name=name;
    }
    public void setId (String id){
        this.id=id;
    }
    public void setPrice (String price){
        this.price=price;
    }
    public void setQty (String qty){
        this.qty=qty;
    }
    public void setDesc (String desc){
        this.desc=desc;
    }
    public void setCategory (String category){
        this.category=category;
    }
    public void setOldID (String oldID){
        this.oldId=oldID;
    }
    public void setActive (String active){
        this.active=active;
    }
    public boolean isEmpty(){
        return "".equals(id);
    }
    
    private String id;
    private String name;
    private String category;
    private String desc;
    private String active;
    private String qty;
    private String price;
    private String oldId;
}
