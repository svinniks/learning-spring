package app;

public class SimpleController {
    public SimpleController(Service service) {
        System.out.println("Created prototype controller " + this + " with service " + service + ".");
    }

    public void init() {
        System.out.println("Initialized controller " + this + ".");
    }
}
