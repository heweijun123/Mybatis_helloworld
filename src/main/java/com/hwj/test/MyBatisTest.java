package com.hwj.test;

import com.hwj.test.bean.Employee;
import com.hwj.test.dao.EmployeeDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisTest {

    SqlSessionFactory sqlSessionFactory;

    @Before
    public void initSqlSessionFactory() throws Exception{

        //1、根据全局配置文件创建出一个SqlSessionFactory
        //SqlSessionFactory：是SqlSession工厂，负责创建SqlSession对象；
        //SqlSession：sql会话（代表和数据库的一次会话）
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void testSelect() throws IOException {

        //2、获取和数据库的一次会话
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);

        try {

            Employee employee = employeeDao.getEmpById(1);
            System.out.println(employee);
        } finally {

            sqlSession.close();
        }
    }

    @Test
    public void testInsert() throws IOException {

        //2、获取和数据库的一次会话
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);

        try {

            Employee employee = Employee.builder().empName("tomcat2").email("tomcat2@qq.com").gender(0).build();
            int i = employeeDao.insertEmployee(employee);
            System.out.println(i);
        } finally {

            sqlSession.close();
        }
    }
}
