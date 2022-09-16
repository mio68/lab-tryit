package mio68.lab.tryit.overloading;

public class OverloadingWithSameParamNumber {

    public void doIt(int i, int j) {
        System.out.println("doIt(int i, int j)");
    }

    public void doIt(long i, long j) {
        System.out.println("doIt(long i, long j)");
    }

    public void doIt(Integer i, Integer j) {
        System.out.println("doIt(Integer i, Integer j)");
    }

    public static void main(String[] args) {
        OverloadingWithSameParamNumber over = new OverloadingWithSameParamNumber();
        int i_int = 0, j_int = 0;
        long i_long = 0, j_long = 0;
        Integer i_Integer = 0, j_Integer = 0;

        // Simple cases.
        // The first phase (§15.12.2.2) performs overload resolution without permitting
        // boxing or unboxing conversion, or the use of variable arity method invocation.
        // they prints
//        doIt(int i, int j)
//        doIt(long i, long j)
//        doIt(Integer i, Integer j)
        over.doIt(i_int, j_int);
        over.doIt(i_long, j_long);
        over.doIt(i_Integer, j_Integer);

        over.doIt(i_int, j_long); // doIt(long i, long j)


        // The second phase (§15.12.2.3) performs overload resolution while
        // allowing boxing and unboxing, but still precludes the use of variable arity
        // method invocation.
        over.doIt(i_long, j_Integer); // doIt(long i, long j)
        over.doIt(i_Integer, j_long); // doIt(long i, long j)

        // Ambiguous! doIt(int , int) and doIt(Integer, Integer ) are both match!
//        over.doIt(i_int, i_Integer);


    }

}
