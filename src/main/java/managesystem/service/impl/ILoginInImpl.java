package managesystem.service.impl;

import managesystem.dao.IUserDao;
import managesystem.entities.User;
import managesystem.entities.logic.ResponseEntities;
import managesystem.service.ILoginIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("iLoginIn")
public class ILoginInImpl implements ILoginIn {

    @Autowired
    private IUserDao iUserDao;

    @Override
    public ResponseEntities<User> loginIn(User user) {
        User u = iUserDao.findByIdentityAndUsername(user.getIdentity_type(),user.getUsername());
        if(u == null){
            return new ResponseEntities<User>(false,null,1);
        }
        else if(!(u.getPassword().equals(user.getPassword()))){
            return new ResponseEntities<User>(false,null,2);
        }
        else{
            return new ResponseEntities<User>(true,u,3);
        }
    }
}
