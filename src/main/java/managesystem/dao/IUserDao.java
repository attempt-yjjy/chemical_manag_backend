package managesystem.dao;

import managesystem.entities.User;

import java.util.List;

public interface IUserDao {

    User findByIdentityAndUsername(Integer identity_type,String username);

    List<User> findAllUsers();

    List<User> findUsersByPage(Integer preNum);

    List<User> findByIdentityInRangeAndPage(Integer lowBound,Integer heightBound,Integer preNum);

    Integer findCount(Integer lowBound, Integer heightBound);

    Boolean insertUser(User user);

    Boolean deleteUser(User user);

    Integer findByFuzzyCount(String pattern);

    List<User> findByFuzzy(String pattern,Integer preNum);

    Boolean updateUser(User user);
}
