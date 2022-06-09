package com.example.jpaworkshop.dao;

import com.example.jpaworkshop.entity.AppUser;
import com.example.jpaworkshop.entity.Details;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.PersistenceContext;
import java.time.LocalDate;

@SpringBootTest
public class AppUserDaoTest {

    @Autowired
    AppUserDao tesObject;

    @Test
    public void save_successfully(){
        AppUser appUser = new AppUser("password", "username", new Details("emil.com", LocalDate.parse("1980-09-09"),"Micke"));
        AppUser expected = tesObject.save(appUser);
        Assertions.assertEquals(expected, tesObject.findById(expected.getId()).get());
    }
}
