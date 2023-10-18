import java.util.*;
import java.lang.*;
import java.io.*;
import java.io.Serializable.*;

public class Product implements Serializable {

    public String ProductName;
    public String Seller;
    public String id;
    public Member purchasedBy;

    public Product(String ProductName, String Seller, String id) {
        this.ProductName = ProductName;
        this.Seller = Seller;
        this.id = id;
    }

    public String getSeller(){return Seller;}
    public String getProductName(){return ProductName;}
    public String getId(){return id;}

    public String toString(){ return "Product Name: " + ProductName + " Id: " + id + " Seller " + Seller; }


}