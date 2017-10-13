package strucker.backend.model;

import java.util.ArrayList;
import lombok.*;

@ToString
public class Action extends Struck{
    @Getter @Setter
    private String action;
    
    public Action(Struck master, String action){
        super(master);
        this.action = action;
    }

    public Action(String action){
        super();
        this.action = action;
    }

    @Override
    public ArrayList<Struck> getChilds() {
        return null;
    }

    @Override
    public String toCode() {
        return action;
    }
}
