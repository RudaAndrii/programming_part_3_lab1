package ua.lviv.iot.services.impl;

import ua.lviv.iot.model.Lift;
import ua.lviv.iot.services.LiftSortingService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LiftSortingServiceImpl implements LiftSortingService {
    @Override
    public List<Lift> insertionSort(List<Lift> lifts, Comparator<Lift> comparator) {
        int length = lifts.size();
        for (int i = 1; i < length; i++) {
            Lift tmp = lifts.get(i);
            int pointer = i;
            while ((pointer > 0) && comparator.compare(lifts.get(pointer - 1), tmp) > 0) {
                lifts.set(pointer, lifts.get(pointer - 1));
                pointer--;
            }
            lifts.set(pointer, tmp);
        }
        return lifts;
    }

    @Override
    public List<Lift> mergeSort(List<Lift> lifts, Comparator<Lift> comparator) {
        List<Lift> left;
        List<Lift> right;

        if (lifts.size() == 1) {
            return lifts;
        } else {
            int center = lifts.size() / 2;
            left = new ArrayList<>(lifts.subList(0, center));
            right =  new ArrayList<>(lifts.subList(center, lifts.size()));

            left = mergeSort(left, comparator);
            right = mergeSort(right, comparator);

            merge(left, right, lifts, comparator);
        }

        return lifts;
    }

    private void merge(List<Lift> left, List<Lift> right, List<Lift> lifts, Comparator<Lift> comparator) {
        int leftIndex = 0;
        int rightIndex = 0;
        int liftsIndex = 0;

        while (leftIndex < left.size() && rightIndex < right.size()) {
            if (comparator.compare(left.get(leftIndex), right.get(rightIndex)) < 0) {
                lifts.set(liftsIndex, left.get(leftIndex));
                leftIndex++;
            } else {
                lifts.set(liftsIndex, right.get(rightIndex));
                rightIndex++;
            }
            liftsIndex++;
        }

        List<Lift> rest;
        int restIndex;
        if (leftIndex >= left.size()) {
            rest = right;
            restIndex = rightIndex;
        } else {
            rest = left;
            restIndex = leftIndex;
        }

        for (int i = restIndex; i < rest.size(); i++) {
            lifts.set(liftsIndex, rest.get(i));
            liftsIndex++;
        }
    }
} 