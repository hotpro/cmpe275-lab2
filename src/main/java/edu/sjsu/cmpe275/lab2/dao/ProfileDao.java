package edu.sjsu.cmpe275.lab2.dao;

import edu.sjsu.cmpe275.lab2.domain.Profile;

import java.util.List;

/**
 * Created by yutao on 3/23/16.
 */
public interface ProfileDao {
    public Profile insert(Profile profile);

    public Profile find(int id);

    public List<Profile> findAll();

    public Profile update(Profile profile);

    public Profile delete(Profile profile);
}
