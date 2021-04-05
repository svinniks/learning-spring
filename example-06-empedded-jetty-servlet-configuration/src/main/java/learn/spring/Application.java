package learn.spring;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.springframework.web.SpringServletContainerInitializer;

import java.util.Set;

public class Application {
    public static void main(String[] args) throws Exception {
        var server = new Server(9020);
        var handler = new ServletContextHandler();

        // The following code has been discovered by me after reading/debugging
        // Jetty source code. ServletContextHandler.Initializer is a special
        // wrapper for ServletContainerInitializer.
        // An instance of Initializer can be manually added as a "bean"
        // to the ServletContextHandler together with the initializer classes.
        // When using WebAppContext instead of ServletContextHandler,
        // it will discover SpringServletContainerInitializer automatically,
        // using the service loader feature and @HandlesTypes annotation.
        var initializer = new ServletContextHandler.Initializer(
                handler,
                new SpringServletContainerInitializer(),
                Set.of(ApplicationInitializer.class)
        );

        handler.addBean(initializer);
        server.setHandler(handler);
        server.start();
        server.join();
    }
}
