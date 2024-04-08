package mio68.lab.tryit.dynproxy;

import lombok.extern.slf4j.Slf4j;
import mio68.lab.tryit.dynproxy.service.InvalidNameException;
import mio68.lab.tryit.dynproxy.service.MyService;
import mio68.lab.tryit.dynproxy.service.MyServiceImpl;

@Slf4j
public class Client {

    public static void main(String[] args) {

        MyService service = getMyService();
        request(service);

        MyService proxyToMyService = createMyServiceProxy(service);
        request(proxyToMyService);

    }

    public static void request(MyService service) {
        try {
            service.validateName("Noname");
        } catch (InvalidNameException e) {
            log.info("failed", e);
        }
        try {
            Integer rate = service.getRateByName("John Doe");
            log.info("Rate " + rate);
        } catch (InvalidNameException e) {
            log.info("failed", e);
        }
    }

    static MyService getMyService() {
        return new MyServiceImpl();
    }

    static MyService createMyServiceProxy(MyService target) {
        return (MyService) LoggerProxy.newInstance(target);
    }


}
