package mio68.lab.tryit.builder;

public class C extends B {

    private final int gammaReq;
    private final int gammaOpt;

    C(BuilderGen<?> builder) {
        super(builder);
        this.gammaReq = builder.gammaReq;
        this.gammaOpt = builder.gammaOpt;
    }

    public int getGammaReq() {
        return gammaReq;
    }

    public int getGammaOpt() {
        return gammaOpt;
    }

    protected static abstract class BuilderGen<T extends BuilderGen<T>> extends B.BuilderGen<T> {
        protected int gammaReq;
        protected int gammaOpt = 0;

        public BuilderGen(int alphaReq, int betaReq, int gammaReq) {
            super(alphaReq, betaReq);
            this.gammaReq = gammaReq;
        }

        public T gammaOpt(int gammaOpt) {
            this.gammaOpt = gammaOpt;
            return getSelf();
        }

    }

    public static Builder builder(int alphaReq, int betaReq, int gammaReq) {
        return new Builder(alphaReq, betaReq, gammaReq);
    }

    public static class Builder extends BuilderGen<Builder> {

        protected Builder(int alphaReq, int betaReq, int gammaReq) {
            super(alphaReq, betaReq, gammaReq);
        }

        @Override
        protected Builder getSelf() {
            return this;
        }

        @Override
        public C build() {
            return new C(this);
        }
    }

    public static void main(String[] args) {

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

