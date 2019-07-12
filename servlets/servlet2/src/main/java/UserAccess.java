import java.util.HashMap;

public class UserAccess {
    static HashMap<String, User> users = new HashMap<>();
    public static boolean validateAccount(User user) {
        if(!users.containsKey(user.getUsername())) return false;
        User u = users.get(user.getUsername());
        return u.getPassword().equals(user.getPassword());
    }
    public static void addUser(User user){
        users.put(user.getUsername(), user);
    }
}
