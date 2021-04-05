package app;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan
@PropertySource("classpath:application.properties")
public class ApplicationConfiguration {
    @Bean(name = "controller", initMethod = "init")
    @Scope("prototype")
    SimpleController getController(Service service) {
        return new SimpleController(service);
    }
}
