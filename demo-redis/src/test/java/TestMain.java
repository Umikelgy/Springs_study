import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;
//import t_user.redisandmysql.redisConfig.RedisUtil;

/*
 *@description:
 *
 *@author 10068921(LgyTT)
 *@date 2018/9/13 10:42
 */
public class TestMain  {
    @Test
    public void TestCollectionRedis(){

        String host="127.0.0.1";
        Jedis jedis=new Jedis(host);
        jedis.auth("lgyTT");
        jedis.set("me","TT");
        System.out.println(jedis.get("mykey"));

    }
    @Test
    public void TestJedisPool(){
       Jedis jedis= RedisUtil.getJedis();
       System.out.println(jedis.get("test::test"));
    }
    @Test
    public void TestRedisExists(){
        RedisUtil util=new RedisUtil();
//        System.out.println(util.exists("me"));
    }
}
