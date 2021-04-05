package learn.spring;

import org.apache.tomcat.util.scan.StandardJarScanner;
import org.eclipse.jetty.apache.jsp.JettyJasperInitializer;
import org.eclipse.jetty.jsp.JettyJspServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.util.component.AbstractLifeCycle;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class JspInitializer extends AbstractLifeCycle implements ServletContextHandler.ServletContainerInitializerCaller {
    final private ServletContextHandler handler;

    // This is an implementation of ServletContainerInitializer
    final private JettyJasperInitializer servletContainerInitializer;

    public JspInitializer(ServletContextHandler handler) {
        this.handler = handler;
        servletContainerInitializer = new JettyJasperInitializer();

        // I don't know what is this for (copy paste from GitHub)
        //handler.setAttribute("org.apache.tomcat.JarScanner", new StandardJarScanner());

        handler.setAttribute("javax.servlet.context.tempdir", new File("jsp-temp"));

        // JSP requires a non-system classloader
        var jspClassLoader = new URLClassLoader(new URL[0], this.getClass().getClassLoader());
        handler.setClassLoader(jspClassLoader);
    }

    @Override
    protected void doStart() throws Exception {
        registerJspServlet();

        // I don't know what is this for (copy paste from GitHub)
        //var classLoader = Thread.currentThread().getContextClassLoader();
        //Thread.currentThread().setContextClassLoader(handler.getClassLoader());

        try {
            servletContainerInitializer.onStartup(null, handler.getServletContext());
            super.doStart();
        } finally {
            // I don't know what is this for (copy paste from GitHub)
            //Thread.currentThread().setContextClassLoader(classLoader);
        }
    }

    private void registerJspServlet() {
        ServletHolder holderJsp = new ServletHolder("jsp", JettyJspServlet.class);

        // I don't know what is this for (copy paste from GitHub)
        // Need to dive deeper into the JSP topic and read some Jasper documentation
        holderJsp.setInitOrder(0);
        holderJsp.setInitParameter("logVerbosityLevel", "DEBUG");
        holderJsp.setInitParameter("fork", "false");
        holderJsp.setInitParameter("xpoweredBy", "false");
        holderJsp.setInitParameter("compilerTargetVM", "11");
        holderJsp.setInitParameter("compilerSourceVM", "11");
        holderJsp.setInitParameter("keepgenerated", "true");
        handler.addServlet(holderJsp, "*.jsp");
    }
}
