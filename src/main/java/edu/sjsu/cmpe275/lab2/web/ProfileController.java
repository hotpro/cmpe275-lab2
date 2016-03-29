package edu.sjsu.cmpe275.lab2.web;

import edu.sjsu.cmpe275.lab2.domain.Profile;
import edu.sjsu.cmpe275.lab2.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by yutao on 3/23/16.
 */
@Controller
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String showProfile(Model model,
                              @PathVariable String id,
                              @RequestParam(required = false) boolean brief) {
        Profile profile = profileService.findById(id);
        model.addAttribute("profile", profile);
        return "viewProfile";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String setupForm(Model model) {
//        Profile profile = new Profile(1L, "test", "test", "email", "address", "org", "about");
//        profile = profileService.store(profile);
        Profile profile = new Profile();
        model.addAttribute("profile", profile);
        return "setupForm";
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public String createOrUpdateProfile(Model model,
                                        @PathVariable String id,
                                        @RequestParam String firstname,
                                        @RequestParam String lastname,
                                        @RequestParam String email,
                                        @RequestParam String address,
                                        @RequestParam String organization,
                                        @RequestParam String aboutmyself) {

        Profile profile = new Profile(id, firstname, lastname, email, address, organization, aboutmyself);
        profile = profileService.store(profile);
        model.addAttribute("profile", profile);
        return "viewProfile";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String delete(Model model, @PathVariable String id) {
        Profile profile = profileService.delete(id);
        return "viewProfile";
    }

}
