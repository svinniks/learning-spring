package learn.spring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    public Controller() {
        System.out.println("Controller created.");
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }
}
