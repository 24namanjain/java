package patterns.behavioral.strategy.v1.service.impl;

import java.util.List;

import patterns.behavioral.strategy.v1.entity.Course;
import patterns.behavioral.strategy.v1.service.SortStrategy;

/**
 * Role : Context
 * Responsibility : Sort courses based on the selected strategy
 * Dependencies : SortStrategy
 */
public class CourseSorter {
    
    private final SortStrategy sortStrategy;

    public CourseSorter(SortStrategy sortStrategy) {
        if (sortStrategy == null) {
            throw new IllegalArgumentException("Sort strategy cannot be null");
        }

        this.sortStrategy = sortStrategy;
    }

    public void sort(List<Course> courses) {
        if (courses == null) {
            throw new IllegalArgumentException("Courses list cannot be null");
        }

        this.sortStrategy.sort(courses);
    }
}
