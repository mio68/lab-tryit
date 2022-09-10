package mio68.lab.tryit.mix;

public class NutritionFactsWithBuilder {

    private final int servingSize;  // required
    private final int servings;     // required
    private final int calories;     // optional
    private final int fat;          // optional
    private final int sodium;       // optional
    private final int carbohydrate; // optional

    private NutritionFactsWithBuilder(Builder builder) {
        this.servingSize = builder.servingSize;
        this.servings = builder.servings;
        this.calories = builder.calories;
        this.fat = builder.fat;
        this.sodium = builder.sodium;
        this.carbohydrate = builder.carbohydrate;
    }

    public static Builder builder(int servingSize, int servings) {
        return new Builder(servingSize, servings);
    }

    private void privateMethodOfOuterClass() {
        System.out.println("I'm private method.");
    }

    public static class Builder {
        private final int servingSize;  // required
        private final int servings;     // required
        private int calories = 0;     // optional
        private int fat = 0;          // optional
        private int sodium = 0;       // optional
        private int carbohydrate = 0; // optional

        private Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder calories(int calories) {
            this.calories = calories;
            return this;
        }

        public Builder fat(int fat) {
            this.fat = fat;
            return this;
        }

        public Builder sodium(int sodium) {
            this.sodium = sodium;
            return this;
        }

        public Builder carbohydrate(int carbohydrate) {
            this.carbohydrate = carbohydrate;
            return this;
        }

        public NutritionFactsWithBuilder build() {
            return new NutritionFactsWithBuilder(this);
        }

        public void accessToPrivateMembersOfOuterClass(NutritionFactsWithBuilder nf) {
            int calories = nf.calories; // No problem!
            nf.privateMethodOfOuterClass(); // No problem again!
        }
    }

    public static void main(String[] args) {
        NutritionFactsWithBuilder nutritionFacts =
                NutritionFactsWithBuilder.builder(2, 4)
                        .calories(380)
                        .fat(100)
                        .build();

    }

}
