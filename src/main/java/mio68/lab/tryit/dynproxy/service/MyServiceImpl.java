package mio68.lab.tryit.dynproxy.service;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyServiceImpl implements MyService {
    @Override
    public void validateName(String name) throws InvalidNameException {
        log.info("MyServiceImpl validate name: " + name);
        if (!"John Doe".equals(name)) {
            throw new InvalidNameException();
        }
    }

    @Override
    public Integer getRateByName(String name) throws InvalidNameException {
        log.info("MyServiceImpl get rate by name: " + name);
        validateName(name);
        return 42;
    }
}
