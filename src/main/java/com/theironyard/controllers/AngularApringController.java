package com.theironyard.controllers;

import com.theironyard.entities.User;
import com.theironyard.services.UserRepository;
import org.h2.tools.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by PiratePowWow on 3/16/16.
 */
@RestController
public class AngularApringController {
    Server dbui = null;
    @PostConstruct
    public void init() throws SQLException {
        dbui = Server.createWebServer().start();
    }
    @PreDestroy
    public void destroy(){
        dbui.stop();
    }
    @Autowired
    UserRepository users;

    @RequestMapping(path = "/user", method = RequestMethod.GET)
    public List<User> getUsers(){
        return (List<User>) users.findAll();
    }
    @RequestMapping(path = "/user", method = RequestMethod.POST)
    public void addUser(@RequestBody User user){
        users.save(user);
    }
    @RequestMapping(path = "/user/{id}", method =RequestMethod.PUT )
    public void editUser(@RequestBody User user, @PathVariable("id") int id){
        users.save(user);
    }
    @RequestMapping(path = "/user/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable("id") int id){
        users.delete(id);
    }
    @RequestMapping(path = "/user/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable("id") int id){
        return users.findOne(id);
    }

}
