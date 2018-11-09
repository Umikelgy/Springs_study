package t_user.redisandmysql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import t_user.redisandmysql.api.TUserService;
import t_user.redisandmysql.impl.RedisUtil;
import t_user.redisandmysql.impl.TUserServiceImpl;
import t_user.redisandmysql.mybatis.entity.TUser;

import java.util.List;

/*
 *@description:
 *
 *@author 10068921(LgyTT)
 *@date 2018/9/14 9:27
 */
@RestController
public class TUserController {
    @Autowired
    private TUserService service;
    @Autowired
    private RedisTemplate redisTemplate;//为什么在RestController里不为空，在自定义类的@Service中为空？？
    @RequestMapping(value = "/insert")
    public void Insert(){
        TUser user=new TUser();
        user.setPassword("123411");
        user.setPhone("1232111");
        user.setUsername("lgyC11");
        user.setUserId(24);
        service.insert(user);
        System.out.println("添加成功");
    }
    @RequestMapping("/find")
    public List<TUser> findAllTusers(){
//        if(new RedisUtil().exists("me"))
        return service.findAll();
    }
    @RequestMapping(value = "redisTest")
    public void Redis(){
        Object result = null;
       RedisUtil redis=new RedisUtil();//因为设置@Service 不能获取到redisTemplate ，所以使用Util工具类
        redis.setRedisTemplate(redisTemplate);
        result =redis.get("find::find");
        System.out.println(result);

//        else
        System.out.println("The Redis is null!!");

    }
    @RequestMapping(value = "redisT")
    public TUser RedisT(){
        TUserServiceImpl services=new TUserServiceImpl();
        TUser t= (TUser) services.TestService();

       /* TUser t=new TUser();
        t.setUserId(1221);
        t.setUsername("LGYTT");
        t.setPhone("2344");
        t.setPassword("2313");
        service.redisTUser(t);*/
        return t;
    }
}
