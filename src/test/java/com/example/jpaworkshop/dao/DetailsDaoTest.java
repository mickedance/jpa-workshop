package com.example.jpaworkshop.dao;

import com.example.jpaworkshop.entity.Details;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class DetailsDaoTest {

    @Autowired
    DetailsDao testObject;

    @Test
    public void save_successfully(){
        Details details1 = new Details("emil@e.com", LocalDate.parse("1900-02-02"),"Mike");
        Details expected = testObject.save(details1);
        Assertions.assertEquals(expected, testObject.findById(expected.getId()).get());
    }
}
