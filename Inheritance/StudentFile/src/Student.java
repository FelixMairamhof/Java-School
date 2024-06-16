public class Student {
    private String firstName;
    private String lastName;
    private String className;
    private int height;
    private double weight;
    private double gradeAverage;

    public Student(String firstName, String lastName, String className, int height, double weight, double gradeAverage) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.className = className;
        this.height = height;
        this.weight = weight;
        this.gradeAverage = gradeAverage;
    }

    // Getter und Setter für alle Attribute
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getGradeAverage() {
        return gradeAverage;
    }

    public void setGradeAverage(double gradeAverage) {
        this.gradeAverage = gradeAverage;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + ", Größe:" + height + "cm, Gewicht:" + weight + "kg, Notendurchschnitt:" + gradeAverage;
    }
}
