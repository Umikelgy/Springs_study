package serviceApi;

import po.User;

import java.util.List;

/*
 *@description:
 *
 *@author 10068921(LgyTT)
 *@date 2018/10/8 14:09
 */
public interface UserService {
    List<User> queryAllUser();
    User queryById(int id);
}
