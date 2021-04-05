package learn.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/example4") // This prefix will be added to all mappings to the methods!
public class RequestMappingController {
    @GetMapping("/hello")
    public String hello() {
        return "example4";
    }
}
