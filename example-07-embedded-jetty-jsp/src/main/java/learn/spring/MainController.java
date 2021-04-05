package learn.spring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    // If a request mapping returns a string, it is treated as "view name"
    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }
}
