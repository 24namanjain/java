package patterns.behavioral.strategy.v1.service.impl;

import java.util.Comparator;
import java.util.List;

import patterns.behavioral.strategy.v1.entity.Course;
import patterns.behavioral.strategy.v1.service.SortStrategy;
import patterns.behavioral.strategy.v1.enums.SortDirection;
/**
 * Role : Concrete Strategy
 * Responsibility : Sort courses by name in the specified direction
 * Dependencies : SortStrategy
 */
public class NameSortStrategy implements SortStrategy {

    private final SortDirection sortDirection;

    public NameSortStrategy(SortDirection sortDirection) {
        if (sortDirection == null) {
            throw new IllegalArgumentException("Sort direction cannot be null");
        }

        this.sortDirection = sortDirection;
    }
    
    @Override
    public void sort(List<Course> courses) {
        if (sortDirection == SortDirection.ASCENDING) {
            courses.sort(Comparator.comparing(Course::getName, String.CASE_INSENSITIVE_ORDER));
        } else {
            courses.sort(Comparator.comparing(Course::getName, String.CASE_INSENSITIVE_ORDER).reversed());
        }
    }
}
