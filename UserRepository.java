package com.study.repository;

import com.study.model.User;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {

  public static List<User> userList = new ArrayList<>();

  static {

    userList.add(new User("gülçin", "Name1", "Surname1", "deneme", 1000, false));
    userList.add(new User("aslıhan", "Name2", "Surname2", "deneme2", 1000, true));
    userList.add(new User("user3", "Name3", "Surname3", "password3", 300, false));
    userList.add(new User("user4", "Name4", "Surname4", "password4", 400, false));
    userList.add(new User("user5", "Name5", "Surname5", "password5", 500, false));
    userList.add(new User("user6", "Name6", "Surname6", "password6", 600, false));
    userList.add(new User("user7", "Name7", "Surname7", "password7", 700, false));
    userList.add(new User("user8", "Name8", "Surname8", "password8", 800, false));
    userList.add(new User("user9", "Name9", "Surname9", "password9", 900, false));
    userList.add(new User("Esra", "Esra", "Bayrak", "esra123", 1000, false));
    userList.add(new User("admin", "Name10", "Surname10", "admin", 1000, true));

  }

 
  public static User getUserByUserName(String userName){
    for(User user: userList){
      if(user.getUserName().equals(userName)){
        return user;
      }
    }
    return null;
  }


}
