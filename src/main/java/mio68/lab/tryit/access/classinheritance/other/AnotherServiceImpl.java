package mio68.lab.tryit.access.classinheritance.other;

// Not possible!
//import mio68.lab.tryit.access.classinheritance.AbstractService;

import mio68.lab.tryit.access.classinheritance.Service;

//Not possible
//public class AnotherServiceImpl extends AbstractService {
// just implement public interface
public class AnotherServiceImpl implements Service {


    @Override
    public String getId() {
        return "default_id";
    }
}
