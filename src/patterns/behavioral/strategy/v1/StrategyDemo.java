package patterns.behavioral.strategy.v1;

import java.util.ArrayList;
import java.util.List;

import core.DemoRunner;
import core.FeatureDemo;
import core.JavaLogger;
import patterns.behavioral.strategy.v1.entity.Course;
import patterns.behavioral.strategy.v1.enums.SortDirection;
import patterns.behavioral.strategy.v1.service.SortStrategy;
import patterns.behavioral.strategy.v1.service.impl.CourseSorter;
import patterns.behavioral.strategy.v1.service.impl.NameSortStrategy;
import patterns.behavioral.strategy.v1.service.impl.RatingSortStrategy;
import patterns.behavioral.strategy.v1.service.impl.StudentCountAndRatingSortStrategy;
import patterns.behavioral.strategy.v1.service.impl.StudentCountSortStrategy;

public class StrategyDemo implements FeatureDemo {

    static void main() {
        DemoRunner.run(new StrategyDemo());
    }

    @Override
    public void run() {
        JavaLogger.INSTANCE.info("Strategy Pattern Module");

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

        JavaLogger.INSTANCE.newLine();
        printCourses(courses, "Unsorted courses:");

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

    private void demonstrateSort(List<Course> originalCourses, SortStrategy strategy, String description) {
        List<Course> coursesCopy = new ArrayList<>(originalCourses);

        JavaLogger.INSTANCE.info("Using " + strategy.getClass().getSimpleName());
        JavaLogger.INSTANCE.info("--------------------------------");

        CourseSorter courseSorter = new CourseSorter(strategy);
        courseSorter.sort(coursesCopy);

        JavaLogger.INSTANCE.newLine();
        printCourses(coursesCopy, description);
        JavaLogger.INSTANCE.newLine();
    }

    private void printCourses(List<Course> courses, String message) {
        JavaLogger.INSTANCE.info(message);
        courses.forEach(course -> {
            JavaLogger.INSTANCE.info(course.toString());
            JavaLogger.INSTANCE.newLine();
        });
    }
}
