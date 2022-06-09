package com.example.jpaworkshop.dao.Repository;

import com.example.jpaworkshop.dao.DetailsDao;
import com.example.jpaworkshop.entity.Details;
import com.example.jpaworkshop.exception.ObjectNotFoundExceptionMS;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public class DetailsDaoRep implements DetailsDao {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Optional<Details> findById(int id) {
        return Optional.ofNullable( entityManager.find(Details.class, id));
    }

    @Override
    public List<Details> findAll() {
        return entityManager.createQuery("Select d from Details d").getResultList();
    }

    @Override
    @Transactional
    public Details save(Details details) {
        entityManager.persist(details);
        return  details;
    }

    @Override
    @Transactional
    public void remove(Details details) {
        findById(details.getId()).orElseThrow(ObjectNotFoundExceptionMS::new);
        entityManager.remove(details);
    }

    @Override
    @Transactional
    public Details update(Details details) {
        return entityManager.merge(details);
    }
}
