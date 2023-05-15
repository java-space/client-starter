package za.co.javaspace.developerstarter.controller;

import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnJava;
import org.springframework.boot.system.JavaVersion;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import za.co.javaspace.developerstarter.model.DeveloperDetails;
import za.co.javaspace.developerstarter.service.DeveloperService;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("v1")
@ConditionalOnJava(value = JavaVersion.SEVENTEEN, range = ConditionalOnJava.Range.EQUAL_OR_NEWER)
public class DeveloperDetailsController {

    private DeveloperService developerService;

    @GetMapping("home")
    public String home() {
        return WebPage.HOME.getPageName();
    }

    @GetMapping("developer")
    public String developerDetails(Model model) {
        model.addAttribute("developerService", developerService);
        return WebPage.DEVELOPER.getPageName();
    }

    @GetMapping("developers")
    public String developersDetails(Model model) {
        final DeveloperDetails developerDetails = new DeveloperDetails();
        developerDetails.setName("JavaSpace");
        developerDetails.setLanguage("Java");
        developerDetails.setExperience("3 Yrs");
        model.addAttribute("developers", List.of(developerDetails));
        return WebPage.DEVELOPERS.getPageName();
    }
}
