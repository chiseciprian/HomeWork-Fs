package ro.fasttrackit.homeWork3.ex3;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Gym {
    private final List<Subscription> subscriptions;

    public Gym(List<Subscription> subscriptions) {
        this.subscriptions = new ArrayList<>(subscriptions);
    }


    public List<Subscription> getSubscriptions() {
        return new ArrayList<>(subscriptions);
    }

    public double ageAverageOfMembers() {
        return subscriptions.stream()
                .mapToDouble(sub -> getAge(sub.getMember().getBirthdate()))
                .average()
                .orElse(0);
    }

    public int maxAgeOfMembers() {
        return subscriptions.stream()
                .mapToInt(sub -> getAge(sub.getMember().getBirthdate()))
                .max()
                .orElse(0);
    }

    public int minAgeOfMembers() {
        return subscriptions.stream()
                .mapToInt(sub -> getAge(sub.getMember().getBirthdate()))
                .min()
                .orElse(0);
    }

    public long totalSubscriptionTime() {
        return subscriptions.stream()
                .mapToLong(sub -> sub.getSubscriptionEnd().toHours())
                .sum();
    }

    public void addTimeToSubscription(String name, Duration duration) {
        Subscription subscription = findSubscriptionByName(name);
        Duration addedTime = subscription.getSubscriptionEnd().plus(duration);
        subscription.setSubscriptionEnd(addedTime);
    }

    public void registerTimeSpent(String name, Duration timeSpent) {
        Subscription subscription = findSubscriptionByName(name);
        Duration currentTime = subscription.getSubscriptionEnd().minus(timeSpent);
        subscription.setSubscriptionEnd(currentTime);
    }

    private int getAge(LocalDate birthday) {
        return Period.between(birthday, LocalDate.now()).getYears();
    }

    public Subscription findSubscriptionByName(String name) {
        return subscriptions.stream()
                .filter(sub -> sub.getMember().getName().equals(name))
                .findFirst()
                .orElse(new Subscription());
    }

    @Override
    public String toString() {
        return "Gym{" +
                "subscriptions=" + subscriptions +
                '}';
    }
}
