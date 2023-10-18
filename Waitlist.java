import java.util.*;
import java.io.*;
public class Waitlist implements Serializable {

    private List<Item> items;
    private static Waitlist waitlist;

//    public Waitlist() {
//        items = new ArrayList<>();
//    }

    public static Waitlist instance(){
        if (waitlist == null){
            return (waitlist = new Waitlist());
        } else{
            return waitlist;
        }
    }

    public boolean addToWaitlist(Item Item) {
        items.add(Item);
        return true;
    }

    public void removeFromWaitlist(Item i) {
        items.remove(i);
    }

    public Iterator getWaitlistedProducts() {
        return items.iterator();
    }

    public boolean isProductOnWaitlist(Item i) {
        return items.contains(i);
    }

    public void clearWaitlist() {
        items.clear();
    }
//    private static final long serialVersionUID = 1L;
//    private List wait = new LinkedList();
//    private static Waitlist waitlist;
//
//    private Waitlist(){
//    }
//
//    public static Waitlist instance(){
//      if(waitlist == null) {
//          return (waitlist = new Waitlist);
//      } else {
//          return waitlist;
//      }
//    }
//
//    public boolean insertEntry(Member member, Product product){
//        wait.add(member, product);
//
//    }


}
