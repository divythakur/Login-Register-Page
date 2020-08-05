package com.loginpage.db.loginpage.Controller;

import com.loginpage.db.loginpage.MOdel.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
@Controller
public class UserController {


    @Autowired
    Userrepository userrepository;
    @RequestMapping("users/login")
    public String login() {
        return "users/login";
    }
    @RequestMapping(value="users/login",method = RequestMethod.POST)

    public String loginUser(User user) {
        String name=user.getUsername();
        String pass=user.getPassword();
        User u=userrepository.findByUsername(name);
        if(u.getPassword().equals(pass)){
            return "users/Afterlogin.html";
        }
        else{
            return "users/login";
        }
    }

    @RequestMapping("users/registration")
    public String registeruser()
    {
        return "users/registration";

    }
    @RequestMapping(value="users/registration" , method=RequestMethod.POST)
    public String RUSer(User user){
        userrepository.save(user);
        return "/users/login";

    }

    @RequestMapping(value = "users/logout", method=RequestMethod.POST)
    public String logout() {
        return "index";
    }








}
