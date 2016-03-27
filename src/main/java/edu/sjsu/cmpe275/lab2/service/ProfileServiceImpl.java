package edu.sjsu.cmpe275.lab2.service;

import edu.sjsu.cmpe275.lab2.dao.ProfileDao;

/**
 * Created by yutao on 3/24/16.
 */
public class ProfileServiceImpl implements ProfileService {

    private ProfileDao profileDao;

    public ProfileServiceImpl() {

    }

    public ProfileServiceImpl(ProfileDao profileDao) {
        this.profileDao = profileDao;
    }

}
