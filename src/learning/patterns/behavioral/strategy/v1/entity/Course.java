package learning.patterns.behavioral.strategy.v1.entity;

public class Course {

    private final String name;
    private final double rating;
    private final int numberOfStudents;

    public Course(String name, double rating, int numberOfStudents) {
        this.name = name;
        this.rating = rating;
        this.numberOfStudents = numberOfStudents;
    }

    public String getName() {
        return name;
    }

    public double getRating() {
        return rating;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    @Override
    public String toString() {
        return "Course{name='" + name + "', rating=" + rating + ", numberOfStudents=" + numberOfStudents + "}";
    }
}
