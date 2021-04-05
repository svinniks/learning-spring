package app;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component()
public class Service implements InitializingBean, DisposableBean {
    public Service(@Value("${server.port}") int port) {
        System.out.println("Singleton service " + this + " created with port " + port + "!");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Destroying service bean...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Initialized service bean.");
    }
}
