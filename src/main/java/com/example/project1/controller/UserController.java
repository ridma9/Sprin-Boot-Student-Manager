package com.example.project1.controller;

import com.example.project1.dto.UserDto;
import com.example.project1.entity.User;
import com.example.project1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/controller")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getUsers")
    public List<UserDto> getMethod(){
        return userService.getAllUsers();
    }

    @PostMapping("/postUser")
    public UserDto createMethod(@RequestBody UserDto userDto){
        return userService.saveUser(userDto);
    }

    @PutMapping("/putUser")
    public UserDto updateMethod(@RequestBody UserDto userDto){
        return userService.updateUser(userDto);
    }

    @DeleteMapping("/deleteUser")
    public boolean deleteMethod(@RequestBody UserDto userDto){
        return userService.deleteUser(userDto);
    }

    @GetMapping("/getUserByUserId/{userId}")
    public UserDto getUserByUserId(@PathVariable String userId){
        return userService.getUserByUserId(userId);
    }

    @GetMapping("/getUserByUserIdAndAddress/{userId}/{address}")
    public UserDto getUserByUserIdAndAddress(@PathVariable String userId, @PathVariable String address){
        return userService.getUserByUserIdAndAddress(userId,address);
    }
}
