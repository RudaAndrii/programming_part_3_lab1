package ua.lviv.iot.services;

import ua.lviv.iot.model.Lift;
import ua.lviv.iot.model.StatsTracker;

import java.util.Comparator;
import java.util.List;

public interface LiftSortingService {
    List<Lift> insertionSort(List<Lift> lifts, Comparator<Lift> comparator, StatsTracker tracker);

    List<Lift> mergeSort(List<Lift> lifts, Comparator<Lift> comparator, StatsTracker tracker);
}
