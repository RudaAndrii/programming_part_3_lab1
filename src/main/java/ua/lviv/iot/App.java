package ua.lviv.iot;

import ua.lviv.iot.model.Lift;
import ua.lviv.iot.services.impl.LiftSortingServiceImpl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class App
{

    private static class LiftCapacityComparator implements Comparator<Lift> {
        @Override
        public int compare(Lift o1, Lift o2) {
            return o1.getLiftCapacity() - o2.getLiftCapacity();
        }
    }

    private static class LiftEnginePowerComparator implements Comparator<Lift> {
        @Override
        public int compare(Lift o1, Lift o2) {
            return o1.getEnginePower() - o2.getEnginePower();
        }
    }

    public static void main( String[] args )
    {
        LiftCapacityComparator capacityComparator = new LiftCapacityComparator();
        LiftEnginePowerComparator enginePowerComparator = new LiftEnginePowerComparator();
        LiftSortingServiceImpl liftSortingService = new LiftSortingServiceImpl();

        List<Lift> lifts = new ArrayList<>();
        lifts.add(new Lift("Asana", 200, 700));
        lifts.add(new Lift("Asana", 900, 900));
        lifts.add(new Lift("Asana", 600, 300));
        lifts.add(new Lift("Asana", 400, 200));

        System.out.println("Insertion sort:");
        System.out.println(liftSortingService.insertionSort(lifts, capacityComparator.reversed()));

        System.out.println("Insertion sort:");
        System.out.println(liftSortingService.mergeSort(lifts, enginePowerComparator));
    }
}
