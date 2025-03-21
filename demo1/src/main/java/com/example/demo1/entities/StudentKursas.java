package com.example.demo1.entities;

import java.io.Serializable;

public class StudentKursas implements Serializable {
    private Long studentasId;
    private Long kursasId;

    public StudentKursas() {}
    public StudentKursas(Long studentasId, Long kursasId) {
        this.studentasId = studentasId;
        this.kursasId = kursasId;
    }
    public Long getStudentasId() { return studentasId; }
    public void setStudentasId(Long studentasId) { this.studentasId = studentasId; }
    public Long getKursasId() { return kursasId; }
    public void setKursasId(Long kursasId) { this.kursasId = kursasId; }
}
