import logUtil.LogEnum;
import logUtil.LogUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/*
 *@description:
 *
 *@author 10068921(LgyTT)
 *@date 2018/11/26 9:39
 */
public class LoggerTest {
    protected static final Logger log= LogManager.getLogger(LoggerTest.class);
    @Test
    public void TestDB(){
       method();
    }
    public static void method(){
        Connection_sql sql=new Connection_sql();
        sql.listMytable();
       Logger logger= LogManager.getLogger(Connection_sql.class);
//       logger.debug("djkl");
        logger.error("wanc","ok");
    }
    public static void main(String[]args) throws FileNotFoundException {
        Yaml yaml=new Yaml();
        yaml.load(new FileInputStream(new File("C:\\Users\\10068921\\IdeaProjects\\WebMaven_M\\logg4j2\\src\\main\\resources\\log4j2.yaml")));
     log.debug("hello world");
    }
}
