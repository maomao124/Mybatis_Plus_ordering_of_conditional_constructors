package mapper;

import com.baomidou.mybatisplus.core.MybatisSqlSessionFactoryBuilder;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import data.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：Mybatis_Plus条件构造器之排序
 * Package(包名): mapper
 * Class(测试类名): StudentMapperTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/4/6
 * Time(创建时间)： 21:57
 * Version(版本): 1.0
 * Description(描述)： 测试类
 * orderBy
 * 排序：ORDER BY 字段, ...
 * 例: orderBy(true, true, "id", "name") ---> order by id ASC,name ASC
 * orderByAsc
 * 排序：ORDER BY 字段, ... ASC
 * 例: orderByAsc("id", "name") ---> order by id ASC,name ASC
 * orderByDesc
 * 排序：ORDER BY 字段, ... DESC
 * 例: orderByDesc("id", "name") ---> order by id DESC,name DESC
 */

class StudentMapperTest
{
    @Test
    public void orderBy() throws IOException
    {
        String resource = "mybatis-config.xml";
        //读取配置文件mybatis-config.xml
        InputStream config = Resources.getResourceAsStream(resource);
        //根据配置文件构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new MybatisSqlSessionFactoryBuilder().build(config);
        //通过SqlSessionFactory创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderBy(true, false, "class_no", "student_no");

        List<Student> list = studentMapper.selectList(queryWrapper);

        for (Student student : list)
        {
            System.out.print(student);
        }
        System.out.println("数量：" + list.size());

        sqlSession.close();
    }

    @Test
    public void orderBy1() throws IOException
    {
        String resource = "mybatis-config.xml";
        //读取配置文件mybatis-config.xml
        InputStream config = Resources.getResourceAsStream(resource);
        //根据配置文件构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new MybatisSqlSessionFactoryBuilder().build(config);
        //通过SqlSessionFactory创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderBy(true, true, "sex");

        List<Student> list = studentMapper.selectList(queryWrapper);

        for (Student student : list)
        {
            System.out.print(student);
        }
        System.out.println("数量：" + list.size());

        sqlSession.close();
    }


    @Test
    public void orderByAsc() throws IOException
    {
        String resource = "mybatis-config.xml";
        //读取配置文件mybatis-config.xml
        InputStream config = Resources.getResourceAsStream(resource);
        //根据配置文件构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new MybatisSqlSessionFactoryBuilder().build(config);
        //通过SqlSessionFactory创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("class_no", "sex");

        List<Student> list = studentMapper.selectList(queryWrapper);

        for (Student student : list)
        {
            System.out.print(student);
        }
        System.out.println("数量：" + list.size());

        sqlSession.close();
    }

    @Test
    public void orderByDesc() throws IOException
    {
        String resource = "mybatis-config.xml";
        //读取配置文件mybatis-config.xml
        InputStream config = Resources.getResourceAsStream(resource);
        //根据配置文件构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new MybatisSqlSessionFactoryBuilder().build(config);
        //通过SqlSessionFactory创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("class_no", "sex");

        List<Student> list = studentMapper.selectList(queryWrapper);

        for (Student student : list)
        {
            System.out.print(student);
        }
        System.out.println("数量：" + list.size());

        sqlSession.close();
    }
}