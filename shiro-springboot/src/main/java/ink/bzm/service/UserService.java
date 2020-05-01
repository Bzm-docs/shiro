package ink.bzm.service;


import ink.bzm.pojo.User;

public interface UserService {

    public User queryUserByName(String name);
}
