This example demonstrates:

1. ClassPathXMLApplicationContext, which creates a ben container based on a configuration XML file.
2. All bean classes are defined and wired in the XML configuration file.
3. Singleton (default) and prototype scope bean creation (via context.getBean() as well).
4. Adding .properties file and injecting a property value into a bean.
5. Injecting via a constructor argument and a bean property (setter)