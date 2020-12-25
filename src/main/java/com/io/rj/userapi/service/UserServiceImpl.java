package com.io.rj.userapi.service;

import com.io.rj.userapi.UserRepository;
import com.io.rj.userapi.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUser{

    @Autowired
    UserRepository userRepo;

    @Override
    public User createUser(User user) {

        User newUser = new User();
        newUser = userRepo.save(user);
        return newUser;
    }

    @Override
    public List<User> listUsers() {
        List<User> userDetails =  userRepo.findAll();
        return userDetails;
    }

    @Override
    public User updateUser(User user, Long id) {
        if(userRepo.findById(id).isPresent()){
            User existingUser = userRepo.findById(id).get();
            existingUser.setName(user.getName());
            existingUser.setPassword(user.getPassword());
            existingUser.setEmail(user.getEmail());
            existingUser.setGender(user.getGender());
            userRepo.save(existingUser);
            user = existingUser;
        };
        return user;
    }

    @Override
    public void deleteUser(Long id) {
         userRepo.deleteById(id);
    }

    @Override
    public String login(String name, String password) {

        return null;
    }

//    public User findUser(Long id) {
//        User foundUser = userRepo.findById(id);
//        return foundUser;
//    }
}
