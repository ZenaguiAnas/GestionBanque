package com.gsb.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthentificationClientController {

    @GetMapping("/authentifierClientPage")
    public String showAuthentificationPage() {
        return "authentifierClient";
    }
}
