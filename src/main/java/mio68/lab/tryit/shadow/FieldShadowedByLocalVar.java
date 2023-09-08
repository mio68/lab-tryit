package mio68.lab.tryit.shadow;

public class FieldShadowedByLocalVar {
    private int field = 10;

    private void m() {
        int field = 1;
        System.out.println("local field: " + field);
        System.out.println("instance field: " + this.field);
        {
            int i = 0;
//            int field = 100; // impossible
        }
    }

    public static void main(String[] args) {
        FieldShadowedByLocalVar fieldShadowedByLocalVar = new FieldShadowedByLocalVar();
        fieldShadowedByLocalVar.m();
    }

}
