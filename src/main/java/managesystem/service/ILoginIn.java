package managesystem.service;

import managesystem.entities.User;
import managesystem.entities.logic.ResponseEntities;

public interface ILoginIn {

    ResponseEntities<User> loginIn(User user);

}
