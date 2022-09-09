package mio68.lab.tryit.functions;

import java.util.function.Function;



public class IdentityFunction {


    public static void main(String[] args) {

        Function<Integer, Integer> f = getIdentityFunction();

        f = i -> i;

        f = (Integer i) -> i;

        f = (Integer i) -> {
            return i;
        };

        f = new Function<>() {
            @Override
            public Integer apply(Integer integer) {
                return integer * 2;
            }
        };

        f = getIdentityFunctionWithLambda();

    }

    public static Function<Integer, Integer> getIdentityFunction() {
        return Function.identity();
    }

    public static Function<Integer, Integer> getIdentityFunctionWithLambda() {
        return i -> i;
    }


}
