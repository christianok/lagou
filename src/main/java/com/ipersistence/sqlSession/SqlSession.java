package com.ipersistence.sqlSession;

import java.sql.SQLException;
import java.util.List;

public interface SqlSession {
    <E> List<E> selectList(String statementId, Object... param) throws Exception;

    <T> T selectOne(String statementId, Object... params) throws Exception;

    void close() throws SQLException;

    <T> T getMapper(Class<?> mapperClass);
}
