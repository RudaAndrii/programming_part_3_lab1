package ua.lviv.iot.model;

import lombok.Getter;
import lombok.Setter;

import java.time.Duration;
import java.time.LocalTime;

@Getter
@Setter
public class StatsTracker {
    public int comparisionCount;
    public int exchangeCount;
    public LocalTime timeStart;

    public StatsTracker() {
        comparisionCount = 0;
        exchangeCount = 0;
        timeStart = LocalTime.now();
    }

    public void init() {
        comparisionCount = 0;
        exchangeCount = 0;
        timeStart = LocalTime.now();
    }

    public void showStats() {
        System.out.println("Executing time: " + Duration.between(timeStart, LocalTime.now()).toMillis());
        System.out.println("Comparisons: " + comparisionCount);
        System.out.println("Exchanges: " + exchangeCount);
    }
} 