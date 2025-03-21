package com.example.demo1.persistence.mybatis;

import com.example.demo1.entities.Grupe;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class GrupeDAOMyBatis {

    @Inject
    private SqlSessionFactory sqlSessionFactory;

    public void create(Grupe g) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            session.insert("com.example.demo1.persistence.mybatis.GrupeMapper.insertGrupe", g);
            session.commit();
        }
    }

    public List<Grupe> getAll() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.selectList("com.example.demo1.persistence.mybatis.GrupeMapper.selectAllGrupe");
        }
    }

    public Grupe find(Long id) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.selectOne("com.example.demo1.persistence.mybatis.GrupeMapper.selectGrupeById", id);
        }
    }
}
