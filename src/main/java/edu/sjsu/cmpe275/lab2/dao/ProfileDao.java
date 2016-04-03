package edu.sjsu.cmpe275.lab2.dao;

import edu.sjsu.cmpe275.lab2.domain.Profile;

/**
 */
public interface ProfileDao {
    public Profile store(Profile profile);

    public Profile findById(String id);

    public Profile delete(String id);
}
