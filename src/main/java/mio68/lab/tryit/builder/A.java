package mio68.lab.tryit.builder;

public abstract class A {

    private final int alphaReq; // Required field
    private final int alphaOpt;   // Optional field

    A(BuilderGen builder) {
        this.alphaReq = builder.alphaReq;
        this.alphaOpt = builder.alphaOpt;
    }

    public int getAlphaReq() {
        return alphaReq;
    }

    public int getAlphaOpt() {
        return alphaOpt;
    }

    protected abstract static class BuilderGen<T extends BuilderGen<T>> {
        protected int alphaReq;
        protected int alphaOpt = 0;

        public BuilderGen(int alphaReq) {
            this.alphaReq = alphaReq;
        }

        public T alphaOpt(int aOpt) {
            this.alphaOpt = aOpt;
            return getSelf();
        }

        protected abstract T getSelf();

        public abstract A build();
    }

}
