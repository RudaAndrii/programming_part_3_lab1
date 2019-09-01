package ua.lviv.iot.services;

import ua.lviv.iot.model.Lift;

import java.util.Comparator;
import java.util.List;

public interface LiftSortingService {
    List<Lift> insertionSort(List<Lift> lifts, Comparator<Lift> comparator);

    List<Lift> mergeSort(List<Lift> lifts, Comparator<Lift> comparator);
}
