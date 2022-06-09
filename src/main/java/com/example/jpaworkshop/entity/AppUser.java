package com.example.jpaworkshop.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private int id;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String username;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "detail_id", referencedColumnName = "id")
    private Details userDetails;

    private LocalDate regDate;

    public AppUser() {
        this.regDate = LocalDate.now();

    }

    public AppUser(String password, String username, Details userDetails) {
        super();
        this.password = password;
        this.username = username;
        this.userDetails = userDetails;
    }

    public AppUser(int id, String password, String username, Details userDetails) {
        super();
        this.id = id;
        this.password = password;
        this.username = username;
        this.userDetails = userDetails;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Details getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(Details userDetails) {
        this.userDetails = userDetails;
    }

    public LocalDate getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDate regDate) {
        this.regDate = regDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppUser appUser = (AppUser) o;
        return id == appUser.id && password.equals(appUser.password) && username.equals(appUser.username) && Objects.equals(userDetails, appUser.userDetails) && Objects.equals(regDate, appUser.regDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, password, username, userDetails, regDate);
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", userDetails=" + userDetails +
                ", regDate=" + regDate +
                '}';
    }
}
