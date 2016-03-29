package edu.sjsu.cmpe275.lab2.service;

import edu.sjsu.cmpe275.lab2.domain.Profile;

/**
 * Created by yutao on 3/23/16.
 */
public interface ProfileService {

    public Profile store(Profile profile);

    public Profile findById(Long id);

    public Profile delete(Long id);

}
