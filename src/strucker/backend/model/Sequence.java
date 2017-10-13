package strucker.backend.model;

import java.util.ArrayList;

public class Sequence extends Struck{

    private ArrayList<Struck> seq = new ArrayList<>();
    
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
    
    public void addAll(Sequence s){
        for(Struck stg : s.getChilds()){
            add(stg);
        }
    }
    
    public void addAll(Sequence s, int i){
        for(Struck stg : s.getChilds()){
            add(stg, i);
            i++;
        }
    }
    
    public void add(Struck stg, int i){
        stg.setMaster(this);
        seq.add(i, stg);
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
    public String toString() {
        StringBuilder str = new StringBuilder();
        for(Struck stg : seq){
            str.append(generateTabs(getLevel()-1)).append(stg.toString()).append('\n');
        }
        return str.toString();
    }
    
}
