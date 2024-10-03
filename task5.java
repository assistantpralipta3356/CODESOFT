import java.util.*;

public class task5 {
    private Map<String, Course> courseDatabase;
    private Map<String, Student> studentDatabase;

    public task5() {
        courseDatabase = new HashMap<>();
        studentDatabase = new HashMap<>();
    }

    public class Course {
        private String courseCode;
        private String title;
        private String description;
        private int capacity;
        private List<String> registeredStudents;

        public Course(String courseCode, String title, String description, int capacity) {
            this.courseCode = courseCode;
            this.title = title;
            this.description = description;
            this.capacity = capacity;
            this.registeredStudents = new ArrayList<>();
        }

        public boolean hasAvailableSlots() {
            return registeredStudents.size() < capacity;
        }
    }

    public class Student {
        private String studentId;
        private String name;
        private List<String> registeredCourses;

        public Student(String studentId, String name) {
            this.studentId = studentId;
            this.name = name;
            this.registeredCourses = new ArrayList<>();
        }
    }

    public void addCourse(String courseCode, String title, String description, int capacity) {
        courseDatabase.put(courseCode, new Course(courseCode, title, description, capacity));
    }

    public void addStudent(String studentId, String name) {
        studentDatabase.put(studentId, new Student(studentId, name));
    }

    public boolean registerStudentForCourse(String studentId, String courseCode) {
        Student student = studentDatabase.get(studentId);
        Course course = courseDatabase.get(courseCode);

        if (student != null && course != null) {
            if (course.hasAvailableSlots() && !student.registeredCourses.contains(courseCode)) {
                student.registeredCourses.add(courseCode);
                course.registeredStudents.add(studentId);
                return true;
            }
        }
        return false;
    }

    public boolean dropCourse(String studentId, String courseCode) {
        Student student = studentDatabase.get(studentId);
        Course course = courseDatabase.get(courseCode);

        if (student != null && course != null) {
            if (student.registeredCourses.remove(courseCode)) {
                course.registeredStudents.remove(studentId);
                return true;
            }
        }
        return false;
    }

    public void displayAvailableCourses() {
        System.out.println("Available Courses:");
        for (Course course : courseDatabase.values()) {
            int availableSlots = course.capacity - course.registeredStudents.size();
            System.out.printf("%s: %s (%d slots available)%n", 
                course.courseCode, course.title, availableSlots);
        }
    }

    public void displayStudentCourses(String studentId) {
        Student student = studentDatabase.get(studentId);
        if (student != null) {
            System.out.println("Courses registered for " + student.name + ":");
            for (String courseCode : student.registeredCourses) {
                Course course = courseDatabase.get(courseCode);
                System.out.println(course.courseCode + ": " + course.title);
            }
        }
    }

    public static void main(String[] args) {
        task5 system = new task5();
        system.addCourse("CS101", "Intro to Programming", "Basic programming concepts", 30);
        system.addCourse("CS102", "Data Structures", "Fundamental data structures", 25);
        system.addStudent("S001", "John Doe");
        system.addStudent("S002", "Jane Smith");
        system.displayAvailableCourses();
        system.registerStudentForCourse("S001", "CS101");
        system.registerStudentForCourse("S001", "CS102");
        system.registerStudentForCourse("S002", "CS101");
        system.displayStudentCourses("S001");
        system.dropCourse("S001", "CS102");
        system.displayStudentCourses("S001");
    }
}