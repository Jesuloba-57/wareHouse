import java.util.*;
import java.text.*;
import java.util.*;
import java.io.*;

public class UserInterface {
    private static UserInterface userInterface;
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Warehouse warehouse;
    private static final int EXIT = 0;
    private static final int ADD_MEMBER = 1;
    private static final int ADD_PRODUCTS = 2;
    private static final int PURCHASE_PRODUCTS = 3;
    private static final int RETURN_PRODUCT = 4;
    private static final int REMOVE_PRODUCT = 5;
    private static final int PLACE_ON_WAITLIST = 6;
    private static final int REMOVE_FROM_WAITLIST = 7;
    private static final int PROCESS_WAITLIST = 8;
    private static final int GET_TRANSACTIONS = 9;
    private static final int SHOW_MEMBERS = 10;
    private static final int SHOW_PRODUCTS = 11;
    private static final int SAVE = 12;
    private static final int RETRIEVE = 13;
    private static final int HELP = 14;

    private UserInterface() {
        if (yesOrNo("Look for saved data and  use it?")) {
            retrieve();
        } else {
            warehouse = Warehouse.instance();
        }
    }
    public static UserInterface instance() {
        if (userInterface == null) {
            return userInterface = new UserInterface();
        } else {
            return userInterface;
        }
    }
    public String getToken(String prompt) {
        do {
            try {
                System.out.println(prompt);
                String line = reader.readLine();
                StringTokenizer tokenizer = new StringTokenizer(line,"\n\r\f");
                if (tokenizer.hasMoreTokens()) {
                    return tokenizer.nextToken();
                }
            } catch (IOException ioe) {
                System.exit(0);
            }
        } while (true);
    }
    private boolean yesOrNo(String prompt) {
        String more = getToken(prompt + " (Y|y)[es] or anything else for no");
        if (more.charAt(0) != 'y' && more.charAt(0) != 'Y') {
            return false;
        }
        return true;
    }
    public int getNumber(String prompt) {
        do {
            try {
                String item = getToken(prompt);
                Integer num = Integer.valueOf(item);
                return num.intValue();
            } catch (NumberFormatException nfe) {
                System.out.println("Please input a number ");
            }
        } while (true);
    }
    public Calendar getDate(String prompt) {
        do {
            try {
                Calendar date = new GregorianCalendar();
                String item = getToken(prompt);
                DateFormat df = SimpleDateFormat.getDateInstance(DateFormat.SHORT);
                date.setTime(df.parse(item));
                return date;
            } catch (Exception fe) {
                System.out.println("Please input a date as mm/dd/yy");
            }
        } while (true);
    }
    public int getCommand() {
        do {
            try {
                int value = Integer.parseInt(getToken("Enter command:" + HELP + " for help"));
                if (value >= EXIT && value <= HELP) {
                    return value;
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Enter a number");
            }
        } while (true);
    }

    public void help() {
        System.out.println("Enter a number between 0 and 12 as explained below:");
        System.out.println(EXIT + " to Exit\n");
        System.out.println(ADD_MEMBER + " to add a member");
        System.out.println(ADD_PRODUCTS + " to  add products");
        System.out.println(PURCHASE_PRODUCTS + " to  issue products to a member");
        System.out.println(RETURN_PRODUCT + " to  return products ");
        System.out.println(REMOVE_PRODUCT + " to  remove products ");
        System.out.println(PLACE_ON_WAITLIST + " to place products on waitlist");
        System.out.println(REMOVE_FROM_WAITLIST + " to remove products from waitlist");
        System.out.println(PROCESS_WAITLIST + " to process waitlist");
        System.out.println(GET_TRANSACTIONS + " to  print transactions");
        System.out.println(SHOW_MEMBERS + " to  print members");
        System.out.println(SHOW_PRODUCTS + " to  print products");
        System.out.println(SAVE + " to  save data");
        System.out.println(RETRIEVE + " to  retrieve");
        System.out.println(HELP + " for help");
    }


    public void addMember() {
        String name = getToken("Enter member name");
        String address = getToken("Enter address");
        String phone = getToken("Enter phone");
        String id = getToken("Enter id");
        Member result;
        result = warehouse.addMember(name, address, phone, id);
        if (result == null) {
            System.out.println("Could not add member");
        }
        System.out.println(result);
    }

    public void addProducts() {
        Product result;
        do {
            String ProductName = getToken("Enter  ProductName");
            String Seller = getToken("Enter Seller");
            String id = getToken("Enter id");
            result = warehouse.addProduct(ProductName, Seller, id);
            if (result != null) {
                System.out.println(result);
            } else {
                System.out.println("Product could not be added");
            }
            if (!yesOrNo("Add more products?")) {
                break;
            }
        } while (true);
    }
    public void purchaseProducts() {
        System.out.println("Dummy Action");
    }


    public void showProducts() {
        Iterator allProducts = warehouse.getProducts();
        while (allProducts.hasNext()){
            Product product = (Product)(allProducts.next());
            System.out.println(product.toString());
        }
    }

    public void showMembers() {
        Iterator allMembers = warehouse.getMembers();
        while (allMembers.hasNext()){
            Member member = (Member)(allMembers.next());
            System.out.println(member.toString());
        }
    }

    public void returnProduct() {
        System.out.println("Dummy Action");
    }
    public void removeProduct() {
        System.out.println("Dummy Action");
    }
    public void placeOnWaitlist() {

    }

    public void removeFromWaitlist() {
        System.out.println("Dummy Action");
    }
    public void processWaitlistHold() {
        System.out.println("Dummy Action");
    }
    public void getTransactions() {
        System.out.println("Dummy Action");
    }
    private void save() {
        if (warehouse.save()) {
            System.out.println(" The Warehouse has been successfully saved in the file WarehouseData \n" );
        } else {
            System.out.println(" There has been an error in saving \n" );
        }
    }
    private void retrieve() {
        try {
            Warehouse tempWarehouse = Warehouse.retrieve();
            if (tempWarehouse != null) {
                System.out.println(" The Warehouse has been successfully retrieved from the file WarehouseData \n" );
                warehouse = tempWarehouse;
            } else {
                System.out.println("File doesnt exist; creating new Warehouse" );
                warehouse = Warehouse.instance();
            }
        } catch(Exception cnfe) {
            cnfe.printStackTrace();
        }
    }
    public void process() {
        int command;
        help();
        while ((command = getCommand()) != EXIT) {
            switch (command) {
                case ADD_MEMBER:        addMember();
                    break;
                case ADD_PRODUCTS:         addProducts();
                    break;
                case PURCHASE_PRODUCTS:       purchaseProducts(); //Dummy Action
                    break;
                case RETURN_PRODUCT:      returnProduct(); //Dummy Action
                    break;
                case REMOVE_PRODUCT:      removeProduct(); //Dummy Action
                    break;
                case PLACE_ON_WAITLIST:       placeOnWaitlist(); //Dummy Action
                    break;
                case REMOVE_FROM_WAITLIST:        removeFromWaitlist(); //Dummy Action
                    break;
                case PROCESS_WAITLIST:       processWaitlistHold(); //Dummy Action
                    break;
                case GET_TRANSACTIONS:  getTransactions(); // Dummy Action
                    break;
                case SAVE:              save();
                    break;
                case RETRIEVE:          retrieve();
                    break;
                case SHOW_MEMBERS:	showMembers();
                    break;
                case SHOW_PRODUCTS:	showProducts();
                    break;
                case HELP:              help();
                    break;
            }
        }
    }
    public static void main(String[] s) {
        UserInterface.instance().process();
    }
}
