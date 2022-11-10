package com.example.project1.controller;

import com.example.project1.dto.UserDto;
import com.example.project1.entity.User;
import com.example.project1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@CrossOrigin
public class UserController {

   @Autowired
    private UserService userService;
/*
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
    }*/

    @GetMapping("/home")
    public String homepage(){
        return "home";
    }
    @GetMapping("/viewStudents")
    public String viewpage(Model model){
        List<UserDto> userList = userService.getAllUsers();
        model.addAttribute("users", userList);
        return "viewStudents";
    }
    @GetMapping("/addStudent")
    public String addpage(){
        return "addStudent";
    }

    @PostMapping("/register")
    public String registerStudent(@ModelAttribute UserDto userDto, HttpSession session){
        userService.saveUser(userDto);
        session.setAttribute("msg","Student added Successfully...");
        return "redirect:/addStudent";
    }

    @GetMapping("/editStudent/{id}")
    public String editPage(Model model, @PathVariable int id){
        UserDto userDto= userService.getUserByUserId(String.valueOf(id));
        model.addAttribute("user", userDto);
        return "editStudent";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute UserDto userDto, HttpSession session){
        userService.updateUser(userDto);
        session.setAttribute("msg","Student edited Successfully...");
        return "redirect:/viewStudents";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, HttpSession session){
        UserDto userDto = userService.getUserByUserId(String.valueOf(id));
        userService.deleteUser(userDto);
        return "redirect:/viewStudents";
    }

    @PostMapping("/search")
    public String search(@ModelAttribute("firstName") String name, Model model,HttpSession session){

        UserDto user = userService.getUserByName(name);

        if (user.getFirstName()==null){
            System.out.println("method 1");
            session.setAttribute("msg","Student Not Found..");
            return "searchResults";
        }

        model.addAttribute("users", user);
        return "searchResults";
    }


}
