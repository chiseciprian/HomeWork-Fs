package ro.fasttrackit.homeWork4.ex2;

public class Fly implements Insects {
    @Override
    public boolean annoyingPeople() {
        return true;
    }

    @Override
    public String sound() {
        return "bzz";
    }
}
