package com.example.demo1.persistence.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import java.io.IOException;
import java.io.Reader;

@ApplicationScoped
public class MyBatisResources {
    private SqlSessionFactory sqlSessionFactory;

    public MyBatisResources() {
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException ex) {
            throw new RuntimeException("Error initializing MyBatis", ex);
        }
    }

    @Produces
    public SqlSessionFactory produceSqlSessionFactory() {
        return sqlSessionFactory;
    }
}
