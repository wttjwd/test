package edu.soft2.ioc.print;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component("a4Paper")默认名:类名首字母小写
@Component
public class A4Paper extends Paper{
    //重写父类方法并赋值
    @Override
    @Value("A4规格")
    public void setSize(String size) {
        super.setSize(size);
    }
}
