package com.example.jpaworkshop.dao;

import com.example.jpaworkshop.entity.AppUser;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public interface AppUserDao {

    Optional<AppUser> findById(int id);
    List<AppUser> findAll();
    void removeUser(AppUser appUser);
    AppUser update(AppUser appUser);
    AppUser save(AppUser appUser);
}
