package edu.sjsu.cmpe275.lab2.web;

import edu.sjsu.cmpe275.lab2.dao.ProfileDao;
import edu.sjsu.cmpe275.lab2.domain.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by yutao on 3/23/16.
 */
@Controller
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private ProfileDao profileDao;

    @RequestMapping(method = RequestMethod.GET)
    public String hello() {
        if (profileDao == null) {
            return "xx";
        }
        Profile profile = new Profile(1L, "test", "test", "email", "address", "org", "about");
        profile = profileDao.store(profile);
        return "profile";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public String delete(Model model, @PathVariable Long id) {
        Profile p = profileDao.delete(id);
        return "profile";
    }
}
