package edu.sjsu.cmpe275.lab2.dao;

import edu.sjsu.cmpe275.lab2.domain.Profile;

/**
 */
public interface ProfileDao {
    /**
     * create profile, or update profile if the profile.id exists.
     * @param profile
     * @return
     */
    public Profile store(Profile profile);

    /**
     * find profile by id
     * @param id
     * @return
     */
    public Profile findById(String id);

    /**
     * delete profile by id
     * @param id
     * @return
     */
    public Profile delete(String id);
}
