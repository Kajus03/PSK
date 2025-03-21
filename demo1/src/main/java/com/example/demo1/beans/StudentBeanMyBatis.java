package com.example.demo1.beans;

import com.example.demo1.entities.Studentas;
import com.example.demo1.persistence.mybatis.GrupeDAOMyBatis;
import com.example.demo1.persistence.mybatis.KursasDAOMyBatis;
import com.example.demo1.persistence.mybatis.StudentDAOMyBatis;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
@RequestScoped
public class StudentBeanMyBatis {
    @Inject
    private StudentDAOMyBatis studentDAO;
    @Inject
    private GrupeDAOMyBatis grupeDAO;
    @Inject
    private KursasDAOMyBatis kursasDAO;

    private Studentas newStudent = new Studentas();
    private Long selectedGrupeId;
    private List<Long> selectedKursaiIds = new ArrayList<>();

    public List<Studentas> getAllStudents() {
        return studentDAO.getAll();
    }

    public List<?> getAllGroups() {
        return grupeDAO.getAll();
    }

    public List<?> getAllKursai() {
        return kursasDAO.getAll();
    }

    public String createStudent() {
        if (selectedGrupeId != null) {
            newStudent.setGrupe(grupeDAO.find(selectedGrupeId));
        }
        studentDAO.create(newStudent, selectedKursaiIds);
        newStudent = new Studentas();
        selectedGrupeId = null;
        selectedKursaiIds.clear();
        return null;
    }

    public Studentas getNewStudent() { return newStudent; }
    public void setNewStudent(Studentas newStudent) { this.newStudent = newStudent; }
    public Long getSelectedGrupeId() { return selectedGrupeId; }
    public void setSelectedGrupeId(Long selectedGrupeId) { this.selectedGrupeId = selectedGrupeId; }
    public List<Long> getSelectedKursaiIds() { return selectedKursaiIds; }
    public void setSelectedKursaiIds(List<Long> selectedKursaiIds) { this.selectedKursaiIds = selectedKursaiIds; }
}
