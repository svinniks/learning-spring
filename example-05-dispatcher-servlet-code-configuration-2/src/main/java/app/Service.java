package app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Service {
    final private ApplicationContext context;

    @Autowired
    public Service(ApplicationContext context) {
        this.context = context;
    }
}
