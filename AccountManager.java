import java.util.ArrayList;
import java.util.List;

public class AccountManager {
    private List<UserAccount> userAccounts;

    public AccountManager() {
        userAccounts = new ArrayList<>();
    }

    public void addUser(UserAccount user) {
        userAccounts.add(user);
    }

    public UserAccount getUserByUsername(String username) {
        for (UserAccount user : userAccounts) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null; // User not found
    }

    public boolean authenticateUser(String username, String password) {
        UserAccount user = getUserByUsername(username);
        return user != null && user.getPassword().equals(password);
    }

    public void createNewUser(String username, String password, String accountType) {
        // Check if the username is unique (not already in use)
        if (getUserByUsername(username) == null) {
            UserAccount newUser = new UserAccount(username, password, accountType);
            addUser(newUser);
            System.out.println("User created successfully.");
        } else {
            System.out.println("Username is already in use. Please choose a different username.");
        }
    }

    public boolean isValidAccountType(String accountType) {
        return accountType.equalsIgnoreCase("Manager")
                || accountType.equalsIgnoreCase("Client")
                || accountType.equalsIgnoreCase("Sales Clerk");
    }

    public String getUserRole(String username) {
        UserAccount user = getUserByUsername(username);
        if (user != null) {
            return user.getAccountType();
        }
        return "Unknown"; // User not found
    }
}



