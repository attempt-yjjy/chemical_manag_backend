package managesystem.dao.impl;

import managesystem.dao.IUserDao;
import managesystem.entities.User;
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
}
