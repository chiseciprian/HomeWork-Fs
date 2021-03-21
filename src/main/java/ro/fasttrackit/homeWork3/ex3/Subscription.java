package ro.fasttrackit.homeWork3.ex3;

import java.time.Duration;
import java.util.Objects;

public class Subscription {
    private GymMember member;
    private Duration subscriptionEnd;
    private TimeCategory timeCategory;

    public Subscription() {
    }

    public Subscription(GymMember member) {
        this.member = member;
        this.subscriptionEnd = Duration.ofHours(30);
        setTimeCategory();
    }

    public TimeCategory getTimeCategory() {
        return timeCategory;
    }

    public GymMember getMember() {
        return member;
    }

    public Duration getSubscriptionEnd() {
        return subscriptionEnd;
    }

    public void setSubscriptionEnd(Duration subscriptionEnd) {
        this.subscriptionEnd = subscriptionEnd;
        setTimeCategory();
    }

    private void setTimeCategory() {
        if (subscriptionEnd.toHours() < 10) {
            this.timeCategory = TimeCategory.RED;
        } else if (subscriptionEnd.toHours() < 30) {
            this.timeCategory = TimeCategory.YELLOW;
        } else {
            this.timeCategory = TimeCategory.GREEN;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subscription that = (Subscription) o;
        return Objects.equals(member, that.member) && Objects.equals(subscriptionEnd, that.subscriptionEnd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(member, subscriptionEnd);
    }

    @Override
    public String toString() {
        return "Subscription{" +
                "member=" + member +
                ", time=" + subscriptionEnd +
                '}';
    }
}
