import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import po.User;
import serviceApi.UserService;
import serviceImpl.UserServiceImpl;

import java.util.List;

/*
 *@description:
 *
 *@author 10068921(LgyTT)
 *@date 2018/10/8 14:33
 */
public class TestMybaits {
    @Test
    public void TestqueryAll(){
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("application.xml");

        UserService service= (UserServiceImpl) context.getBean("userServiceImpl");
        User user=service.queryById(1006);
        System.out.println("userId="+user.getUserId());
        List<User>  list=service.queryAllUser();
        System.out.println("listSize=\n"+list);
    }
}
