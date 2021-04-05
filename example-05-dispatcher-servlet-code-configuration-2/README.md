This example is similar to the example 04. The difference is that this one
uses AbstractAnnotationConfigDispatcherServletInitializer instead of WebApplicationInitializer.

AbstractAnnotationConfigDispatcherServletInitializer is a Spring built in implementation of WebApplicationInitializer.
It has three abstract methods to implement:

1. getRootConfigClasses
2. getServletConfigClasses
3. getServletMappings

The first two must return an array of Spring configuration classes to use for application context initialization.
The third method must return an array of servlet base URLs.

The following happens upon web application deployment to a Servlet 3.0 container:

1. Servlet container creates a new ServletContext for the application;
2. Servlet container discovers the SpringServletContainerInitializer (which is an implementation of ServletContainerInitializer),
using the Java's service loader feature;
3. Servlet container then scans classpath to discover all instances of Spring's WebApplicationInitializer, particularly -
the AbstractAnnotationConfigDispatcherServletInitializer. This scanning occurs due to the class SpringServletContainerInitializer
being annotated with @HandlesTypes({WebApplicationInitializer}).
4. Servlet container creates an instance of discovered SpringServletContainerInitializer and calls it's onStartup() method,
passing the set, containing the AbstractAnnotationConfigDispatcherServletInitializer class, and the newly created ServletContext.
5. The SpringServletContainerInitializer iterates over the received WebApplicationInitializer-s (particularly - AbstractAnnotationConfigDispatcherServletInitializer)
and calls their onStartup() method, further passing the ServletContext. The onStartup() method does the following:
    1. Calls onStartup() of AbstractContextLoaderInitializer (superclass of AbstractAnnotationConfigDispatcherServletInitializer),
    which creates a new Spring (root) ApplicationContext (AnnotationConfigWebApplicationContext), by calling the createRootApplicationContext() method,
    which is implemented in AbstractAnnotationConfigDispatcherServletInitializer. This method in turn retrieves an array of configuration classes
    by calling AbstractAnnotationConfigDispatcherServletInitializer.getRootConfigClasses().
    2. The same call of AbstractContextLoaderInitializer.onStartup() then creates a ContextLoaderListener, which is a servlet context
    event listener implementation, which Spring has specifically for initializing it's application contexts within the
    Servlet container. ContextLoaderListener saves reference to the root ApplicationContext within itself.
    3. The ContextLoaderListener instance is registered in the ServletContext and will receive servlet context events, when 
    the servlet container will proceed with context's lifecycle.
    4. Execution then continues in onStartup() in AbstractDispatcherServletInitializer (also a superclass of AbstractAnnotationConfigDispatcherServletInitializer),
    which first creates another AnnotationConfigWebApplicationContext, this time for the servlet, getting configuration classes
    from AbstractAnnotationConfigDispatcherServletInitializer.getServletConfigClasses().
    5. Now the DispatcherServlet is created. The second application context is passed to it (this is the context, which will contain the
    beans, such as Controllers). The two contexts (root and servlet) are not yet linked!
    6. Servlet is then registered in the servlet context.
6. So now there are two application contexts. They are __not refreshed__ yet. They are not linked through parent-child yet.
7. Now the servlet container initialized the servlet context. After doing this, is calls contextInitialized() event handler of the registered
ContextLoaderListener.
8. contextInitialized() then finally initialized the __root__ application contexts (scans for Spring annotations and refreshed the context, initializing the beans etc.)
9. contextInitialized() then registers an attribute WebApplicationContext.class.getName() + ".ROOT" in the ServletContext and stores there the initialized root context.
10. Now the servlet container initializes the DispatcherServlet by calling it's init() method.
11. DispatcherServlet now initializes and refreshes it's ApplicationContext. Then it locates the "root" application context, by
reading the attribute from the ServletContext and finally __links two application contexts as parent-child__.

Application is now ready to run.
All @Controller classes and their request mappings __from the servlet's application context__ are registered in the servlet. 
    
