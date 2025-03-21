package com.example.demo1.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "GRUPE")
public class Grupe implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int kursas;

    private String specialybe;

    @OneToMany(mappedBy = "grupe", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Studentas> studentai = new ArrayList<>();

    // Konstruktoriai
    public Grupe() {}
    public Grupe(int kursas, String specialybe) {
        this.kursas = kursas;
        this.specialybe = specialybe;
    }

    // Getteriai ir setteriai
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public int getKursas() { return kursas; }
    public void setKursas(int kursas) { this.kursas = kursas; }
    public String getSpecialybe() { return specialybe; }
    public void setSpecialybe(String specialybe) { this.specialybe = specialybe; }
    public List<Studentas> getStudentai() { return studentai; }
    public void setStudentai(List<Studentas> studentai) { this.studentai = studentai; }
}
