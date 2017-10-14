package strucker.backend.model;

import java.util.ArrayList;
import lombok.*;

@ToString
public class Loop extends Struck{
    @Getter @Setter private String condition;
    @Getter private ArrayList<Struck> sequence = new ArrayList<>();
    
    public Loop(String condition){
        super();
        this.condition = condition;
    }
    
    public void add(Struck stg){
        stg.setMaster(this);
        sequence.add(stg);
    }
    
    public void add(Struck stg, int i){
        stg.setMaster(this);
        sequence.add(i, stg);
    }
    
    public void remove(Struck stg){
        stg.setMaster(null);
        sequence.remove(stg);
    }
    
    public void remove(int i){
        Struck stg = sequence.get(i);
        stg.setMaster(null);
        sequence.remove(i);
    }
    
    @Override
    public String toCode() {
        StringBuilder sgb = new StringBuilder();
        sgb.append(generateTab(getLevel()))
           .append("while "+condition+" do\n");
        for(Struck stg : sequence){
            sgb.append(stg.toCode());
        }
        sgb.append(generateTab(getLevel())).append("done\n");
        return sgb.toString();
    }

    @Override
    public ArrayList<Struck> getChilds() {
        ArrayList<Struck> childs = new ArrayList<>();
        for(Struck stg : sequence){
            childs.add(stg);
            childs.addAll(stg.getChilds());
        }
        return childs;
    }
}
