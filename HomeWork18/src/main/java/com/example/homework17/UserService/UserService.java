package com.example.homework17.UserService;

import com.example.homework17.ApiException.ApiException;
import com.example.homework17.Model.User;
import com.example.homework17.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

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

    public boolean findByUsernameAndPassword(String username,String password ){
        User user=userRepository.findUsersByUsernameAndPassword(username,password);
        if(user==null){
            throw new ApiException("no user with this data");
        }
return true;

    }
    public User findUserByEmail(String email){
        User user=userRepository.getUserByEmail(email);
        if (user==null){
            throw new ApiException("user not here");
        }
        return user;
    }

    public List<User> findUserByRole(String role){
        List<User> users=userRepository.findUsersByRole(role);
        if(users==null){
            throw new ApiException("no user with this role");

        }
        return users;

    }
    public List<User> findUsersAgeAndAbove(Integer age){
        List<User>users=userRepository.getUserAgeAndAbove(age);
        if(users==null) {
            throw new ApiException("no use this age or above in the systeam");
        }
        return users;

    }


}
