package mio68.lab.tryit.access.classinheritance;

// Public implementation of Service
public class ServiceImpl extends AbstractService {


    ServiceImpl(String name) {
        super(name);
    }

    @Override
    public String getId() {
      return "Id_" + getName();
    }
}
