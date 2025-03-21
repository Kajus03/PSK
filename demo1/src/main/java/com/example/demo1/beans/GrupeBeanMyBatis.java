package com.example.demo1.beans;

import com.example.demo1.entities.Grupe;
import com.example.demo1.persistence.mybatis.GrupeDAOMyBatis;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class GrupeBeanMyBatis {
    @Inject
    private GrupeDAOMyBatis grupeDAO;

    private Grupe newGrupe = new Grupe();

    public List<Grupe> getAllGroups() {
        return grupeDAO.getAll();
    }

    public String createGrupe() {
        grupeDAO.create(newGrupe);
        newGrupe = new Grupe();
        return null;
    }

    public Grupe getNewGrupe() {
        return newGrupe;
    }
    public void setNewGrupe(Grupe newGrupe) {
        this.newGrupe = newGrupe;
    }
}
