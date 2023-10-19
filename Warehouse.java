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
    private Wishlist wishlist;
    private InvoiceList invoiceList;

    private static Warehouse warehouse;
    private Warehouse(){
        catalog = Catalog.instance();
        memberList = MemberList.instance();
        waitList = Waitlist.instance();
        wishlist = Wishlist.instance();
        invoiceList = InvoiceList.instance();
    }
    public static Warehouse instance() {
        if (warehouse == null) {
            MemberIdServer.instance();
            return (warehouse = new Warehouse());
        } else {
            return warehouse;
        }
    }

    public Product findProductByName(String productName) {
        Iterator productIterator = catalog.getProducts();

        while (productIterator.hasNext()) {
            Product product = (Product) productIterator.next();
            System.out.println(product.getProductName());
            if (product.getProductName().equalsIgnoreCase(productName)) {
                return product;
            }
        }
        return null; // Product not found
    }

    public boolean checkIfProductExists(String productName){
        Iterator productIterator = catalog.getProducts();

        while (productIterator.hasNext()){
            Product product = (Product) productIterator.next();
            System.out.println(product.getProductName());
            if (product.getProductName().equalsIgnoreCase(productName)) {
                return true;
            }
        }
        return false; // Product not found
    }

    public Member findMemberByName(String memberName) {
        Iterator memberIterator = memberList.getMembers();

        while (memberIterator.hasNext()) {

            Member member = (Member) memberIterator.next();
            System.out.println(member.getName());
            if (member.getName().equalsIgnoreCase(memberName)) {
                return member;
            }
        }
        return null; // Member not found
    }



    public Product addProduct(String ProductName, String id, int Quantity) {
        Product product = new Product(ProductName, id, Quantity);
        if (catalog.insertProduct(product)) {
            return (product);
        }
        return null;
    }

    /*public boolean removeProduct(Product product){
        return catalog.removeFromCatalog(product);
    }*/

    public boolean removeProduct(Product product) {
        Product existingProduct = findProductByName(product.getProductName());

        if (existingProduct != null && existingProduct.getId().equals(product.getId())) {
            return catalog.removeFromCatalog(existingProduct);
        }

        return false;
    }

    public Member addMember(String id, String name, String address, String phone) {
        Member member = new Member(id, name, address, phone);
        if (memberList.insertMember(member)) {
            return (member);
        }
        return null;
    }

    public boolean changeProductQuantity(String productName, int newQuantity) {
        return catalog.changeProductQuantity(productName, newQuantity);
    }

    public Item addItem(Product product, Member member, int quantity){
        Item item = new Item(product, member, quantity);
        if (waitList.addToWaitlist(item)){
            return (item);
        }
        return null;
    }

    public boolean removeItem(Item item){
        return waitList.removeFromWaitlist(item);

    }

    public boolean addToWishlist(Record record) {
        return wishlist.addToWishlist(record);
    }

    public boolean removeFromWishlist(Record record) {
        return wishlist.removeFromWishlist(record);
    }

    public Iterator getWishlist() {
        return wishlist.getWishlist();
    }


    public boolean addToInvoices(Invoice invoice) {
        return invoiceList.addToInvoices(invoice);
    }

    public boolean removeFromInvoices(Invoice invoice) {
        return invoiceList.removeFromInvoices(invoice);
    }

    public Iterator getInvoices() {
        return invoiceList.getInvoices();
    }

    public Iterator getProducts() { return catalog.getProducts();}

    public Iterator getMembers() {
        return memberList.getMembers();
    }
    public Iterator getWaitlist(){
        return waitList.getItems();
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
