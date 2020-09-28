package managesystem.controller;

import managesystem.entities.User;
import managesystem.entities.logic.ResponseEntities;
import managesystem.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserManagement {

    @Autowired
    private IUserService iUserService;

    @ResponseBody
    @RequestMapping("/users_get")
    public ResponseEntities<List<User>> usersShow(){
        return iUserService.usersShow();
    }

    @ResponseBody
    @RequestMapping("/users_get_onepage")
    public ResponseEntities<List<User>> usersShowOnePage(Integer preNum){
        return iUserService.usersShowOnePage(preNum);
    }

    @ResponseBody
    @RequestMapping("/users_get_count")
    public ResponseEntities<Integer> usersCount(){
        return iUserService.usersCount(null,null);
    }

    @ResponseBody
    @RequestMapping("/user_insert")
    public ResponseEntities<Boolean> usersInsert(User user){
        return iUserService.insertUser(user);
    }

    @ResponseBody
    @RequestMapping("/user_delete")
    public ResponseEntities<Boolean> usersDelete(User user){
        return iUserService.deleteUser(user);
    }

    @ResponseBody
    @RequestMapping("/admin_get_onepage")
    public ResponseEntities<List<User>> adminShowOnepage(Integer preNum){
        return iUserService.adminsShowOnePage(preNum);
    }

    @ResponseBody
    @RequestMapping("/admin_get_count")
    public ResponseEntities<Integer> adminsCount(){
        return iUserService.usersCount(1,2);
    }

    @ResponseBody
    @RequestMapping("/common_get_onepage")
    public ResponseEntities<List<User>> commonsShowOnepage(Integer preNum){
        return iUserService.commonsShowOnePage(preNum);
    }

    @ResponseBody
    @RequestMapping("/common_get_count")
    public ResponseEntities<Integer> commonsCount(Integer lowBound,Integer highBound){
        return iUserService.usersCount(3,3);
    }


    @ResponseBody
    @RequestMapping("/users_fuzzy_count")
    public ResponseEntities<Integer> fuzzyQueryCount(String pattern){
        return iUserService.fuzzyQueryCount(pattern);
    }

    @ResponseBody
    @RequestMapping("/users_fuzzy")
    public ResponseEntities<List<User>> fuzzyQuery(String pattern,Integer preNum){
        return iUserService.usersShowByFuzzyPattern(pattern,preNum);
    }

    @ResponseBody
    @RequestMapping("/users_update")
    public ResponseEntities<Boolean> usersUpdate(User user){
        return iUserService.updateUser(user);
    }

}
