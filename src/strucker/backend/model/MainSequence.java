package strucker.backend.model;

import java.util.ArrayList;
import lombok.*;

@ToString
public class MainSequence extends Struck{
    @Getter
    private ArrayList<Struck> sequence;
    
    public MainSequence(){
        super();
        sequence = new ArrayList<>();
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
    public ArrayList<Struck> getChilds() {
        ArrayList<Struck> childs = new ArrayList<>();
        for(Struck stg : sequence){
            childs.add(stg);
            childs.addAll(stg.getChilds());
        }
        return childs;
    }

    @Override
    public String toCode() {
        StringBuilder sb = new StringBuilder();
        for(Struck stg : sequence){
            sb.append(stg.toCode());
        }
        return sb.toString();
    }
    
}
