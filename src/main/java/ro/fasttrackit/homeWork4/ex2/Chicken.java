package ro.fasttrackit.homeWork4.ex2;

non-sealed class Chicken implements Bird {
    @Override
    public String fly() {
        return "I can fly too";
    }

    @Override
    public String sound() {
        return "cuc-rigu";
    }
}
