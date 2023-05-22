package com.example.homework17.UserService;

import com.example.homework17.Model.User;
import com.example.homework17.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UserService {
public final UserRepository userRepository;
    public List<User> getAllUser(){


        return userRepository.findAll();
    }



    public void addUser(User user){

        userRepository.save(user);
    }


    public boolean updateUser(Integer id,User user){

        User olduser =userRepository.getById(id);

        if(!userRepository.existsById(id)){

            return false;
        }
        olduser.setName(user.getName());
        olduser.setAge(user.getAge());
        olduser.setEmail(user.getEmail());
        olduser.setRole(user.getRole());
        olduser.setUsername(user.getUsername());
        olduser.setPassword(user.getPassword());

        userRepository.save(olduser);

        return true;


    }
    public boolean deleteUser(Integer id){


        if(!userRepository.existsById(id)){
            return false;
        }
        userRepository.deleteById(id);
        return true;
    }

}
