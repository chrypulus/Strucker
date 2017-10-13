package strucker.backend.model;

import java.util.ArrayList;
import lombok.*;

public abstract class Struck {
    @Getter @Setter
    Struck master;
    
    protected static String generateTab(int i){
        if(i < 0){
            throw new IllegalArgumentException("The parameter must be positive integer. Current parameter:"+i);
        }
        if(i == 1 || i == 0) return "";
        return "    " + generateTab(i-1);
    }
    
    public Struck(Struck master){
        this.master = master;
    }
    
    public Struck(){
        this.master = null;
    }
    
    public int getLevel(){
        if(master == null)return 1;
        return master.getLevel() + 1;
    }
    
    public abstract ArrayList<Struck> getChilds();
    
    public abstract String toCode();
}
