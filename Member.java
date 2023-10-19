import java.util.*;
import java.io.*;

public class Member implements Serializable{

    private String id;
    private String name;
    private String address;
    private String phone;
    private Wishlist wishlist;


    public Member (String id, String name, String address, String phone){
        this.id =id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.wishlist = new Wishlist();

    }

    public String getName() {
        return name;
    }
    public String getPhone() {
        return phone;
    }
    public String getAddress() {
        return address;
    }
    public String getId() {
        return id;
    }

    public Wishlist getWishlist() {
        return wishlist;
    }

    public void setName(String newName) {
        name = newName;
    }
    public void setAddress(String newAddress) {
        address = newAddress;
    }
    public void setPhone(String newPhone) {
        phone = newPhone;
    }
    public boolean equals(String id) {
        return this.id.equals(id);
    }


    public String toString(){
        String string = " id " + id;
        return string;
    }


}