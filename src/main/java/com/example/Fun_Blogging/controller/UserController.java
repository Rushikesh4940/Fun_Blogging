package com.example.Fun_Blogging.controller;

import com.example.Fun_Blogging.entityDTO.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.Fun_Blogging.service.UserService;

@RestController

@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;
//    UserController() {
//        System.out.println("abc");
//    }
    @PostMapping ("/create")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO){
         UserDTO createUserDTO= this.userService.createUser(userDTO);
         return new ResponseEntity<>(createUserDTO, HttpStatus.CREATED);
    }
    @GetMapping("/getUser/{id}")
    public ResponseEntity<UserDTO> getuser(@PathVariable Integer id){
        UserDTO getUser =this.userService.getUserByID(id);
        return ResponseEntity.ok(getUser);

    }
    @PutMapping("/{userId}")
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO ,@PathVariable Integer userId){
        UserDTO updatedUser =this.userService.updateUser(userDTO,userId);
        return ResponseEntity.ok(updatedUser);
    }




}
