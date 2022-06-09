package com.example.jpaworkshop.dao.Repository;

import com.example.jpaworkshop.dao.AppUserDao;
import com.example.jpaworkshop.entity.AppUser;
import com.example.jpaworkshop.exception.ObjectNotFoundExceptionMS;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public class AppUserDapRep implements AppUserDao {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Optional<AppUser> findById(int id) {
        AppUser appUser = entityManager.find(AppUser.class, id);
        return Optional.ofNullable(appUser);
    }

    @Override
    public List<AppUser> findAll() {
        return entityManager.createQuery("Select s from AppUser s").getResultList();
    }

    @Override
    @Transactional
    public void removeUser(AppUser appUser) {
        findById( appUser.getId() ).
        orElseThrow(  ObjectNotFoundExceptionMS::new );
        entityManager.remove(appUser);
    }

    @Override
    @Transactional
    public AppUser update(AppUser appUser) {
        return entityManager.merge(appUser);
    }

    @Override
    @Transactional
    public AppUser save(AppUser appUser) {
        entityManager.persist(appUser);
        return appUser;
    }
}
