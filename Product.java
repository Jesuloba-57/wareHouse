import java.util.*;
import java.lang.*;
import java.io.*;
import java.io.Serializable.*;

public class Product implements Serializable {

    public String ProductName;
    public String id;
    public int Quantity;


    public Product(String ProductName, String id, int Quantity) {
        this.ProductName = ProductName;
        this.Quantity = Quantity;
        this.id = id;
    }

    public int getQuantity() {
        return Quantity;
    }

    public String getProductName() {
        return ProductName;
    }

    public String getId() {
        return id;
    }

    public void setQuantity(int newQuantity){
        Quantity = newQuantity;
    }
    public void setProductName(String newProductName){
        ProductName = newProductName;
    }
    public void setId(String newId){
        id = newId;
    }

    public String toString() {
        return "Product Name: " + ProductName + " Id: " + id + " Quantity " + Quantity;
    }

}


