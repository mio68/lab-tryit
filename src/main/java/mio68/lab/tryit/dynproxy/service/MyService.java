package mio68.lab.tryit.dynproxy.service;

public interface MyService {

    void validateName(String name) throws InvalidNameException;

    Integer getRateByName(String name) throws InvalidNameException;

}
