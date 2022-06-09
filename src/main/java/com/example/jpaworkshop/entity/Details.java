package com.example.jpaworkshop.entity;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Details {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private int id;

    @Column(nullable = false, unique = true )
    private String email;


    private LocalDate birthday;

    @Column(nullable = false)
    private String name;

    public Details() {
    }

    public Details(String email, LocalDate birthday, String name) {
        this.email = email;
        this.birthday = birthday;
        this.name = name;
    }

    public Details(int id, String email, LocalDate birthday, String name) {
        this.id = id;
        this.email = email;
        this.birthday = birthday;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Details details = (Details) o;
        return id == details.id && email.equals(details.email) && Objects.equals(birthday, details.birthday) && name.equals(details.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, birthday, name);
    }

    @Override
    public String toString() {
        return "Details{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", birthday=" + birthday +
                ", name='" + name + '\'' +
                '}';
    }
}
