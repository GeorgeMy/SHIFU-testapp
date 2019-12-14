package webapp;

import java.io.Serializable;

public class Object implements Serializable {
    
    private int Id;
    private String name;
    
    
    public Object(){}
    
    public Object(int _id,String _name){
        
        this.Id= _id;
        this.name = _name;
    }
    
    public int getId(){
    
        return Id;
    }
    
    public String getName(){
        return name;
    }
   
}
