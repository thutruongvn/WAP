package com.shopping.dao;

import java.util.HashMap;
import com.shopping.model.User;

public class UserAccess {
    static HashMap<String, User> users = new HashMap<>();
    static {
        users.clear();
        UserAccess.addUser(new User("test1","123456"));
        UserAccess.addUser(new User("test2","123456"));
        UserAccess.addUser(new User("test3","123456"));
    }
    public static boolean validateAccount(User user) {
        if(!users.containsKey(user.getUsername())) return false;
        User u = users.get(user.getUsername());
        return u.getPassword().equals(user.getPassword());
    }
    public static User getUserByUsername(String username) {
        if(!users.containsKey(username)) return null;
        return users.get(username);
    }
    public static void addUser(User user){
        users.put(user.getUsername(), user);
    }
}
