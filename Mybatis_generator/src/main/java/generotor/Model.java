package generotor;

import lombok.Data;
import org.junit.jupiter.api.Test;

/*
 *@description:
 *
 *@author 10068921(LgyTT)
 *@date 2018/11/16 8:57
 */
@Data
public class Model {
    private String driver;
    private String url;
    private String userName;
    private String passwd;
    private String table;
    private String modelName;
    private String AllTargeProject;
    private String EntityTargePackage;
    private String mapperTargePackage;
    private String daoTargePackage;
    private int InitalSize;//定义初始化连接数
    private int MaxActive;//定义最大连接数
    private int MaxIdle;//定义最大空间
    private int MinIdle;//定义最小空间
    private long  MaxWait;//定义最长等待时间
    public void init (){
        driver="com.mysql.cj.jdbc.Driver";
        AllTargeProject=System.getProperty("user.dir");//获取项目绝对路径
        InitalSize=0;
        MaxActive=20;
        MinIdle=1;
        MaxIdle=20;
        MaxWait=60000;
    }

    public Model(String url, String userName, String passwd, String table, String modelName, String entityTargePackage, String mapperTargePackage, String daoTargePackage) {
        this.url = url;
        this.userName = userName;
        this.passwd = passwd;
        this.table = table;
        this.modelName = modelName;
        EntityTargePackage = entityTargePackage;
        this.mapperTargePackage = mapperTargePackage;
        this.daoTargePackage = daoTargePackage;
    }

    public Model() {
    }
}
