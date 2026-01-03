package model;

import jakarta.persistence.*;

@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "course_name", nullable = false)
    private String name;

    @Column(name = "course_code", unique = true)
    private String code;

    private double fee;

    public Course() {}

    public Course(String name, String code, double fee) {
        this.name = name;
        this.code = code;
        this.fee = fee;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    public double getFee() { return fee; }
    public void setFee(double fee) { this.fee = fee; }
}	