package patterns.behavioral.strategy.v1.service.impl;

import java.util.Comparator;
import java.util.List;

import patterns.behavioral.strategy.v1.entity.Course;
import patterns.behavioral.strategy.v1.enums.SortDirection;
import patterns.behavioral.strategy.v1.service.SortStrategy;

/**
 * Role : Concrete Strategy
 * Responsibility : Sort courses by number of students and rating in ascending order
 * Dependencies : SortStrategy
 */
public class StudentCountAndRatingSortStrategy implements SortStrategy {
    
    private final SortDirection sortDirection;

    public StudentCountAndRatingSortStrategy(SortDirection sortDirection) {
        if (sortDirection == null) {
            throw new IllegalArgumentException("Sort direction cannot be null");
        }

        this.sortDirection = sortDirection;
    }

    @Override
    public void sort(List<Course> courses) {
        if (sortDirection == SortDirection.ASCENDING) {
            courses.sort(Comparator.comparing(Course::getNumberOfStudents).thenComparing(Course::getRating));
        } else {
            // Reverse both comparisons independently for descending order
            // Primary sort: numberOfStudents descending, Secondary sort: rating descending
            Comparator<Course> comparator = Comparator.comparing(Course::getNumberOfStudents).reversed();
            comparator = comparator.thenComparing(Comparator.comparing(Course::getRating).reversed());
            courses.sort(comparator);
        }
    }
}   