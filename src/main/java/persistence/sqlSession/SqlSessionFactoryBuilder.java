package persistence.sqlSession;

import persistence.Configuration;
import org.dom4j.DocumentException;

import java.beans.PropertyVetoException;
import java.io.InputStream;

public class SqlSessionFactoryBuilder {
    private Configuration configuration;

    public SqlSessionFactoryBuilder(){
       this.configuration = new Configuration();
    }

    public SqlSessionFactory build(InputStream inputStream) throws DocumentException, PropertyVetoException, ClassNotFoundException {
        //1.解析配置文件，封装Configuration
        XMLConfigerBuilder xmlConfigerBuilder = new XMLConfigerBuilder(configuration);

        Configuration configuration = xmlConfigerBuilder.parseConfiguration(inputStream);

        //2.创建 sqlSessionFactory
        return new DefaultSqlSessionFactory(configuration);
    }
}
