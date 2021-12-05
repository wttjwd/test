import edu.soft2.ioc.coffee.CoffeeBean;
import edu.soft2.ioc.coffee.CoffeeMachine;
import edu.soft2.ioc.print.Printer;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IocTest {
    //1.获取上下文(context)对象
    ApplicationContext context =
            new ClassPathXmlApplicationContext("applicationContext.xml");
    @Test
    public void testCoffee(){
        /*//2.context对象(封装了BeanFactory)
        CoffeeBean coffeeBean = (CoffeeBean) context.getBean("mocaBean");//注入什么口味的咖啡，就出来什么口味
        coffeeBean.drink();*/
        CoffeeMachine machine = (CoffeeMachine) context.getBean("coffeeMachine");
        machine.make();

    }
    @Test
    public void testPrinter(){
        Printer printer = (Printer) context.getBean("printer");
        printer.print();
    }
}
