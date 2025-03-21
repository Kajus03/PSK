package com.example.demo1.beans;

import com.example.demo1.entities.Studentas;
import com.example.demo1.entities.Grupe;
import com.example.demo1.entities.PasirenkamasKursas;
import com.example.demo1.persistence.jpa.StudentDAOJPA;
import com.example.demo1.persistence.jpa.GrupeDAOJPA;
import com.example.demo1.persistence.jpa.KursasDAOJPA;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
@RequestScoped
public class StudentBeanJPA {
    @Inject
    private StudentDAOJPA studentDAO;
    @Inject
    private GrupeDAOJPA grupeDAO;
    @Inject
    private KursasDAOJPA kursasDAO;

    private Studentas newStudent = new Studentas();
    private Long selectedGrupeId;
    private List<Long> selectedKursaiIds = new ArrayList<>();

    public List<Studentas> getAllStudents() {
        return studentDAO.getAll();
    }

    public List<Grupe> getAllGroups() {
        return grupeDAO.getAll();
    }

    public List<PasirenkamasKursas> getAllKursai() {
        return kursasDAO.getAll();
    }

    public String createStudent() {
        // Surandame grupę pagal ID ir priskiriame naujam studentui
        if (selectedGrupeId != null) {
            Grupe g = grupeDAO.find(selectedGrupeId);
            newStudent.setGrupe(g);
        }

        List<PasirenkamasKursas> pasirenkami = new ArrayList<>();
        for (Long kursasId : selectedKursaiIds) {
            PasirenkamasKursas k = kursasDAO.find(kursasId);
            pasirenkami.add(k);
        }
        newStudent.setPasirenkamiKursai(pasirenkami);

        studentDAO.create(newStudent);

        newStudent = new Studentas();
        selectedGrupeId = null;
        selectedKursaiIds.clear();
        return null;
    }

    public Studentas getNewStudent() {
        return newStudent;
    }
    public void setNewStudent(Studentas newStudent) {
        this.newStudent = newStudent;
    }

    public Long getSelectedGrupeId() {
        return selectedGrupeId;
    }
    public void setSelectedGrupeId(Long selectedGrupeId) {
        this.selectedGrupeId = selectedGrupeId;
    }

    public List<Long> getSelectedKursaiIds() {
        return selectedKursaiIds;
    }
    public void setSelectedKursaiIds(List<Long> selectedKursaiIds) {
        this.selectedKursaiIds = selectedKursaiIds;
    }
}
