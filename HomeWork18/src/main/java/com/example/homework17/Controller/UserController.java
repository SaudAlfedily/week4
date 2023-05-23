package com.example.homework17.Controller;

import com.example.homework17.ApiResbonse.ApiResponse;
import com.example.homework17.Model.User;
import com.example.homework17.UserService.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/get")
    public ResponseEntity getAllUser(){
        List<User> users=userService.getAllUser();
        return ResponseEntity.status(200).body(users);


    }

    @PostMapping("/add")
    public ResponseEntity addUser(@Valid @RequestBody User user, Errors errors){
        if (errors.hasErrors()){
            String massage=errors.getFieldError().getDefaultMessage();

            return ResponseEntity.status(400).body(new ApiResponse(massage));
        }
        userService.addUser(user);
        return ResponseEntity.status(200).body("User added");

    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable Integer id,@Valid @RequestBody User user, Errors errors){
        if (errors.hasErrors()){
            String massage=errors.getFieldError().getDefaultMessage();

            return ResponseEntity.status(400).body(new ApiResponse(massage));


        }
        boolean isUpdated= userService.updateUser(id, user);
        if (isUpdated){

            return ResponseEntity.status(200).body("user updated");
        }else return  ResponseEntity.status(400).body("user not found");


    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id ){

        boolean isDeleted =userService.deleteUser(id);

        if (isDeleted) {
            return ResponseEntity.status(200).body("User delete");
        }
        return ResponseEntity.status(400).body("User is not here");




    }
    @GetMapping("/get-user/{username}/{password}")
    public ResponseEntity findByUserNameAndId(@PathVariable String username,@PathVariable String password){
        boolean ishHere=userService.findByUsernameAndPassword(username,password);
        if (ishHere){
        return  ResponseEntity.status(200).body("user found in the systeam");}
return ResponseEntity.status(400).body("something went wrong");

    }

    @GetMapping("/get-email/{email}")
    public ResponseEntity getByEmail(@PathVariable String email){

        User user=userService.findUserByEmail(email);
        return ResponseEntity.status(200).body(user);
    }
    @GetMapping("/get-role/{role}")
    public ResponseEntity getUsersByRole(@PathVariable String role){
        List<User>users=userService.findUserByRole(role);
        return ResponseEntity.status(200).body(users);
    }
@GetMapping("/get-age/{age}")
    public ResponseEntity getByAgeAndAbove(@PathVariable Integer age){

        List<User> users=userService.findUsersAgeAndAbove(age);
        return ResponseEntity.status(200).body(users);
}


}
