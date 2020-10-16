import persistence.io.Resources;
import persistence.sqlSession.SqlSessionFactory;
import persistence.sqlSession.SqlSessionFactoryBuilder;
import persistence.entity.User;
import persistence.mapper.UserMapper;
import org.dom4j.DocumentException;
import org.junit.Test;
import persistence.sqlSession.SqlSession;

import java.beans.PropertyVetoException;
import java.io.InputStream;

public class IPersistenceTest {
    @Test
    public void test() throws DocumentException, PropertyVetoException, ClassNotFoundException {
        InputStream inputStream = Resources.getResourceAsSteam("SqlMapConfig.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        User user = new User();
        user.setId(1);
        user.setUsername("hello");

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user1 = userMapper.selectOne(user);
        System.out.println(user1);

    }
}
