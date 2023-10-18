import java.util.*;
import java.lang.*;
import java.io.*;

public class Catalog implements Serializable {
    private static final long serialVersionUID = 1L;
    private List products = new LinkedList();
    private static Catalog catalog;
    private Catalog(){
    }
    public static Catalog instance(){
        if(catalog == null){
            return (catalog = new Catalog());
        } else {
            return catalog;
        }
    }

    public boolean insertProduct(Product product){
        products.add(product);
        return true;
    }
    public Iterator getProducts(){ return products.iterator();}
    private void writeObject(java.io.ObjectOutputStream output){
        try {
            output.defaultWriteObject();
            output.writeObject(catalog);
        } catch(IOException ioe){
            System.out.println(ioe);
        }
    }
    private void readObject(java.io.ObjectInputStream input) {
        try {
            if (catalog != null) {
                return;
            } else {
                input.defaultReadObject();
                if (catalog == null) {
                    catalog = (Catalog) input.readObject();
                } else {
                    input.readObject();
                }
            }
        } catch(IOException ioe) {
            System.out.println("in Catalog readObject \n" + ioe);
        } catch(ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        }
    }
    public String toString() {
        return products.toString();
    }
}

