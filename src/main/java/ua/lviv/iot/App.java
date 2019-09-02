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

        List<Lift> lifts = new ArrayList<>();
        lifts.add(new Lift("Asana", 200, 700));
        lifts.add(new Lift("Asana", 300, 200));
        lifts.add(new Lift("Asana", 350, 200));
        lifts.add(new Lift("Asana", 400, 200));
        lifts.add(new Lift("Asana", 600, 300));
        lifts.add(new Lift("Asana", 650, 300));
        lifts.add(new Lift("Asana", 700, 300));
        lifts.add(new Lift("Asana", 900, 900));

        System.out.println("INSERTION SORT:");
        StatsTracker tracker = new StatsTracker();
        System.out.println(liftSortingService.insertionSort(lifts, Comparator.comparingInt(Lift::getLiftCapacity).reversed(), tracker));
        tracker.showStats();

        System.out.println("\n\nMERGE SORT:");
        tracker.init();
        System.out.println(liftSortingService.mergeSort(lifts, Comparator.comparingInt(Lift::getEnginePower), tracker));
        tracker.showStats();
    }
}
