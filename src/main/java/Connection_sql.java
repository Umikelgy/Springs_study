
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Connection_sql {
        public  void listMytable() {
            //声明Connection对象
            Connection con;
            //驱动程序名
            String driver = "com.mysql.cj.jdbc.Driver";
            //URL指向要访问的数据库名mydata
            String url = "jdbc:mysql://localhost:3306/testdb?serverTimezone=UTC&useSSL=false";
            //MySQL配置时的用户名
            String user = "root";
            //MySQL配置时的密码
            String password = "1234xy";
            //遍历查询结果集
            try {
                //加载驱动程序
                Class.forName(driver);
                //1.getConnection()方法，连接MySQL数据库！！
                con = DriverManager.getConnection(url,user,password);
                if(!con.isClosed())
                    System.out.println("Succeeded connecting to the Database!");
                //2.创建statement类对象，用来执行SQL语句！！
                Statement statement = con.createStatement();
                //要执行的SQL语句
                String sql = "select * from websites";
                //3.ResultSet类，用来存放获取的结果集！！
                ResultSet rs = statement.executeQuery(sql);
               int i=1;
                while(rs.next()){
                Object object= rs.getObject(i);
                  i++;
                  System.out.println(object.toString());
                }
                rs.close();
                con.close();
            } catch(ClassNotFoundException e) {
                //数据库驱动类异常处理
                System.out.println("Sorry,can`t find the Driver!");
                e.printStackTrace();
            } catch(SQLException e) {
                //数据库连接失败异常处理
                e.printStackTrace();
            }catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }finally{
                System.out.println("数据库数据成功获取！！");
            }
        }

    }
