package ro.fasttrackit.homeWork4.ex2;

non-sealed interface Insects extends Animal {
    boolean annoyingPeople();
}

record Ladybug() implements Insects {
    @Override
    public boolean annoyingPeople() {
        return false;
    }

    @Override
    public String sound() {
        return "wrum";
    }
}
