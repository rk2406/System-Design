package models;

import java.util.HashMap;
import java.util.Map;

public class UserSystem {
     private static Map<String, User> users = new HashMap<>();

     public static void addUser(String userId, User user){
          if(users.containsKey(userId)) System.out.println("user already exists");
          else users.put(userId,user);
     }

     public static User getUser(String userid){
          return users.get(userid);
     }
}
