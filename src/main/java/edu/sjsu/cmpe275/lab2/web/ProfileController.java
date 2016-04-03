package edu.sjsu.cmpe275.lab2.web;

import edu.sjsu.cmpe275.lab2.domain.Profile;
import edu.sjsu.cmpe275.lab2.service.ProfileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 */
@Controller
@RequestMapping("/profile")
public class ProfileController {
    private static final Logger logger = LoggerFactory.getLogger(ProfileController.class);

    @Autowired
    private ProfileService profileService;

    /**
     * This returns an HTML that renders the given user’s profile. The profile fields are part of an HTML form
     * @param model
     * @param id
     * @param brief
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String showProfile(Model model,
                              @PathVariable String id,
                              @RequestParam(required = false) boolean brief) {
        logger.info("showProfile id: {}, brief: {}", id, brief);
        Profile profile = profileService.findById(id);
        if (profile == null) {
            model.addAttribute("userId", id);
            return "error";
        }
        model.addAttribute("profile", profile);
        model.addAttribute("readonly", true);
        return brief ? "viewProfileBrief" : "viewProfile";
    }

    /**
     * This returns an HTML form for input the info of profile
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String setupForm(Model model) {
        Profile profile = new Profile();
        model.addAttribute("profile", profile);
        return "setupForm";
    }

    /**
     * This request creates or update the profile for the given user ID.
     * @param model
     * @param id
     * @param firstname
     * @param lastname
     * @param email
     * @param address
     * @param organization
     * @param aboutMyself
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public String createOrUpdateProfile(Model model,
                                        @PathVariable String id,
                                        @RequestParam String firstname,
                                        @RequestParam String lastname,
                                        @RequestParam String email,
                                        @RequestParam String address,
                                        @RequestParam String organization,
                                        @RequestParam String aboutMyself) {

        Profile profile = new Profile(id, firstname, lastname, email, address, organization, aboutMyself);
//        for (int i = 0; i < 20; i++) {
//            Profile p = new Profile(String.valueOf(i), "test", "test", "email", "address", "org", "about");
//            profileService.store(p);
//        }
        profile = profileService.store(profile);
        return "redirect:/profile/{id}";
    }

    /**
     * This request deletes the profile for the given user ID.
     * @param model
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String delete(Model model, @PathVariable String id) {
        Profile profile = null;
        try {
            profile = profileService.delete(id);
        } catch (Exception e) {
            model.addAttribute("userId", id);
            return "error";
        }
        model.addAttribute("profile", profile);
        model.addAttribute("readonly", true);
        return "setupForm";
    }

}
