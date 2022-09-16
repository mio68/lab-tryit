package mio68.lab.tryit.mix;

public class ParameterNameIsString {

    public static void doIt(String String) { //1 String is parametr of type String
        int i = 10;
        i : for (int k = 0; k < 10; k++) { //2 i is a label
            System.out.println(String + i); //3 it's ok, it results "Hi 10"
            if (k * k > 10) continue i; //4 goto to label i
        }

    }

    public static void main(String[] args) {
        doIt("Hi ");
    }
}
