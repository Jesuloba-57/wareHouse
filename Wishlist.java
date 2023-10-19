import java.util.*;
import java.io.*;
public class Wishlist implements Serializable {

    //private List<Item> items;
    private List items = new LinkedList();

    private static Wishlist wishlist;

//    public Waitlist() {
//        items = new ArrayList<>();
//    }

    public static Wishlist instance() {
        if (wishlist == null) {
            return (wishlist = new Wishlist());
        } else {
            return wishlist;
        }
    }

    public boolean addToWishlist(Record item) {
        items.add(item);
        return true;
    }

    /*public boolean removeFromWaitlist(Item item){
        items.remove(item);
        return true;
    }*/

    public boolean removeFromWishlist(Record item) {
        System.out.println("Items before removal: " + items);
        System.out.println("Item that is trying to be removed: " + item);
        boolean removed = items.remove(item);
        System.out.println("Item removed: " + removed);
        return removed;
    }


    public Iterator getWishlist() {
        return items.iterator();
    }


    /*public boolean isProductOnWaitlist(Item i) {
        return items.contains(i);
    }

    public void clearWaitlist() {
        items.clear();
    }

     */

}
