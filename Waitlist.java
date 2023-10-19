import java.util.*;
import java.io.*;
public class Waitlist implements Serializable {

    //private List<Item> items;
    private List items = new LinkedList();

    private static Waitlist waitList;

//    public Waitlist() {
//        items = new ArrayList<>();
//    }

    public static Waitlist instance(){
        if (waitList == null){
            return (waitList = new Waitlist());
        } else{
            return waitList;
        }
    }

    public boolean addToWaitlist(Item item) {
        items.add(item);
        return true;
    }

    /*public boolean removeFromWaitlist(Item item){
        items.remove(item);
        return true;
    }*/

    public boolean removeFromWaitlist(Item item) {
        System.out.println("Items before removal: " + items);
        System.out.println("Item that is trying to be removed: " +  item);
        boolean removed = items.remove(item);
        System.out.println("Item removed: " + removed);
        return removed;
    }



    public Iterator getItems(){
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
