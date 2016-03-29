package edu.sjsu.cmpe275.lab2.service;

import edu.sjsu.cmpe275.lab2.dao.ProfileDao;
import edu.sjsu.cmpe275.lab2.domain.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yutao on 3/24/16.
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
    public Profile findById(Long id) {
        return profileDao.findById(id);
    }

    @Override
    public Profile delete(Long id) {
        return profileDao.delete(id);
    }
}
