import com.bruce.module.mybatis.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;


/**
 * Created by Mr.Bruce on 2017/12/13.
 */
public class MybatisFirst {

    @Test
    public void findUserByIdTest() {
        //mybatis的配置文件
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = null;
        SqlSession sqlSession = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
            //1.创建会话工厂，传入mybatis的配置文件信息
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            //2.通过工厂得到SqlSession
            sqlSession = factory.openSession();
            //3.通过SqlSession操作数据库
            //参数一：映射文件中的statement的id，等于namespace+"."+statement的id；
            //参数二：指定和映射文件中所匹配的parameterType类型的参数；
            //sqlSession.selectOne结果是与映射文件所匹配的resultType类型的对象；
            //selectOne：查询一条结果
            User user = sqlSession.selectOne("test.findUserById", 1);
            System.out.println(user.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void insertUserTest() {
        //mybatis的配置文件
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = null;
        SqlSession sqlSession = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
            //1.创建会话工厂，传入mybatis的配置文件信息
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            //2.通过工厂得到SqlSession
            sqlSession = factory.openSession();
            User user = new User("yan", new Date(System.currentTimeMillis()), "女", "上海");
            //3.通过SqlSession操作数据库
            //参数一：映射文件中的statement的id，等于namespace+"."+statement的id；
            //参数二：指定和映射文件中所匹配的parameterType类型的参数；
            sqlSession.insert("test.insertUser", user);
            //提交事务
            sqlSession.commit();
            System.out.println(user.getId());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void deleteUserTest() {
        //mybatis的配置文件
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = null;
        SqlSession sqlSession = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
            //1.创建会话工厂，传入mybatis的配置文件信息
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            //2.通过工厂得到SqlSession
            sqlSession = factory.openSession();
            //3.通过SqlSession操作数据库
            //参数一：映射文件中的statement的id，等于namespace+"."+statement的id；
            //参数二：指定和映射文件中所匹配的parameterType类型的参数；
            sqlSession.delete("test.deleteUser", 3);
            //提交事务
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void updateUserTest() {
        //mybatis的配置文件
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = null;
        SqlSession sqlSession = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
            //1.创建会话工厂，传入mybatis的配置文件信息
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            //2.通过工厂得到SqlSession
            sqlSession = factory.openSession();
            User user = new User("d1b22e85-e016-11e7-b614-c85b763db570", "y1an", new Date(System.currentTimeMillis()), "女", "上海");
            //3.通过SqlSession操作数据库
            //参数一：映射文件中的statement的id，等于namespace+"."+statement的id；
            //参数二：指定和映射文件中所匹配的parameterType类型的参数；
            //根据id更新用户
            sqlSession.update("test.updateUser", user);
            //提交事务
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}