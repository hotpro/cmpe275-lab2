package edu.sjsu.cmpe275.lab2.service;

import edu.sjsu.cmpe275.lab2.dao.ProfileDao;
import edu.sjsu.cmpe275.lab2.domain.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 */
@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    private ProfileDao profileDao;

    @Override
    public Profile store(Profile profile) {
        return profileDao.store(profile);
    }

    @Override
    public Profile findById(String id) {
        return profileDao.findById(id);
    }

    @Override
    public Profile delete(String id) {
        return profileDao.delete(id);
    }
}
