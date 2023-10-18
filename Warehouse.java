import java.util.*;
import java.io.*;

public class Warehouse implements Serializable{
    private static final long serialVersionUID = 1L;
    public static final int PRODUCT_NOT_FOUND = 1;
    public static final int PRODUCT_NOT_PURCHASED = 2;
    public static final int PRODUCT_ON_WAITLIST = 3;
    public static final int PRODUCT_PURCHASED = 4;
    public static final int PRODUCT_PLACED_ON_WAITLIST = 5;
    public static final int PRODUCT_NOT_ON_WAITLIST = 6;
    public static final int OPERATION_COMPLETED = 7;
    public static final int OPERATION_FAILED = 8;
    public static final int NO_SUCH_MEMBER = 9;
    private Catalog catalog;
    private MemberList memberList;
    private Waitlist waitList;
    private static Warehouse warehouse;
    private Warehouse(){
        catalog = Catalog.instance();
        memberList = MemberList.instance();
        waitList = Waitlist.instance();
    }
    public static Warehouse instance() {
        if (warehouse == null) {
            MemberIdServer.instance();
            return (warehouse = new Warehouse());
        } else {
            return warehouse;
        }
    }
        public Product addProduct(String ProductName, String Seller, String id) {
            Product product = new Product(ProductName, Seller, id);
            if (catalog.insertProduct(product)) {
                return (product);
            }
            return null;
        }

        public Member addMember(String id, String name, String address, String phone) {
            Member member = new Member(id, name, address, phone);
            if (memberList.insertMember(member)) {
                return (member);
            }
            return null;
        }

        public Item addWaitItem(Member m, Product p, int q){
            Item item = new Item(p, m, q);
            if (waitList.addToWaitlist(item)){
                return (item);
            }
            return null;
        }

        public Iterator getProducts() {
        return catalog.getProducts();
    }
        public Iterator getMembers() {
        return memberList.getMembers();
    }
        public Iterator getWaitItems(){
        return waitList.getWaitlistedProducts();
        }

    public static Warehouse retrieve() {
        try {
            FileInputStream file = new FileInputStream("WarehouseData");
            ObjectInputStream input = new ObjectInputStream(file);
            input.readObject();
            MemberIdServer.retrieve(input);
            return warehouse;
        } catch(IOException ioe) {
            ioe.printStackTrace();
            return null;
        } catch(ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
            return null;
        }
    }
    public static  boolean save() {
        try {
            FileOutputStream file = new FileOutputStream("WarehouseData");
            ObjectOutputStream output = new ObjectOutputStream(file);
            output.writeObject(warehouse);
            output.writeObject(MemberIdServer.instance());
            return true;
        } catch(IOException ioe) {
            ioe.printStackTrace();
            return false;
        }
    }
    private void writeObject(java.io.ObjectOutputStream output) {
        try {
            output.defaultWriteObject();
            output.writeObject(warehouse);
        } catch(IOException ioe) {
            System.out.println(ioe);
        }
    }
    private void readObject(java.io.ObjectInputStream input) {
        try {
            input.defaultReadObject();
            if (warehouse == null) {
                warehouse = (Warehouse) input.readObject();
            } else {
                input.readObject();
            }
        } catch(IOException ioe) {
            ioe.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public String toString() {
        return catalog + "\n" + memberList;
    }
    }












