package strucker;

import strucker.backend.model.*;

public class Strucker {

    public static void main(String[] args) {
        MainSequence ms = new MainSequence();
        Action a1 = new Action("int j = 0;");
        Action a2 = new Action("List l = get();");
        Loop l1 = new Loop("j <= l.length()");
        Action a3 = new Action("j++;");
        Branch b1 = new Branch("i <= l[i]");
        Action a4 = new Action("i++;");
        Action a5 = new Action("i--;");
        Action a6 = new Action("j=0;");
        
        ms.add(a1);
        ms.add(a2);
        ms.add(l1);
        ms.add(a6);
        l1.add(b1);
        b1.addIf(a4);
        b1.addElse(a5);
        l1.add(a3);
        
//        System.out.println(ms.toString() + " - " + ms.getLevel());
//        for(Struck stg : ms.getChilds()){
//            System.out.println(stg.toString() + " - " + stg.getLevel());
//        }
        System.out.print(ms.toCode());
    }
    
}
