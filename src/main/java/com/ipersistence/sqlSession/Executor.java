package com.ipersistence.sqlSession;

import com.ipersistence.Configuration;
import com.ipersistence.MappedStatement;

import java.sql.SQLException;
import java.util.List;

public interface Executor {
    <E> List<E> query(Configuration configuration, MappedStatement
            mappedStatement, Object[] param) throws Exception;
    void close() throws SQLException;
}
