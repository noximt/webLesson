package by.yauheni.service;

import by.yauheni.domain.User;

import java.util.ArrayList;
import java.util.List;

public class UserService  {
    private static List<User> users = new ArrayList<>();

    public boolean save(User user){
        return users.add(user);
    }

    public User getByLogin(String login){
        for (int i = 0; i <users.size() ; i++) {
            if (users.get(i).getLogin().equals(login)){
                return users.get(i);
            }
        }
        throw new UserNotFoundException();
    }

    public User getByName(String name){
        for (int i = 0; i <users.size() ; i++) {
            if (users.get(i).getName().equals(name)){
                return users.get(i);
            }
        }
        throw new UserNotFoundException();
    }

    public User getByID(Long id){
        for (int i = 0; i <users.size() ; i++) {
            if (users.get(i).getId() == id){
                return users.get(i);
            }
        }
        throw new UserNotFoundException();
    }

    public String updateName(String name, long id){
        for (int i = 0; i <users.size() ; i++) {
            if (users.get(i).getId() == id){
                String oldName = users.get(i).getName();
                users.get(i).setName(name);
                return oldName;
            }
        }
        throw new UserNotFoundException();
    }

    public String updatePassword(String pass, long id){
        for (int i = 0; i <users.size() ; i++) {
            if (users.get(i).getId() == id){
                String oldPass = users.get(i).getPassword();
                users.get(i).setPassword(pass);
                return oldPass;
            }
        }
        throw new UserNotFoundException();
    }

    public List<User> getAll(){
        return users;
    }

    public void removeByID(long id){
        for (int i = 0; i <users.size() ; i++) {
            if (users.get(i).getId() == id){
                users.remove(i);
            }
        }
    }

    public void removeBylogin(String login){
        for (int i = 0; i <users.size() ; i++) {
            if (users.get(i).getLogin().equals(login)) {
                users.remove(i);
            }
        }
    }

}

