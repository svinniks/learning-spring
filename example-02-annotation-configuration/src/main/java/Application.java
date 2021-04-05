import app.ApplicationConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        // This will create a context and scall for all bean annotations in the app package
        try (var context = new AnnotationConfigApplicationContext("app")) {
            context.getBean("controller");
            context.getBean("controller");
        }

        // This will create a context and use ApplicationConfiguration as a configuration class
        // There must be @ComponentScan in it to obtain the Service bean
        try (var context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class)) {
            context.getBean("controller");
            context.getBean("controller");
        }

        // This will create an empty context, which has to be registered with configuration classes and refreshed
        try (var context = new AnnotationConfigApplicationContext()) {
            context.register(ApplicationConfiguration.class);
            context.refresh();

            context.getBean("controller");
            context.getBean("controller");
        }
    }
}
