package com.loginpage.db.loginpage.Controller;

import com.loginpage.db.loginpage.MOdel.User;
import org.springframework.data.repository.CrudRepository;

public interface Userrepository extends CrudRepository<User,Integer> {
    public User findByUsername(String username);

}
