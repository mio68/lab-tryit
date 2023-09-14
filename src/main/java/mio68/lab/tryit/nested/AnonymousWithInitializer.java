package mio68.lab.tryit.nested;

class Person {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class PersonService {
    public Person create(int id, String name) {
        return new Person() {{
            setId(id);
            setName(name);
        }};
    }
}

public class AnonymousWithInitializer {
    private static PersonService personService = new PersonService();

    public static void main(String[] args) {
        System.out.println(
                personService.create(12, "Ivan").getClass().getName()
        );
    }

}
