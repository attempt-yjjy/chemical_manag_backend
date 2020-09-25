package managesystem.dao;

import managesystem.entities.User;

public interface IUserDao {

    public User findByIdentityAndUsername(Integer identity_type,String username);
}
