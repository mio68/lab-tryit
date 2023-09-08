package mio68.lab.tryit.puzzlers.puzzle66;

/*
  Hiding occurs when you declare a field, a static method, or a nested type, whose name
  is identical to an accessible field, method, or type, respectively in a superclass.
  Avoid it!!!

  Example below shows field hiding, that violates Liskov Substitution Principle!
  It's not possible to use Derived instead of Base!
  System.out.println(new Base().className); - ok!
  but
  System.out.println(new Derived().className); not compiled at all!
  So Derived is not a subtype of Base.
 */
class Base {
    public String className = "Base";
}

class Derived extends Base {
    private String className = "Derived";

    public void printClassNameOfBase() {
        System.out.println(super.className);
        System.out.println(((Base)this).className);
    }
}

public class PrivateMatter {
    public static void main(String[] args) {
        //Compilation error
        // java: className has private access in mio68.lab.tryit.puzzlers.puzzle66.Derived
        //System.out.println(new Derived().className);
        System.out.println(((Base)new Derived()).className); // Just OK
        new Derived().printClassNameOfBase();
    }
}
