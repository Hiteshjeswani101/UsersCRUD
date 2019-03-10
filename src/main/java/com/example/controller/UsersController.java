package com.example.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Users;
import com.example.repository.UsersRepository;

@RestController
@RequestMapping("/CRUD")
public class UsersController {
    @Autowired
    UsersRepository userRepo;

    @RequestMapping(method=RequestMethod.GET,value = "/getAllUsers")
    @ResponseBody
    public List<Users> getAllUsers(){
        return userRepo.getAllUsers();
    }

    @RequestMapping(method=RequestMethod.GET)
    @ResponseBody
    public Users getuser(@RequestParam("id") int id){
        return userRepo.getUser(id);
    }

    @RequestMapping(method=RequestMethod.POST)
    @ResponseBody
	public String adduser(@Valid @RequestBody Users user){
        if(userRepo.addUser(user.getId(),user.getName(),user.getLocation()) >= 1){
            return "User Added Successfully";
        }else{
            return "Something went wrong !";
        }
    }
    
    @RequestMapping(method=RequestMethod.PUT)
    @ResponseBody
    public String updateUser(@Valid @RequestBody Users user) {
    	System.out.println(userRepo.updateUser(user.getId(),user.getName(),user.getLocation()));
    	if(userRepo.updateUser(user.getId(),user.getName(),user.getLocation())>=0) {
    		return "User Updated Successfully";
    	}else {
    		return "Something went wrong !";
    	}
    }
    
    @RequestMapping(method=RequestMethod.DELETE)
    @ResponseBody
    public String deteteuser(@RequestParam("id") int id){
        if(userRepo.deleteUser(id) >= 1){
            return "User Deleted Successfully";
        }else{
            return "Something went wrong !";
        }
    }
}