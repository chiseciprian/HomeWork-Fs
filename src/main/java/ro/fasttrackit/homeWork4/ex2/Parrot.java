package ro.fasttrackit.homeWork4.ex2;

final class Parrot implements Bird {
    @Override
    public String fly() {
        return "I can fly";
    }

    @Override
    public String sound() {
        return "cip-chop";
    }
}
