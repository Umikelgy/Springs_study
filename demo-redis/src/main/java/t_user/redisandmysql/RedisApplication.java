package t_user.redisandmysql;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
/*
 *@description:
 *
 *@author 10068921(LgyTT)
 *@date 2018/9/14 9:13
 */
//@RestController
@SpringBootApplication
@EnableScheduling
@EnableCaching
@MapperScan("t_user.redisandmysql.mybatis.dao")
public class RedisApplication {
    public static void main(String []args){
        SpringApplication.run(RedisApplication.class,args);
    }
}
