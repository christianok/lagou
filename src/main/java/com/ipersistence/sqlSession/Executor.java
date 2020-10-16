package com.ipersistence.sqlSession;

import com.ipersistence.config.Configuration;
import com.ipersistence.config.MappedStatement;

import java.sql.SQLException;
import java.util.List;

public interface Executor {
    <E> List<E> query(Configuration configuration, MappedStatement
            mappedStatement, Object[] param) throws Exception;
    void close() throws SQLException;
}
