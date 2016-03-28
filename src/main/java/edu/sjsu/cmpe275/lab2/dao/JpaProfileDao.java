package edu.sjsu.cmpe275.lab2.dao;

import edu.sjsu.cmpe275.lab2.domain.Profile;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by yutao on 3/26/16.
 */
@Repository
public class JpaProfileDao implements ProfileDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public Profile store(Profile profile) {
        return entityManager.merge(profile);
    }

    @Transactional
    @Override
    public Profile findById(Long id) {
        return entityManager.find(Profile.class, id);
    }

    @Transactional
    @Override
    public Profile delete(Long id) {
        Profile p = entityManager.find(Profile.class, id);
        entityManager.remove(p);
        return p;
    }
}
