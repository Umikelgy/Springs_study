package t_user.redisandmysql.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.cache.annotation.CacheConfig;

/*
 *@description:
 *
 *@author 10068921(LgyTT)
 *@date 2018/11/6 10:11
 */
@Mapper
@CacheConfig(cacheNames = "t_user")
public class TestUserMapper {
}
