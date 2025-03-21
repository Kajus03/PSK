package com.example.demo1.persistence.mybatis;

import com.example.demo1.entities.Studentas;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import com.example.demo1.entities.StudentKursas;

@Named
@RequestScoped
public class StudentDAOMyBatis {

    @Inject
    private SqlSessionFactory sqlSessionFactory;

    public void create(Studentas s, List<Long> kursaiIds) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            session.insert("com.example.demo1.persistence.mybatis.StudentasMapper.insertStudentas", s);
            // Po įterpimo, generuotas s.id turi būti nustatytas
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
