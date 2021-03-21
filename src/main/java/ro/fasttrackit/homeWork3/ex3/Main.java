package ro.fasttrackit.homeWork3.ex3;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Gym gym = new Gym(List.of(
                new Subscription(new GymMember("Jane", LocalDate.of(1998, 10, 10))),
                new Subscription(new GymMember("Ion", LocalDate.of(1998, 10, 10))),
                new Subscription(new GymMember("Vasile", LocalDate.of(1998, 10, 10))),
                new Subscription(new GymMember("Dow", LocalDate.of(2001, 10, 10)))));
        System.out.println(gym.ageAverageOfMembers());
        System.out.println(gym.maxAgeOfMembers());
        System.out.println(gym.minAgeOfMembers());
        gym.addTimeToSubscription("Jane", Duration.ofHours(10));
        gym.registerTimeSpent("Jane", Duration.ofHours(30));
        System.out.println(gym.totalSubscriptionTime());
        System.out.println(gym);
        System.out.println(gym.findSubscriptionByName("Jane"));
        SubscriptionReportGenerator reportGenerator = new SubscriptionReportGenerator();
        reportGenerator.generateReport("remaining-time-report-"+LocalDate.now().toString()+".txt", gym.getSubscriptions());
    }
}
