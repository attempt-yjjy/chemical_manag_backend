package managesystem.controller;

import managesystem.entities.User;
import managesystem.entities.logic.ResponseEntities;
import managesystem.service.ILoginIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginIn {

    @Autowired
    private ILoginIn iLoginIn;

    @ResponseBody
    @RequestMapping(value="/login-in")
    public ResponseEntities<User> loginIn(User user){
        ResponseEntities<User> result = iLoginIn.loginIn(user);
        return result;
    }

    @ModelAttribute
    public User translate(String username, String password,Integer identity_type){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setIdentity_type(identity_type);
        return user;
    }
}
