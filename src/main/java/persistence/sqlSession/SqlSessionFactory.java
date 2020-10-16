package persistence.sqlSession;

import persistence.sqlSession.SqlSession;

public interface SqlSessionFactory {
    public SqlSession openSession();
}
