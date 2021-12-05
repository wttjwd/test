import edu.soft2.pojo.User;
import edu.soft2.service.UserService;
import edu.soft2.service.impl.HelloworldService;
import edu.soft2.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AopTest {
    int expected = 0;
    String name = null;
    String pwd = null;

    public AopTest(int expected, String name, String pwd) {
        this.expected = expected;
        this.name = name;
        this.pwd = pwd;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> t() {
        return Arrays.asList(new Object[][]{
                {1, "peter", "123"}, {1, "john", "456"}, {1, "helen", "789"}
        });
    }

    //1.获取上下文(context)对象
    ApplicationContext context =
            new ClassPathXmlApplicationContext("applicationContext.xml");

    @Test
    public void helloworldTest() {
        HelloworldService helloworldService = (HelloworldService) context.getBean("helloworldService");
        helloworldService.sayHi();//调用方法
        helloworldService.sayHello();//调用方法

    }

    @Test
    public void userServiceTest() {
//        String name = "peter";
//        String pwd = "123";
        UserService service = (UserService) context.getBean(UserServiceImpl.class);
        User user = context.getBean(User.class);
        user.setName(name);
        user.setPwd(pwd);
        assertEquals(expected, service.addUser(user));//断言
        // service.delUser(user);
        //service.updateUser(user);
//        service.queryUser(user);
    }
}