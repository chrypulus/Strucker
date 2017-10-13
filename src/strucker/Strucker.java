package strucker;

import strucker.backend.model.Action;
import strucker.backend.model.Loop;
import strucker.backend.model.Sequence;

public class Strucker {

    public static void main(String[] args) {
        Sequence s1 = new Sequence(null);
        s1.add(new Action("i := 0"));
        s1.add(new Action("i := 2"));
        s1.add(new Action("i := 5"));
        s1.add(new Action("i := 29"));
        Loop l1 = new Loop("i <= 3");
        l1.add(new Action("i++"));
        Loop l2 = new Loop("i <= 3");
        l2.add(new Action("i++"));
        l1.add(l2);
        s1.add(l1);
        System.out.print(s1.toString());
    }
    
}
