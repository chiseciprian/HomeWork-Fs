package ro.fasttrackit.homeWork3.ex3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SubscriptionReportGenerator {

    public void generateReport(String outputFile, List<Subscription> subscriptions) throws IOException {

        Map<TimeCategory, List<Subscription>> subscriptionGrouped = subscriptions.stream()
                .collect(Collectors.groupingBy(Subscription::getTimeCategory));
        writeReport(subscriptionGrouped, outputFile);
    }

    private void writeReport(Map<TimeCategory, List<Subscription>> subscription, String outputFile) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            subscription.forEach((timeCategory, sub) -> {
                try {
                    printByType(writer, sub, timeCategory);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    private void printByType(BufferedWriter writer, List<Subscription> subscription, TimeCategory timeCategory) throws IOException {
        writeInLine(writer, timeCategory + ": ");
        subscription.stream()
                .map(sub -> sub.getMember().getName() + ",")
                .forEach(line -> writeInLine(writer, line));
        writer.newLine();
    }

    private void writeInLine(BufferedWriter writer, String line) {
        try {
            writer.write(line);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
