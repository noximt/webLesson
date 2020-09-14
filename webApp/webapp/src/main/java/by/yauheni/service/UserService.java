package by.yauheni.service;

import by.yauheni.domain.User;
import by.yauheni.storage.UserStorageDB;
import java.util.List;

public class UserService {
    private UserStorageDB userStorageDB = new UserStorageDB();

    public boolean saveToDB(User user) {
        if (userStorageDB.save(user)){
            return true;
        }
        return false;
    }

    public String updateNameInDB(String newName, long id){
        if (userStorageDB.contains(id)){
            return  userStorageDB.updateName(newName, id);
        }
        throw new UserNotFoundException();
    }

    public String updatePasswordInDB(String pass, long id){
        if (userStorageDB.contains(id)) {
            return userStorageDB.updatePassword(pass, id);
        }
        throw new UserNotFoundException();
    }

    public User removeFromDBByID(long id){
        if (userStorageDB.contains(id)){
            User user = userStorageDB.getUserById(id);
            userStorageDB.remove(id);
            return user;
        }
        throw new UserNotFoundException();
    }

    public User removeFromDBByLogin(String login){
        if (userStorageDB.contains(login)){
            User user = userStorageDB.getUserByLogin(login);
            userStorageDB.remove(login);
            return user;
        }
        throw new UserNotFoundException();
    }

    public List<User> getAllFromDB(){
        if (userStorageDB.getAll().get(1) != null) {
            return userStorageDB.getAll();
        }
        throw new UserNotFoundException();
    }

    public List<User> getAllByNameFromDB(String name) {
        if (userStorageDB.getAll().get(1) != null) {
            return userStorageDB.getAllByName(name);
        }
        throw new UserNotFoundException();
    }

    public User getUserByIdFromDB(long id) {
        if (userStorageDB.contains(id)){
            userStorageDB.getUserById(id);
        }
        throw new UserNotFoundException();
    }

    public User getUserByLoginFromDB(String login) {
        if (userStorageDB.contains(login)){
           return userStorageDB.getUserByLogin(login);
        }
        throw new UserNotFoundException();
    }
}
