import java.util.*;
import java.io.*;
public class Wishlist implements Serializable {
    private List wishes = new LinkedList();
    private static Wishlist wishlist;

    public static Wishlist instance() {
        if (wishlist == null) {
            return (wishlist = new Wishlist());
        } else {
            return wishlist;
        }
    }

    public boolean addToWishlist(Record item) {
        wishes.add(item);
        return true;
    }

    /*public boolean removeFromWaitlist(Item item){
        items.remove(item);
        return true;
    }*/

    public boolean removeFromWishlist(Record wish) {
        System.out.println("Items before removal: " + wishes);
        System.out.println("Item that is trying to be removed: " + wish);
        boolean removed = wishes.remove(wish);
        System.out.println("Item removed: " + removed);
        return removed;
    }


    public Iterator getWishlist() {
        return wishes.iterator();
    }


    /*public boolean isProductOnWaitlist(Item i) {
        return items.contains(i);
    }

    public void clearWaitlist() {
        items.clear();
    }

     */

}
