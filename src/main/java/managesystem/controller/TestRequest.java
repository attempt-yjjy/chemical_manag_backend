package managesystem.controller;

import managesystem.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class TestRequest {

    @ResponseBody
    @RequestMapping(value = "/test", produces = "application/json; charset=utf-8")
    public User responseTest(){
        User user = new User();
        user.setId(1);
        user.setUsername("1111");
        user.setPassword("2222");
        user.setName("哈哈哈");
        user.setIdentity_type(1);
        return user;
    }
}
