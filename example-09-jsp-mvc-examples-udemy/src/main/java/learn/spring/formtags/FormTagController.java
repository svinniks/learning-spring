package learn.spring.formtags;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

@Controller
@RequestMapping("/form-tags")
public class FormTagController {
    final private static Map<String, String> LANGUAGES;

    static {
        LANGUAGES = new LinkedHashMap<>();
        LANGUAGES.put("LAT", "Latvian");
        LANGUAGES.put("LIT", "Lithuanian");
        LANGUAGES.put("EST", "Estonian");
        LANGUAGES.put("ENG", "English");
    }

    final private Properties genders;

    @Autowired
    public FormTagController(
            @Qualifier("genders")
            Properties genders
    ) {
        this.genders = genders;
    }

    @GetMapping("/example1")
    public String example1ShowForm(Model model) {
        model.addAttribute("genders", genders);
        model.addAttribute("languages", LANGUAGES);
        model.addAttribute("person", new Person("Sergejs", "Vinniks"));
        return "form-tags/example1-form";
    }

    // @ModelAttribute is used to bind request param
    @PostMapping("/example1")
    public String example1ProcessForm(@ModelAttribute Person person) {
        return "form-tags/example1-processed-form";
    }
}
