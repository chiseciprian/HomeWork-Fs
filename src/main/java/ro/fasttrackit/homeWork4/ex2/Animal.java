package ro.fasttrackit.homeWork4.ex2;

sealed interface Animal permits Dog, Cat, Bird, Insects {
    String sound();
}

record Cat() implements Animal {
    @Override
    public String sound() {
        return "miau";
    }
}