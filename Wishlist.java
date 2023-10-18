import java.util.*;
import java.io.*;
public class Wishlist implements Serializable {

    private List<Item> items = new ArrayList<>();
    private static Wishlist wishlist;

//    public Wishlist() {
//        items = new ArrayList<>();
//    }

    public static Wishlist instance() {
        if (wishlist == null) {
            return (wishlist = new Wishlist());
        } else {
            return wishlist;
        }
    }

    public boolean addToWishlist(Item item) {
        items.add(item);
        return true;
    }

    public void removeFromWishlist(Item i) {
        items.remove(i);
    }

    public Iterator getWishlistedProducts(Member m) {
        List<Item> wishlistedProducts = new ArrayList<>();
        for (Item item : items) {
            if (item.getMember().equals(m)) {
                wishlistedProducts.add(item);
            }
        }
        return wishlistedProducts.iterator();
    }

    public void clearWishlist(){
        items.clear();
    }
//    private static final long serialVersionUID = 1L;
//    private List wait = new LinkedList();
//    private static Wishlist Wishlist;
//
//    private Wishlist(){
//    }
//
//    public static Wishlist instance(){
//      if(Wishlist == null) {
//          return (Wishlist = new Wishlist);
//      } else {
//          return Wishlist;
//      }
//    }
//
//    public boolean insertEntry(Member member, Product product){
//        wait.add(member, product);
//
//    }
}