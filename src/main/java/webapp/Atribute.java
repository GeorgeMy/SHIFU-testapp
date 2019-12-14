package webapp;

import java.io.Serializable;


public class Atribute implements Serializable {
    
    private String name;
    private int El;
    private int Id;
    
    public Atribute(){}
    
    public Atribute(int _Id, String _name, int _El ){
    
        this.name = _name;
        this.El = _El;
        this.Id = _Id;
        
    }
    
    
    public String getName(){
        return name;
    }
    
    public int getEl(){
    
        return El;
    }
    
    public int getId(){
    
        return Id;
    }
}
