package learning.patterns.behavioral.strategy.v1;

import java.util.ArrayList;
import java.util.List;

import learning.patterns.behavioral.strategy.v1.entity.Course;
import learning.patterns.behavioral.strategy.v1.service.SortStrategy;
import learning.patterns.behavioral.strategy.v1.service.impl.CourseSorter;
import learning.patterns.behavioral.strategy.v1.service.impl.NameSortStrategy;
import learning.patterns.behavioral.strategy.v1.service.impl.RatingSortStrategy;
import learning.patterns.behavioral.strategy.v1.service.impl.StudentCountAndRatingSortStrategy;
import learning.patterns.behavioral.strategy.v1.service.impl.StudentCountSortStrategy;
import learning.patterns.behavioral.strategy.v1.enums.SortDirection;

public class StrategyMain {
    public static void main(String[] args) {
        System.out.println("Strategy Pattern Module");

        List<Course> courses = new ArrayList<>();

        courses.add(new Course("Design Patterns", 4.5, 100));
        courses.add(new Course("Clean Architecture", 4.8, 300));
        courses.add(new Course("Refactoring", 4.9, 400));
        courses.add(new Course("Clean Code", 4.7, 200));
        courses.add(new Course("Effective Java", 4.9, 200));
        courses.add(new Course("Kubernetes", 4.8, 200));    
        courses.add(new Course("Docker", 4.7, 200));    
        courses.add(new Course("Microservices", 4.9, 200));    
        courses.add(new Course("API Design", 4.8, 200));    
        courses.add(new Course("API Design", 4.8, 200));    

        System.out.println();
        printCourses(courses, "Unsorted courses:");

        // Demonstrate various sorting strategies
        demonstrateSort(courses, new NameSortStrategy(SortDirection.ASCENDING), 
                "Sorted courses by name in ascending order:");
        
        demonstrateSort(courses, new NameSortStrategy(SortDirection.DESCENDING), 
                "Sorted courses by name in descending order:");

        demonstrateSort(courses, new RatingSortStrategy(SortDirection.ASCENDING), 
                "Sorted courses by rating in ascending order:");

        demonstrateSort(courses, new RatingSortStrategy(SortDirection.DESCENDING), 
                "Sorted courses by rating in descending order:");

        demonstrateSort(courses, new StudentCountSortStrategy(SortDirection.ASCENDING), 
                "Sorted courses by number of students in ascending order:");

        demonstrateSort(courses, new StudentCountSortStrategy(SortDirection.DESCENDING), 
                "Sorted courses by number of students in descending order:");

        demonstrateSort(courses, new StudentCountAndRatingSortStrategy(SortDirection.ASCENDING), 
                "Sorted courses by number of students and rating in ascending order:");

        demonstrateSort(courses, new StudentCountAndRatingSortStrategy(SortDirection.DESCENDING), 
                "Sorted courses by number of students and rating in descending order:");
    }

    /**
     * Demonstrates a sorting strategy by creating a copy of the courses list,
     * applying the strategy, and printing the results.
     * 
     * @param originalCourses the original list of courses (will not be modified)
     * @param strategy the sorting strategy to apply
     * @param description the description to print with the sorted results
     */
    private static void demonstrateSort(List<Course> originalCourses, SortStrategy strategy, String description) {
        // Create a copy to avoid mutating the original list
        List<Course> coursesCopy = new ArrayList<>(originalCourses);
        
        System.out.println("Using " + strategy.getClass().getSimpleName());
        System.out.println("--------------------------------");
        
        CourseSorter courseSorter = new CourseSorter(strategy);
        courseSorter.sort(coursesCopy);
        
        System.out.println();
        printCourses(coursesCopy, description);
        System.out.println();
    }

    public static void printCourses(List<Course> courses, String message) {
        System.out.println(message);
        courses.forEach(System.out::println);
    }
}
