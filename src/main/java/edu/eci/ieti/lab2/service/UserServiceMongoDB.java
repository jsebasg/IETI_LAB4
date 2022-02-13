/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.ieti.lab2.service;

import edu.eci.ieti.lab2.data.User;
import edu.eci.ieti.lab2.dto.UserDto;
import edu.eci.ieti.lab2.repository.UserRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jgarc
 */
@Service
public class UserServiceMongoDB implements UserService {

    private final UserRepository userRepository;

    public UserServiceMongoDB(@Autowired UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(User user) {
        System.out.print("entra"); 
        return userRepository.save(user); 
    }

    @Override
    public User findById(String id) {
        if(userRepository.existsById(id))return userRepository.findById(id).get();
        return null; 
    }

    @Override
    public void deleteById(String id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll(); 
    }

    @Override
    public User update(User user, String userId) {
        if(userRepository.existsById(userId)){
            User actualUser = userRepository.findById(userId).get(); 
            actualUser.setCreatedAt(user.getCreatedAt());
            actualUser.setEmail(user.getEmail());
            actualUser.setLastName(user.getLastName());
            actualUser.setName(user.getName());
            userRepository.save(actualUser); 
            return actualUser; 
        } 
        return null; 
    }

    @Override
    public List<User> findUsersWithNameOrLastNameLike(String queryText) {
        List<User> users = new ArrayList<>(); 
        users.addAll(userRepository.findBylastName(queryText)); 
        users.addAll(userRepository.findByName(queryText)); 
        return users;
    }

    @Override
    public List<User> findUsersCreatedAfter(Date startDate) {
        return userRepository.findBycreatedAtAfter(startDate) ; 
    }

}
