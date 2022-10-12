package mio68.lab.tryit.classes;

public class ClassInfo {

    public static void main(String[] args) {
        ClassInfo classInfo = new ClassInfo();

        System.out.println(classInfo.getClass());
        System.out.println(classInfo.getClass().getName());
        System.out.println(classInfo.getClass().getSimpleName());
    }
}
