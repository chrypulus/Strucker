package strucker.backend.model;

import java.util.ArrayList;

public class Action extends Struck{
    private String action;
    
    public Action(Struck master, String action){
        super(master);
        this.action = action;
    }

    public Action(String action){
        super();
        this.action = action;
    }
    
    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public ArrayList<Struck> getChilds() {
        return null;
    }

    @Override
    public String toString() {
        return action;
    }
}
