package org.example.data;

import org.example.model.User;

import java.util.List;

public class UserArrayListRepository implements UserRepository{
    private List<User> users;
    static int id;

    public UserArrayListRepository(List<User> users) {
        this.users = users;
        this.id = 1;
    }

    @Override
    public boolean validate(String username, String password) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUserName() == username && users.get(i).getPassword() == password){
                return true;
            }
        }
        return false;
    }

    @Override
    public User findByUsername(String username) {
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getUserName() == username){
                return users.get(i);
            }
        }
        return null;
    }

    public User save(User user){
        if(!users.contains(user)){
            users.add(user);
        }
        else {
            System.out.println("User already exist.");
            return null;
        }
        return null;
    }

    public User remove(User user){
        users.remove(user);
        return user;
    }

    public int generateID(){
        return id++;
    }

    public User findById(int id){
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getUserId() == id){
                return users.get(i);
            }
        }
        return null;
    }

    public List<User> findAll(){
        return users;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        UserArrayListRepository.id = id;
    }
}
