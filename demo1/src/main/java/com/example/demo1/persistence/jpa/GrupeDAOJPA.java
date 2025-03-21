package com.example.demo1.persistence.jpa;

import com.example.demo1.entities.Grupe;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class GrupeDAOJPA {

    @PersistenceContext(unitName = "DemoPersistenceUnit")
    private EntityManager em;

    public void create(Grupe g) {
        em.persist(g);
    }

    public List<Grupe> getAll() {
        return em.createQuery("SELECT g FROM Grupe g", Grupe.class).getResultList();
    }

    public Grupe find(Long id) {
        return em.find(Grupe.class, id);
    }
}
