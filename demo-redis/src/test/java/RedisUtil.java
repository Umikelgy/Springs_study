import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/*
 *@description:
 *redis连接池测试
 *@author 10068921(LgyTT)
 *@date 2018/9/13 11:14
 */
public class RedisUtil {
    private static String ADDR="127.0.0.1";
    private static String auth="lgyTT";
    private static int port=6379;
    private static int MAX_ACTIVE=1024;
    private static int MAX_IDLE=200;
    private static int MAX_WAIT=10000;
    private static int TIMEOUT=10000;
    private static boolean TEST_ON_BORROW=true;
    private static JedisPool jedisPool=null;
    /**
     *@description
     初始化连接池
     *@anthor  10068921(lgyTT)
     *@date  2018/9/13
     *@other
     */

    static {
        try {

            JedisPoolConfig config=new JedisPoolConfig();
            config.setMaxIdle(MAX_IDLE);
            config.setMaxWaitMillis(MAX_WAIT);
            config.setTestOnBorrow(TEST_ON_BORROW);
            jedisPool=new JedisPool(config,ADDR,port,TIMEOUT,auth);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    /**
     *@description
     获取Jedis实例
     *@anthor  10068921(lgyTT)
     *@date  2018/9/13
     *@other
     */
    public synchronized static Jedis  getJedis(){
        try{
            if(jedisPool!=null){
                Jedis resource=jedisPool.getResource();
                return resource;
            }else {
                return null;
            }
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    /**
     *@description
     释放jedis资源
     *@anthor  10068921(lgyTT)
     *@date  2018/9/13
     *@other
     */
    public static void returnResource(final Jedis jedis){
        if(jedis!=null);
    }
}


