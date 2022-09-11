package mio68.lab.tryit.builder;

public class B extends A {

    private final int betaReq; // Required field
    private final int betaOpt; // Optional field

    B(BuilderGen builder) {
        super(builder);
        betaReq = builder.betaReq;
        betaOpt = builder.betaOpt;
    }

    public int getBetaReq() {
        return betaReq;
    }

    public int getBetaOpt() {
        return betaOpt;
    }

    public static Builder builder(int alphaReq, int betaReq) {
        return new Builder(alphaReq, betaReq);
    }

    static abstract class BuilderGen<T extends BuilderGen<T>> extends A.BuilderGen<T> {
        protected int betaReq;
        protected int betaOpt = 0;

        public BuilderGen(int alphaReq, int betaReq) {
            super(alphaReq);
            this.betaReq = betaReq;
        }

        public T betaOpt(int betaOpt) {
            this.betaOpt = betaOpt;
            return getSelf();
        }

    }

    public static class Builder extends BuilderGen<Builder> {

        protected Builder(int alphaReq, int betaReq) {
            super(alphaReq, betaReq);
        }

        @Override
        protected Builder getSelf() {
            return this;
        }

        @Override
        public B build() {
            return new B(this);
        }
    }

    public static void main(String[] args) {
        B b = B.builder(1, 2)
                .alphaOpt(10)
                .betaOpt(100)
                .build();

        System.out.println(b.getAlphaReq());
        System.out.println(b.getAlphaOpt());
        System.out.println(b.getBetaReq());
        System.out.println(b.getBetaOpt());
    }

}
