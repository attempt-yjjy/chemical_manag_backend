package managesystem.service.impl;

import managesystem.dao.IUserDao;
import managesystem.entities.User;
import managesystem.entities.logic.ResponseEntities;
import managesystem.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("iUserService")
public class IUserServiceImpl implements IUserService {

    @Autowired
    private IUserDao iUserDao;

    @Override
    public ResponseEntities<List<User>> usersShow() {
        List<User> users = iUserDao.findAllUsers();
        return new ResponseEntities<List<User>>(true,users,1);
    }

    @Override
    public ResponseEntities<List<User>> usersShowOnePage(Integer preNum) {
        List<User> users = iUserDao.findUsersByPage(preNum);
        return new ResponseEntities<List<User>>(true,users,1);
    }

    @Override
    public ResponseEntities<Integer> usersCount(Integer lowBound,Integer highBound) {
        return new ResponseEntities<Integer>(true,iUserDao.findCount(lowBound,highBound),1);
    }

    @Override
    public ResponseEntities<List<User>> adminsShowOnePage(Integer preNum) {
        List<User> users = iUserDao.findByIdentityInRangeAndPage(1,2,preNum);
        return new ResponseEntities<List<User>>(true,users,1);
    }


    @Override
    public ResponseEntities<Boolean> insertUser(User user) {
        Boolean result = iUserDao.insertUser(user);
        return new ResponseEntities<Boolean>(result,result,1);
    }

    @Override
    public ResponseEntities<Boolean> deleteUser(User user) {
        Boolean result = iUserDao.deleteUser(user);
        return new ResponseEntities<Boolean>(result,result,1);
    }

    @Override
    public ResponseEntities<List<User>> commonsShowOnePage(Integer preNum) {
        List<User> users = iUserDao.findByIdentityInRangeAndPage(3,3,preNum);
        return new ResponseEntities<List<User>>(true,users,1);
    }

    @Override
    public ResponseEntities<List<User>> usersShowByFuzzyPattern(String pattern,Integer preNum) {
        List<User> users = iUserDao.findByFuzzy(pattern,preNum);
        return new ResponseEntities<List<User>>(true,users,1);
    }

    @Override
    public ResponseEntities<Integer> fuzzyQueryCount(String pattern) {
        return new ResponseEntities<Integer>(true,iUserDao.findByFuzzyCount(pattern),1);
    }

    @Override
    public ResponseEntities<Boolean> updateUser(User user) {
        Boolean result = iUserDao.updateUser(user);
        return new ResponseEntities<Boolean>(result,result,1);
    }


}
