package strucker.backend.model;

import java.util.ArrayList;
import lombok.*;

@ToString
public class Loop extends Sequence{
    @Getter @Setter
    String condition;
    
    public Loop(Struck master, String condition){
        super(master);
        this.condition = condition;
    }
    
    public Loop(String condition){
        super();
        this.condition = condition;
    }
    
    @Override
    public String toCode() {
        StringBuilder sgb = new StringBuilder();
        sgb.append(generateTab(getLevel()-1))
           .append("while "+condition+" do\n");
        for(Struck stg : seq){
            if(stg instanceof Action){
                sgb.append(generateTab(getLevel())).append(stg.toCode()).append('\n');
            } else {
                sgb.append(stg.toCode());
            }
        }
        sgb.append(generateTab(getLevel()-1)).append("done\n");
        return sgb.toString();
    }
    
}
