public class Controller {
    private Service service;

    public Controller() {
        System.out.println("Created prototype controller " + this + ".");
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        System.out.println("Service " + service + " is set.");
        this.service = service;
    }
}
