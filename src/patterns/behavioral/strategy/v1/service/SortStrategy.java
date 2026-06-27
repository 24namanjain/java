package patterns.behavioral.strategy.v1.service;

import java.util.List;

import patterns.behavioral.strategy.v1.entity.Course;

/**
 * SortStrategy interface
 * This interface defines the contract for sorting strategies.
 * Implementations of this interface will provide different sorting algorithms.
 */
public interface SortStrategy {

    void sort(List<Course> courses);

}