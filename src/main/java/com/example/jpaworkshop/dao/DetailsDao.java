package com.example.jpaworkshop.dao;

import com.example.jpaworkshop.entity.Details;

import java.util.List;
import java.util.Optional;

public interface DetailsDao {
    Optional<Details>  findById(int id);
    List<Details> findAll();
    Details save(Details details);
    void remove(Details details);
    Details update(Details details);
}
