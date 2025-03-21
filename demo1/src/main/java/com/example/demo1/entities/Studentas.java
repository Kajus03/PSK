package com.example.demo1.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "STUDENTAS")
public class Studentas implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String vardas;
    private String pavadinimas;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "GRUPE_ID")
    private Grupe grupe;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "STUDENTAS_KURSAS",
            joinColumns = @JoinColumn(name = "STUDENTAS_ID"),
            inverseJoinColumns = @JoinColumn(name = "KURSAS_ID"))
    private List<PasirenkamasKursas> pasirenkamiKursai = new ArrayList<>();

    // Konstruktoriai
    public Studentas() {}
    public Studentas(String vardas, String pavadinimas) {
        this.vardas = vardas;
        this.pavadinimas = pavadinimas;
    }

    // Getteriai ir setteriai
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getVardas() { return vardas; }
    public void setVardas(String vardas) { this.vardas = vardas; }
    public String getPavadinimas() { return pavadinimas; }
    public void setPavadinimas(String pavadinimas) { this.pavadinimas = pavadinimas; }
    public Grupe getGrupe() { return grupe; }
    public void setGrupe(Grupe grupe) { this.grupe = grupe; }
    public List<PasirenkamasKursas> getPasirenkamiKursai() { return pasirenkamiKursai; }
    public void setPasirenkamiKursai(List<PasirenkamasKursas> pasirenkamiKursai) { this.pasirenkamiKursai = pasirenkamiKursai; }
}
