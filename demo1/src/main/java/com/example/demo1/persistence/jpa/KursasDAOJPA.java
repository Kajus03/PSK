package com.example.demo1.persistence.jpa;

import com.example.demo1.entities.PasirenkamasKursas;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class KursasDAOJPA {

    @PersistenceContext(unitName = "DemoPersistenceUnit")
    private EntityManager em;

    public void create(PasirenkamasKursas k) {
        em.persist(k);
    }

    public List<PasirenkamasKursas> getAll() {
        return em.createQuery("SELECT k FROM PasirenkamasKursas k", PasirenkamasKursas.class).getResultList();
    }

    public PasirenkamasKursas find(Long id) {
        return em.find(PasirenkamasKursas.class, id);
    }
}
