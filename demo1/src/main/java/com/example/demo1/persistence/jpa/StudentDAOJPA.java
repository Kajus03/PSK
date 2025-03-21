package com.example.demo1.persistence.jpa;

import com.example.demo1.entities.Studentas;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class StudentDAOJPA {

    @PersistenceContext(unitName = "DemoPersistenceUnit")
    private EntityManager em;

    public void create(Studentas s) {
        em.persist(s);
    }

    public List<Studentas> getAll() {
        String jpql = "SELECT DISTINCT s FROM Studentas s LEFT JOIN FETCH s.pasirenkamiKursai";
        return em.createQuery(jpql, Studentas.class).getResultList();
    }

    public Studentas find(Long id) {
        String jpql = "SELECT s FROM Studentas s LEFT JOIN FETCH s.pasirenkamiKursai WHERE s.id = :id";
        return em.createQuery(jpql, Studentas.class)
                .setParameter("id", id)
                .getSingleResult();
    }
}
