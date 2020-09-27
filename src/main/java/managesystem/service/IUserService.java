package managesystem.service;

import managesystem.entities.User;
import managesystem.entities.logic.ResponseEntities;

import java.util.List;

public interface IUserService {

    ResponseEntities<List<User>> usersShow();

    ResponseEntities<List<User>> usersShowOnePage(Integer preNum);

    ResponseEntities<Integer> usersCount(Integer lowBound,Integer highBound);

    ResponseEntities<List<User>> adminsShowOnePage(Integer preNum);

    ResponseEntities<Boolean> insertUser(User user);

    ResponseEntities<Boolean> deleteUser(User user);

    ResponseEntities<List<User>> commonsShowOnePage(Integer preNum);

    ResponseEntities<List<User>> usersShowByFuzzyPattern(String pattern,Integer preNum);

    ResponseEntities<Integer> fuzzyQueryCount(String pattern);

    ResponseEntities<Boolean> updateUser(User user);
}
