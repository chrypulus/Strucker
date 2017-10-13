package strucker.backend.model;

import java.util.ArrayList;
import lombok.NonNull;
import lombok.ToString;

@ToString
public class Sequence extends Struck{
    protected ArrayList<Struck> seq = new ArrayList<>();
    
    public Sequence(Struck master) {
        super(master);
    }
    
    public Sequence(){
        super();
    }
    
    public void add(Struck stg){
        stg.setMaster(this);
        seq.add(stg);
    }
    
    public void add(Struck stg, int i){
        stg.setMaster(this);
        seq.add(i, stg);
    }
    
    public void addAll(Sequence s){
        for(Struck stg : s.getChilds()){
            stg.setMaster(this);
            seq.add(stg);
        }
    }
    
    public void addAll(Sequence s, int i){
        for(Struck stg : s.getChilds()){
            stg.setMaster(this);
            seq.add(i, stg);
            i++;
        }
    }
    
    public void remove(Struck stg){
        seq.remove(stg);
    }
    
    public void remove(int i){
        seq.remove(i);
    }
    
    @Override
    public ArrayList<Struck> getChilds() {
        return seq;
    }

    @Override
    public String toCode() {
        StringBuilder str = new StringBuilder();
        for(Struck stg : seq){
            if(stg instanceof Action){
                str.append(generateTab(getLevel())).append(stg.toCode()).append('\n');
            } else {
                str.append(stg.toCode());
            }
        }
        return str.toString();
    }
    
}
