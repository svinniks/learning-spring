This example demonstrates a classic (Servlet 2.0+) approach
to registering servlets via the web.xml file.

1. Application must be either deployed to a servlet container (say, Tomcat)
or run using Idea with some installed servlet container.
2. web.xml defines DispatcherServlet and passes an init-param to it, which
contains the path to the WebApplicationContext XML configuration file.
3. There is a Controller, which serves a single GET endpoint /hello which returns Hello, World! 
