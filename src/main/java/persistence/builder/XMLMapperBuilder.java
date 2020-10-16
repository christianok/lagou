package persistence.builder;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import persistence.Configuration;
import persistence.MappedStatement;

import java.io.InputStream;
import java.util.List;

public class XMLMapperBuilder {
    private Configuration configuration;

    public XMLMapperBuilder(Configuration configuration) {
        this.configuration = configuration;
    }

    public void parse(InputStream inputStream) throws DocumentException,
            ClassNotFoundException {
        Document document = new SAXReader().read(inputStream);
        Element rootElement = document.getRootElement();
        String namespace = rootElement.attributeValue("namespace");
        List<Element> select = rootElement.selectNodes("select");
        for (Element element : select) { //id的值
            String id = element.attributeValue("id");

            String paramterType = element.attributeValue("paramterType");
            String resultType = element.attributeValue("resultType"); //输入参数
            Class<?> paramterTypeClass = getClassType(paramterType); //返回结果class
            Class<?> resultTypeClass = getClassType(resultType); //statementId
            String key = namespace + "." + id; //sql语句
            String textTrim = element.getTextTrim(); //封装 mappedStatement
            MappedStatement mappedStatement = new MappedStatement();
            mappedStatement.setId(Integer.valueOf(id));
            mappedStatement.setParameterType(paramterType);
            mappedStatement.setResultType(resultType);
            mappedStatement.setSql(textTrim);
            //填充 configuration
            configuration.getMappedStatementMap().put(key, mappedStatement);
        }
    }

    private Class<?> getClassType(String paramterType) throws
            ClassNotFoundException {
        Class<?> aclass = Class.forName(paramterType);
        return aclass;
    }

}