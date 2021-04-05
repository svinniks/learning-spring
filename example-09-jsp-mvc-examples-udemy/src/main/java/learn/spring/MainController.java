package learn.spring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    // This will just display a form with one input
    @GetMapping("/example1")
    public String example1ShowForm() {
        return "example1-form";
    }

    // This will forward form data to the view
    @PostMapping("/example1")
    public String example1ProcessForm() {
        return "example1-processed-form";
    }

    // This will just display a form with one input
    @GetMapping("/example2")
    public String example2ShowForm() {
        return "example2-form";
    }

    // This will bind method param to the form input
    // and create a model attribute "uppercaseName"
    // which in turn will be displayed in the view
    @PostMapping("/example2")
    public String example2ProcessForm(@RequestParam String name, Model model) {
        model.addAttribute("uppercaseName", name.toUpperCase());
        return "example2-processed-form";
    }

    @GetMapping("/example3")
    public String example3() {
        return "example3";
    }
}
