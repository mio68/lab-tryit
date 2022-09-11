package mio68.lab.tryit.mix;

import mio68.lab.tryit.builder.B;
import mio68.lab.tryit.builder.C;

public class BuilderClient {

    public static void main(String[] args) {

        B b = C.builder(1, 2)
                .alphaOpt(10)
                .betaOpt(100)
                .build();

        C c = C.builder(1, 2, 3)
                .alphaOpt(10)
                .betaOpt(100)
                .gammaOpt(1000)
                .build();

        System.out.println(c.getAlphaReq());
        System.out.println(c.getAlphaOpt());
        System.out.println(c.getBetaReq());
        System.out.println(c.getBetaOpt());
        System.out.println(c.getGammaReq());
        System.out.println(c.getGammaOpt());

    }
}
