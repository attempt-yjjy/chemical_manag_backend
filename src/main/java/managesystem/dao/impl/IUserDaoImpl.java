package managesystem.dao.impl;

import managesystem.dao.IUserDao;
import managesystem.entities.User;
import managesystem.entities.logic.SpecialQueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("iUserDao")
public class IUserDaoImpl implements IUserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public User findByIdentityAndUsername(Integer identity_type,String username) {
        List<User> users = jdbcTemplate.query("select * from user where identity_type=? and username=?",new BeanPropertyRowMapper<User>(User.class),identity_type,username);
        if(users == null || users.size() == 0){
            return null;
        }
        else if(users.size() > 1){
            throw new RuntimeException("系统数据出现重叠!");
        }
        return users.get(0);
    }

    @Override
    public List<User> findAllUsers() {
        List<User> users = jdbcTemplate.query("select * from user",new BeanPropertyRowMapper<User>(User.class));
        return users;
    }

    @Override
    public List<User> findUsersByPage(Integer preNum) {
        List<User> users = jdbcTemplate.query("select * from user limit ?,10",new BeanPropertyRowMapper<User>(User.class),preNum);
        return users;
    }

    @Override
    public List<User> findByIdentityInRangeAndPage(Integer lowBound, Integer heightBound, Integer preNum) {
        List<User> users = jdbcTemplate.query("select * from user where identity_type >= ? and identity_type <= ? limit ?,10",new BeanPropertyRowMapper<User>(User.class),lowBound,heightBound,preNum);
        return users;
    }

    @Override
    public Integer findCount(Integer lowBound, Integer heightBound) {
        List<SpecialQueryResult> result;
        if(lowBound == null && heightBound == null) {
            result = jdbcTemplate.query("select count(*) as count from user", new BeanPropertyRowMapper<SpecialQueryResult>(SpecialQueryResult.class));
        }
        else{
            result = jdbcTemplate.query("select count(*) as count from user where identity_type >= ? and identity_type <= ?", new BeanPropertyRowMapper<SpecialQueryResult>(SpecialQueryResult.class),lowBound,heightBound);
        }
        if (result == null || result.size() == 0 || result.size() > 1) {
            throw new RuntimeException("查询条数异常!");
        }
        return result.get(0).getCount();
    }

    @Override
    public Boolean insertUser(User user) {
        Integer effectRowCount = jdbcTemplate.update("insert into user(username,password,name,identity_type) values(?,?,?,?)",user.getUsername(),user.getPassword(),user.getName(),user.getIdentity_type());
        if(effectRowCount == 1){
            return true;
        }
        return false;
    }

    @Override
    public Boolean deleteUser(User user) {
        Integer effectRowCount = jdbcTemplate.update("delete from user where username=?",user.getUsername());
        if(effectRowCount == 1){
            return true;
        }
        return false;
    }

    @Override
    public Integer findByFuzzyCount(String pattern) {
        List<SpecialQueryResult> result = jdbcTemplate.query("select count(*) as count from user where username like ? or name like ?",new BeanPropertyRowMapper<SpecialQueryResult>(SpecialQueryResult.class),"%" + pattern + "%","%" + pattern + "%");
        if (result == null || result.size() == 0 || result.size() > 1) {
            throw new RuntimeException("查询条数异常!");
        }
        return result.get(0).getCount();
    }


    @Override
    public List<User> findByFuzzy(String pattern,Integer preNum) {
        List<User> users = jdbcTemplate.query("select * from user where username like ? or name like ? limit ?,10",new BeanPropertyRowMapper<User>(User.class),"%" + pattern + "%","%" + pattern + "%",preNum);
        return users;
    }

    @Override
    public Boolean updateUser(User user) {
        Integer result = jdbcTemplate.update("update user set name=?,password=?,identity_type=? where username=?",user.getName(),user.getPassword(),user.getIdentity_type(),user.getUsername());
        if(result == 0){
            return false;
        }
        else if(result == 1){
            return true;
        }
        else{
            throw new RuntimeException("修改条数异常!");
        }
    }

}
