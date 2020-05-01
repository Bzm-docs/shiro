package ink.bzm.service;

import ink.bzm.mapper.UserMapper;
import ink.bzm.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: lijincan
 * @date: 2020年02月26日 16:22
 * @Description: TODO
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;



    @Override
    public User queryUserByName(String name) {
        return userMapper.queryUserByName(name);
    }
}
