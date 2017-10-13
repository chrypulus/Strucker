package strucker.backend.model;

import java.util.ArrayList;

public class Loop extends Struck{

    Sequence seq = new Sequence(this);
    String condition;
    
    public Loop(Struck master, String condition){
        super(master);
        this.condition = condition;
    }
    
    public Loop(String condition){
        super();
        this.condition = condition;
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
        seq.add(stg, i);
    }
    
    public void remove(Struck stg){
        seq.remove(stg);
    }
    
    public void remove(int i){
        seq.remove(i);
    }
    
    @Override
    public ArrayList<Struck> getChilds() {
        return seq.getChilds();
    }
    
    @Override
    public String toString() {
        StringBuilder sgb = new StringBuilder();
        sgb.append(generateTabs(getLevel()-1))
           .append("while")
           .append(" "+condition+" ")
           .append("do\n")
           .append(seq.toString())
           .append(generateTabs(getLevel()-1))
           .append("done\n");
        return sgb.toString();
    }
    
}
