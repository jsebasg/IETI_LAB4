package edu.eci.ieti.lab2.service;

import edu.eci.ieti.lab2.data.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


public class UserServiceHashMap implements UserService{
    HashMap<String , User> users = new HashMap<>();
    @Override
    public User create(User user) {
        users.put(user.getId() , user);
        return user;
    }

    @Override
    public User findById(String id) {
        return users.containsKey(id)? users.get(id) : null ;
    }

    @Override
    public List<User> getAll() {
        List<User> list = new ArrayList<User>(users.values());
        return list;
    }

    @Override
    public void deleteById(String id) throws Exception {
        if (users.containsKey(id))  users.remove(id) ;
        else throw new Exception("the Id User doesn't exist");
    }

    @Override
    public User update(User user, String userId) {
        if(users.containsKey(userId)) users.put(userId,user);
        return user;
    }

    @Override
    public List<User> findUsersWithNameOrLastNameLike(String queryText) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> findUsersCreatedAfter(Date startDate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
