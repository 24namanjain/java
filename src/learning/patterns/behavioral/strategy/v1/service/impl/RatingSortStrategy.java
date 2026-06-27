package learning.patterns.behavioral.strategy.v1.service.impl;

import java.util.Comparator;
import java.util.List;

import learning.patterns.behavioral.strategy.v1.entity.Course;
import learning.patterns.behavioral.strategy.v1.service.SortStrategy;
import learning.patterns.behavioral.strategy.v1.enums.SortDirection;
/**
 * Role : Concrete Strategy
 * Responsibility : Sort courses by rating in ascending order
 * Dependencies : SortStrategy
 */
public class RatingSortStrategy implements SortStrategy {

    private SortDirection sortDirection;

    public RatingSortStrategy(SortDirection sortDirection) {
        if (sortDirection == null) {
            throw new IllegalArgumentException("Sort direction cannot be null");
        }

        this.sortDirection = sortDirection;
    }

    @Override
    public void sort(List<Course> courses) {
        if (sortDirection == SortDirection.ASCENDING) {
            courses.sort(Comparator.comparing(Course::getRating));
        } else {
            courses.sort(Comparator.comparing(Course::getRating).reversed());
        }
    }
}
