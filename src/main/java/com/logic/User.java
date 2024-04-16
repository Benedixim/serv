package com.logic;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.sql.Date;

@Entity
@Table(name = "users")
public class User {
    private String firstName;
    private String lastName;

    private String patronymic;

    private Date data;
    private String profession;

    private String placement;

    private String userName;
    private String password;
    private String location;
    private String gender;
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }



    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getPlacement() {
        return placement;
    }

    public void setPlacement(String placement) {
        this.placement = placement;
    }

    public User(Long id, String firstName, String lastName, String patronymic, Date data, String profession, String placement, String userName, String password, String location, String gender) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.data = data;
        this.profession = profession;
        this.placement = placement;
        this.userName = userName;
        this.password = password;
        this.location = location;
        this.gender = gender;
    }

    public User(String firstName, String lastName, String patronymic, Date data, String profession, String placement, String userName, String password, String location, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.data = data;
        this.profession = profession;
        this.placement = placement;
        System.out.println(placement + this.placement);
        this.userName = userName;
        this.password = password;
        this.location = location;
        this.gender = gender;
    }

    public User(String firstName, String lastName, String userName, String password, String location, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.location = location;
        this.gender = gender;
    }

    public User(Long id, String firstName, String lastName, String userName, String password, String location, String gender) {

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.location = location;
        this.gender = gender;

    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", data=" + data +
                ", placement='" + placement + '\'' +
                '}';
    }
}
