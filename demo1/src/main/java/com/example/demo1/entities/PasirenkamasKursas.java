package com.example.demo1.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "PASIRENKAMAS_KURSAS")
public class PasirenkamasKursas implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String pavadinimas;

    @ManyToMany(mappedBy = "pasirenkamiKursai", fetch = FetchType.LAZY)
    private List<Studentas> studentai = new ArrayList<>();

    public PasirenkamasKursas() {}
    public PasirenkamasKursas(String pavadinimas) {
        this.pavadinimas = pavadinimas;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getPavadinimas() { return pavadinimas; }
    public void setPavadinimas(String pavadinimas) { this.pavadinimas = pavadinimas; }
    public List<Studentas> getStudentai() { return studentai; }
    public void setStudentai(List<Studentas> studentai) { this.studentai = studentai; }
}
