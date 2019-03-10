package com.example.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.model.Users;

import java.util.List;

@Repository
public class UsersRepository {

    @Autowired
    JdbcTemplate template;

    /*Retrieving all Users from table*/
    public List<Users> getAllUsers(){
        List<Users> users = template.query("select id, name,location from Users",(result,rowNum)->new Users(result.getInt("id"),
                result.getString("name"),result.getString("location")));
        return users;
    }
    /*Retrieving a specific user by user_id from table*/
    public Users getUser(int userId){
        String query = "SELECT * FROM Users WHERE ID=?";
        Users user = template.queryForObject(query,new Object[]{userId},new BeanPropertyRowMapper<>(Users.class));

        return user;
    }
    /*Retrieving an user into database table*/
    public int addUser(int id,String name,String location){
        String query = "INSERT INTO Users VALUES(?,?,?)";
        return template.update(query,id,name,location);
    }
    
    /*Updating one user details */
    public int updateUser(int id, String name, String location) {
    	String query = "UPDATE Users SET name = ?2, location = ?3 WHERE id = ?1";
    	return template.update(query,id,name,location);
    }
    /*delete one user from database using user_id*/
    public int deleteUser(int id){
        String query = "DELETE FROM Users WHERE ID =?";
        return template.update(query,id);
    }
}
