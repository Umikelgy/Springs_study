package mapper;

import po.User;

import java.util.List;

/*
 *@description:
 *
 *@author 10068921(LgyTT)
 *@date 2018/10/8 14:14
 */
public interface UserMapper {
 User findUserById(int n);
 List<User> queryAll();
}
