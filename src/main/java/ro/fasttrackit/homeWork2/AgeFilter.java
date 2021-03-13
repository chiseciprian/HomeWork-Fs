package ro.fasttrackit.homeWork2;

public enum AgeFilter {
    FIRST_TARGET(1, 30),
    SECOND_TARGET(30, 50),
    THIRD_TARGET(50, 999);

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
