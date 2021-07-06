package com.hwj.test;

import com.hwj.bean.Employee;
import com.hwj.bean.Teacher;
import com.hwj.dao.EmployeeDao;
import com.hwj.dao.TeacherDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public class TeacherTest {

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
        TeacherDao teacherDao = sqlSession.getMapper(TeacherDao.class);

        try {

//            Teacher teacher = Teacher.builder().id(1).name("%a%").build();
            List<Teacher> list = teacherDao.getTeacherByIdIn(Arrays.asList(1,2,3,4,5));

            System.out.println(list);
        } finally {

            sqlSession.close();
        }
    }
}
