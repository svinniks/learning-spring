package web;

import app.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    final private Service service;
    final private ApplicationContext context;

    @Autowired
    public Controller(Service service, ApplicationContext context) {
        this.service = service;
        this.context = context;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }
}
