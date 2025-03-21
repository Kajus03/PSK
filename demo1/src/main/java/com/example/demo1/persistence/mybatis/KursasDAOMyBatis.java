package com.example.demo1.persistence.mybatis;

import com.example.demo1.entities.PasirenkamasKursas;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class KursasDAOMyBatis {

    @Inject
    private SqlSessionFactory sqlSessionFactory;

    public void create(PasirenkamasKursas k) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            session.insert("com.example.demo1.persistence.mybatis.KursasMapper.insertKursas", k);
            session.commit();
        }
    }

    public List<PasirenkamasKursas> getAll() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.selectList("com.example.demo1.persistence.mybatis.KursasMapper.selectAllKursas");
        }
    }

    public PasirenkamasKursas find(Long id) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.selectOne("com.example.demo1.persistence.mybatis.KursasMapper.selectKursasById", id);
        }
    }
}
