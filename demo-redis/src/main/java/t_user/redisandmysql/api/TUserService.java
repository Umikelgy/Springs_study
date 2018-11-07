package t_user.redisandmysql.api;

import t_user.redisandmysql.mybatis.entity.*;

import java.util.List;

/*
 *@description:
 *
 *@author 10068921(LgyTT)
 *@date 2018/9/13 14:41
 */
public interface TUserService {
    List<TUser> findAll ();
    void insert(TUser user);
    TUser redisTUser(TUser t);
}
