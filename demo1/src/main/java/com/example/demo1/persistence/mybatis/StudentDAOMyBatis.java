package com.example.demo1.persistence.mybatis;

import com.example.demo1.entities.Studentas;
import com.example.demo1.entities.StudentKursas;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class StudentDAOMyBatis {

    @Inject
    private SqlSessionFactory sqlSessionFactory;

    public void create(Studentas s, List<Long> kursaiIds) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            session.insert("com.example.demo1.persistence.mybatis.StudentasMapper.insertStudentas", s);
            for (Long kursasId : kursaiIds) {
                session.insert("com.example.demo1.persistence.mybatis.StudentasMapper.insertStudentasKursas",
                        new StudentKursas(s.getId(), kursasId));
            }
            session.commit();
        }
    }

    public List<Studentas> getAll() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.selectList("com.example.demo1.persistence.mybatis.StudentasMapper.selectAllStudentas");
        }
    }
}
