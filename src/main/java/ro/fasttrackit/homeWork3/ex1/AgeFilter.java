package ro.fasttrackit.homeWork3.ex1;

public enum AgeFilter {
    FIRST_TARGET(0, 30),
    SECOND_TARGET(31, 50),
    THIRD_TARGET(51, 999);

    private int minAge;
    private int maxAge;
    AgeFilter(int minAge, int maxAge) {
        this.minAge = minAge;
        this.maxAge = maxAge;
    }

    public int getMinAge() {
        return minAge;
    }

    public int getMaxAge() {
        return maxAge;
    }
}
