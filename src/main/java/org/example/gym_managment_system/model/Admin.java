package org.example.gym_managment_system.model;



public class Admin {

    private int id;
    private String username;
    private String email;
    private String password;
    private String contactno;
    private String image;


    public Admin() {
    }

    public Admin(int id, String username, String password,String email, String contactno,String image) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.contactno = contactno;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactno() {
        return contactno;
    }

    public void setContactno(String contactno) {
        this.contactno = contactno;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
