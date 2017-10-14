package strucker.backend.model;

import java.util.ArrayList;
import lombok.*;

@ToString
public class Branch extends Struck{
    @Getter private ArrayList<Struck> ifBranch = new ArrayList<>();
    @Getter private ArrayList<Struck> elseBranch = new ArrayList<>();
    @Getter @Setter private String condition;
    
    public Branch(String condition){
        super();
        this.condition = condition;
    }
    
    @Override
    public ArrayList<Struck> getChilds() {
        ArrayList<Struck> childs = new ArrayList<>();
        for(Struck stg : ifBranch){
            childs.add(stg);
            childs.addAll(stg.getChilds());
        }
        for(Struck stg : elseBranch){
            childs.add(stg);
            childs.addAll(stg.getChilds());
        }
        return childs;
    }

    @Override
    public String toCode() {
        StringBuilder sb = new StringBuilder(generateTab(getLevel())+"if "+condition+" then\n");
        for(Struck stg : ifBranch){
            sb.append(stg.toCode());
        }
        if(elseBranch.isEmpty()){
            sb.append(generateTab(getLevel())+"endif\n");
        } else {
            sb.append(generateTab(getLevel())+"else\n");
            for(Struck stg : elseBranch){
                sb.append(stg.toCode());
            }
            sb.append(generateTab(getLevel())+"endif\n");
        }
        return sb.toString();
    }
    public void addIf(Struck stg){
        stg.setMaster(this);
        ifBranch.add(stg);
    }
    
    public void addIf(Struck stg, int i){
        stg.setMaster(this);
        ifBranch.add(i, stg);
    }
    
    public void removeIf(Struck stg){
        stg.setMaster(null);
        ifBranch.remove(stg);
    }
    
    public void removeIf(int i){
        Struck stg = ifBranch.get(i);
        stg.setMaster(null);
        ifBranch.remove(i);
    }
    public void addElse(Struck stg){
        stg.setMaster(this);
        elseBranch.add(stg);
    }
    
    public void addElse(Struck stg, int i){
        stg.setMaster(this);
        elseBranch.add(i, stg);
    }
    
    public void removeElse(Struck stg){
        stg.setMaster(null);
        elseBranch.remove(stg);
    }
    
    public void removeElse(int i){
        Struck stg = ifBranch.get(i);
        stg.setMaster(null);
        elseBranch.remove(i);
    }
}
