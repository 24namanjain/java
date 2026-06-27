package learning.patterns.behavioral.strategy.v1.entity;

public class Course {

    private String name;
    private double rating;
    private int numberOfStudents;

    public Course(String name, double rating, int numberOfStudents) {
        this.name = name;
        this.rating = rating;
        this.numberOfStudents = numberOfStudents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    @Override
    public String toString() {
        return "Course{name='" + name + "', rating=" + rating + ", numberOfStudents=" + numberOfStudents + "}";
    }
}
