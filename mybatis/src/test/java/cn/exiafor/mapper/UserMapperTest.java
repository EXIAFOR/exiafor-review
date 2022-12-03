package cn.exiafor.mapper;

import cn.exiafor.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserMapperTest {
    @Test
    public void test1() throws IOException {
        // 读取MyBatis核心配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

        // 创建sqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder =
                new SqlSessionFactoryBuilder();

        //通过核心配置文件所对应的字节输入流创建工厂类sqlSessionFactory，生产sqlSession对象
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);

        //创建SqlSession对象，此时通过SqlSession对象所操作的sql都必须手动提交或回滚事务
        //SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建SqlSession对象，此时通过SqlSession对象所操作的sql都会自动提交
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //通过代理模式创建UserMapper接口的代理实现类对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //调用UserMapper接口中的方法，就可以根据UserMapper的全类名匹配元素文件，
        // 通过调用的方法名匹配映射文件中的SQL标签，并执行标签中的SQL语句
//        int result = userMapper.insertUser();
//        int result = userMapper.deleteUser();
//        int result = userMapper.updateUser();
//        User user = userMapper.getUserById();
//        List<User> userList = userMapper.getUserList();







//        int result = userMapper.insertUser("newTest", "newPass");


//        Map<String, Object> userMap = userMapper.getUserToMap(12);
//
//        System.out.println("结果 : " + userMap);

//        int count = userMapper.getCount();

//        System.out.println("结果 : " + count);


        List<User> userList = userMapper.testMoHu("%min%");

        for (User user : userList) {
            System.out.println(user);
        }


        is.close();
    }
}
