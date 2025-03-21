package com.example.demo1.beans;

import com.example.demo1.entities.PasirenkamasKursas;
import com.example.demo1.persistence.jpa.KursasDAOJPA;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class KursasBeanJPA {
    @Inject
    private KursasDAOJPA kursasDAO;

    private PasirenkamasKursas newKursas = new PasirenkamasKursas();

    public List<PasirenkamasKursas> getAllKursai() {
        return kursasDAO.getAll();
    }

    public String createKursas() {
        kursasDAO.create(newKursas);
        newKursas = new PasirenkamasKursas();
        return null;
    }

    public PasirenkamasKursas getNewKursas() {
        return newKursas;
    }
    public void setNewKursas(PasirenkamasKursas newKursas) {
        this.newKursas = newKursas;
    }
}
