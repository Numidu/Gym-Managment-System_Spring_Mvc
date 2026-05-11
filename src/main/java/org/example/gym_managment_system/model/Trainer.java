package org.example.gym_managment_system.model;

public class Trainer {

    private int id;
    private String name;
    private String specialty;
    private String phone;
    private int experience;

    public Trainer() {
    }

    public Trainer(int id, String name, String specialty, String phone, int experience) {
        this.id = id;
        this.name = name;
        this.specialty = specialty;
        this.phone = phone;
        this.experience = experience;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }
}