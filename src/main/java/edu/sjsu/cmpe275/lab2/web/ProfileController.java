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
        if (profile == null) {
            model.addAttribute("userId", id);
            return "error";
        }
        model.addAttribute("profile", profile);
        model.addAttribute("readonly", true);
        return brief ? "viewProfileBrief" : "viewProfile";
    }

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.DELETE})
    public String setupForm(Model model) {
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
                                        @RequestParam String aboutMyself) {

        Profile profile = new Profile(id, firstname, lastname, email, address, organization, aboutMyself);
        for (int i = 0; i < 20; i++) {
            Profile p = new Profile(String.valueOf(i), "test", "test", "email", "address", "org", "about");
            profileService.store(p);
        }
        profile = profileService.store(profile);
//        model.addAttribute("profile", profile);
//        model.addAttribute("readonly", true);
        return "redirect:/profile/{id}";
    }

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
