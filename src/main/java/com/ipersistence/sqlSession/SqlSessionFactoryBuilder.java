package com.ipersistence.sqlSession;

import com.ipersistence.config.Configuration;
import com.ipersistence.config.XMLConfigerBuilder;
import org.dom4j.DocumentException;

import java.beans.PropertyVetoException;
import java.io.InputStream;

public class SqlSessionFactoryBuilder {

    public SqlSessionFactory build(InputStream inputStream) throws DocumentException, PropertyVetoException, ClassNotFoundException {
        //1.解析配置文件，封装Configuration
        XMLConfigerBuilder xmlConfigerBuilder = new XMLConfigerBuilder();

        Configuration configuration = xmlConfigerBuilder.parseConfiguration(inputStream);

        //2.创建 sqlSessionFactory
        return new DefaultSqlSessionFactory(configuration);
    }
}
