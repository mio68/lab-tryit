package mio68.lab.tryit.mix;

public record UserRecord(Integer id, String firstName, String lastName, int age) {

    public static void main(String[] args) {
        UserRecord user = new UserRecord(1, "John", "Doe", 21);
        System.out.println(user);

        System.out.println("user.id: " + user.id());
        System.out.println("user.firstName: " + user.firstName());
        System.out.println("user.lastName: " + user.lastName());
    }

}
