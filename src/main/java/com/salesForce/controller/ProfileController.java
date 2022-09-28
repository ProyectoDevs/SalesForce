package com.salesForce.controller;

import com.salesForce.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/")
public class ProfileController {

    @Autowired
    ProfileService profileService;

    @GetMapping ("/usuarios/delete-profile/{id_profile}")
    public RedirectView deleteProfile (@PathVariable("id_profile") Long id){
        profileService.deleteProfile(id);
        return new RedirectView ("/usuarios");
    }

}
