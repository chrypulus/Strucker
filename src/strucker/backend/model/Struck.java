package strucker.backend.model;

import java.util.ArrayList;

public abstract class Struck {
    Struck master;
    
    protected static String generateTabs(int i){
        if(i < 0){
            throw new IllegalArgumentException("The parameter must be positive integer. Current parameter:"+i);
        }
        if(i == 1 || i == 0) return "";
        return "    " + generateTabs(i-1);
    }
    
    public Struck(Struck master){
        this.master = master;
    }
    
    public Struck(){
        this.master = null;
    }
    
    public void setMaster(Struck stg){
        this.master = stg;
    }
    
    public int getLevel(){
        if(master == null)return 1;
        return master.getLevel() + 1;
    }
    
    public abstract ArrayList<Struck> getChilds();
    
    @Override
    public abstract String toString();
}
