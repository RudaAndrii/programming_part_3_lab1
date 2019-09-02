package ua.lviv.iot;

import ua.lviv.iot.model.Lift;
import ua.lviv.iot.model.StatsTracker;
import ua.lviv.iot.services.impl.LiftSortingServiceImpl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class App
{
    public static void main(String[] args) {
        LiftSortingServiceImpl liftSortingService = new LiftSortingServiceImpl();
        List<Lift> lifts = getTestData();

        System.out.println("INSERTION SORT:");
        StatsTracker tracker = new StatsTracker();
        System.out.println(liftSortingService.insertionSort(lifts, Comparator.comparingInt(Lift::getLiftCapacity).reversed(), tracker));
        tracker.showStats();

        System.out.println("\n\nMERGE SORT:");
        tracker.init();
        System.out.println(liftSortingService.mergeSort(lifts, Comparator.comparingInt(Lift::getEnginePower), tracker));
        tracker.showStats();
    }

    private static List<Lift> getTestData() {
        List<Lift> lifts = new ArrayList<>();
        lifts.add(new Lift("Asana", 200, 700));
        lifts.add(new Lift("Asana", 300, 900));
        lifts.add(new Lift("Asana", 350, 200));
        lifts.add(new Lift("Asana", 400, 400));
        lifts.add(new Lift("Asana", 600, 250));
        lifts.add(new Lift("Asana", 650, 1200));
        lifts.add(new Lift("Asana", 700, 300));
        lifts.add(new Lift("Asana", 900, 800));
        return lifts;
    }
}
