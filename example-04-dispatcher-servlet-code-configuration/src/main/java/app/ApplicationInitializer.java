package app;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

// This class will be automatically discovered by a Servlet 3.0 environment.
public class ApplicationInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        // Usually at least 2 contexts should be created - the ROOT context for shared beans
        // And another context for the DispatcherServlet (this may contain @EnableWebMvc).
        // This example uses single (root) context for both application and servlet.
        var rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(ApplicationConfiguration.class);

        // Manage the lifecycle of the root application context
        servletContext.addListener(new ContextLoaderListener(rootContext));

        // Register and map the dispatcher servlet
        var dispatcherRegistration = servletContext.addServlet("dispatcher", new DispatcherServlet(rootContext));
        dispatcherRegistration.setLoadOnStartup(1);
        dispatcherRegistration.addMapping("/");
    }
}
