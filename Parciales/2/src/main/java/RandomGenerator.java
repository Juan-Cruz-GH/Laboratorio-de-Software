import java.util.Random;

@Generator
public class RandomGenerator {
    @SeedValueAttribute({98765, 98766, 98767, 98768})
    private long seed;

    public long getSeed() {
        return seed;
    }

    public void setSeed(long seed) {
        this.seed = seed;
    }

    public int randomGenerator() {
        Random generator = new Random(seed);
        int num = generator.nextInt(100);
        return num;
    }
}
