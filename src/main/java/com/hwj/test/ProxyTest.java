package com.hwj.test;

import com.hwj.bean.Employee;
import com.hwj.dao.EmployeeDao;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {

    @Test
    public void test() {

        TestInvocationHandler testInvocationHandler = new TestInvocationHandler();
        EmployeeDao proxy = (EmployeeDao)Proxy.newProxyInstance(EmployeeDao.class.getClassLoader(), new Class[]{EmployeeDao.class}, testInvocationHandler);
        String s = proxy.toString();
        System.out.println(s);
    }


    class TestInvocationHandler implements InvocationHandler {

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

            //proxy：代理对象
            //this：TestInvocationHandler的对象

            //可以使用反射获取代理对象的信息，也就是proxy.getClass().getName()
            String className = proxy.getClass().getName();

            //可以将代理对象返回以进行连续调用，这就是proxy存在的目的，因为this并不是代理对象
            //如：account.deposit(5000).deposit(4000).deposit(-2500);
            return proxy;
        }
    }
}
