import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
        // After creating, the context will create ONLY singleton beans.
        try (var context = new ClassPathXmlApplicationContext("applicationContext.xml")) {
            // Requesting a controller bean will always create a new instance (since it is prototype scoped)
            context.getBean("controller");
            context.getBean("controller");
        }
    }
}
