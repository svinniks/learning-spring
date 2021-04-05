package learn.spring;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.springframework.web.SpringServletContainerInitializer;

import java.util.Set;

public class Application {
    public static void main(String[] args) throws Exception {
        var server = new Server(9020);
        var handler = new ServletContextHandler(ServletContextHandler.SESSIONS);

        var applicationInitializer = new ServletContextHandler.Initializer(
                handler,
                new SpringServletContainerInitializer(),
                Set.of(ApplicationInitializer.class)
        );

        var jspInitializer = new JspInitializer(handler);

        handler.setResourceBase(Application.class.getResource("/").toURI().toASCIIString());
        handler.addBean(applicationInitializer);
        handler.addBean(jspInitializer);
        server.setHandler(handler);
        server.start();
        server.join();
    }
}
