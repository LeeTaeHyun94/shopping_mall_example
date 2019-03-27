package controller;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/resources/META-INF/spring/**/applicationContext.xml"})
public class SqlConnectionTest {
    @Autowired
    private DataSource dataSource;

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Test
    public void test() throws Exception {
        try (Connection connection = dataSource.getConnection()) {
            System.out.println(connection);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void factoryTest() {
        System.out.println(sqlSessionFactory);
    }

    @Test
    public void sessionTest() throws Exception {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            System.out.println(sqlSession);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
