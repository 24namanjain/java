package learning.patterns.behavioral.strategy.v1.service.impl;

import java.util.Comparator;
import java.util.List;

import learning.patterns.behavioral.strategy.v1.entity.Course;
import learning.patterns.behavioral.strategy.v1.service.SortStrategy;
import learning.patterns.behavioral.strategy.v1.enums.SortDirection;
/**
 * Role : Concrete Strategy
 * Responsibility : Sort courses by number of students in ascending order
 * Dependencies : SortStrategy
 */
public class StudentCountSortStrategy implements SortStrategy {
    
    private SortDirection sortDirection;
    
    public StudentCountSortStrategy(SortDirection sortDirection) {
        if (sortDirection == null) {
            throw new IllegalArgumentException("Sort direction cannot be null");
        }

        this.sortDirection = sortDirection;
    }
    @Override
    public void sort(List<Course> courses) {
        if (sortDirection == SortDirection.ASCENDING) {
            courses.sort(Comparator.comparing(Course::getNumberOfStudents));
        } else {
            courses.sort(Comparator.comparing(Course::getNumberOfStudents).reversed());
        }

    }   
}
