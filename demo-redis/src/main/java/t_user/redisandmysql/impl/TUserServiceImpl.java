package t_user.redisandmysql.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import t_user.redisandmysql.api.TUserService;
import t_user.redisandmysql.mybatis.dao.TUserMapper;
import t_user.redisandmysql.mybatis.entity.TUser;

import javax.annotation.Resource;
import java.util.List;

/*
 *@description:
 *
 *@author 10068921(LgyTT)
 *@date 2018/9/14 8:52
 */
@Service
public class TUserServiceImpl implements TUserService {
    @Resource(name = "redisTemplate")
    private RedisTemplate redisTemplate;
    @Autowired
    private TUserMapper mapper;
    @Override
    @Cacheable(key = "caches[0].name",value = "find")
    public List<TUser> findAll() {
        return mapper.findAllTUser();
    }

    @Cacheable(key = "caches[0].name",value = "test")
    @Override
    public void insert(TUser user) {
        mapper.insert(user);
    }
    @Cacheable(key = "caches[0].name",value = "ts")
    @Override
    public TUser redisTUser(TUser t) {
        return t;
    }
    public Object TestService(){
        RedisUtil util=new RedisUtil();
        util.setRedisTemplate(redisTemplate);
      return   util.get("find::find");

    }
}
