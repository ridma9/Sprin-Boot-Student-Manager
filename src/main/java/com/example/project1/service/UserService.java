package com.example.project1.service;

import com.example.project1.dto.UserDto;
import com.example.project1.entity.User;
import com.example.project1.repo.UserRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;

    public UserDto saveUser(UserDto userDto){
        userRepo.save(modelMapper.map(userDto, User.class));
        return userDto;
    }
    public List<UserDto> getAllUsers(){
        List<User> userList=userRepo.findAll();
        return modelMapper.map(userList,new TypeToken<List<UserDto>>(){}.getType());
    }

    public UserDto updateUser(UserDto userDto){
        userRepo.save(modelMapper.map(userDto,User.class));
        return userDto;
    }

    public boolean deleteUser(UserDto userDto){
        userRepo.delete(modelMapper.map(userDto,User.class));
        return true;
    }
}
