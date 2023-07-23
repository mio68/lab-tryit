package mio68.lab.tryit.access.classinheritance;

// This class is designed for this package only!
abstract class AbstractService implements Service {

    private final String name;


    AbstractService(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
