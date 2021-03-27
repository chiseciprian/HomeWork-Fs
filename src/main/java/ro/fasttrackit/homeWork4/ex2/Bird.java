package ro.fasttrackit.homeWork4.ex2;

sealed interface Bird extends Animal permits Canary, Parrot, Chicken {
    String fly();
}

record Canary() implements Bird {
    @Override
    public String fly() {
        return "I can fly";
    }

    @Override
    public String sound() {
        return "wru";
    }
}
