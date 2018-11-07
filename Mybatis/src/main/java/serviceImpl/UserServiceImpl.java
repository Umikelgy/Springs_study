package serviceImpl;

import mapper.UserMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import po.User;
import serviceApi.UserService;

import java.util.List;

/*
 *@description:
 *
 *@author 10068921(LgyTT)
 *@date 2018/10/8 14:11
 */
//@MapperScan(basePackages = "mapper")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> queryAllUser() {
        return userMapper.queryAll();
    }

    @Override
    public User queryById(int id) {
        return userMapper.findUserById(id);
    }
}
