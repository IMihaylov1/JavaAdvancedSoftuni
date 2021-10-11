package christmas;

import java.util.ArrayList;
import java.util.List;

public class Classroom {
    public int capacity;
    public List<Student> students;

    public int getCapacity() {
        return this.capacity;
    }

    public List<Student> getData() {
        return this.students;
    }




    public Classroom(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public int getStudentCount() {
        return this.students.size();
    }

    public String registerStudent(Student student) {
        StringBuilder stringBuilder = new StringBuilder();

        if (this.students.contains(student)) {
            stringBuilder.append("Student is already in the classroom");
            stringBuilder.append(System.lineSeparator());
            return stringBuilder.toString().trim();
        }
        if (this.capacity > this.students.size()) {
            this.students.add(student);

            String first = String.format("Added student %s %s", student.getFirstName(), student.getLastName());
            stringBuilder.append(first);
            stringBuilder.append(System.lineSeparator());

            if (this.students.size() == this.capacity) {
                stringBuilder.append("No seats in the classroom");
                stringBuilder.append(System.lineSeparator());
            }
        }
        return stringBuilder.toString().trim();
    }

    public String dismissStudent(Student student) {
        boolean isRemoved = false;
        isRemoved = this.students.removeIf(student1 -> student1.getFirstName().equals(student.getFirstName()));
        if (isRemoved) {
            String isRemovedOfList = String.format("Removed student %s %s", student.getFirstName(), student.getLastName());
            return isRemovedOfList;
        } else {
            String isNotRemoved = "Student not found";
            return isNotRemoved;
        }
    }

    public String getSubjectInfo(String subject) {
        List<Student> getStudents = new ArrayList<>();

        for (Student student : students) {
            if (student.getBestSubject().equals(subject)) {
                getStudents.add(student);
            }
        }
        String input = "";
        StringBuilder stringBuilder = new StringBuilder();

        if (getStudents.size() == 0) {
            return input = "No students enrolled for the subject";
        } else {
            stringBuilder.append(String.format("Subject: %s", subject));
            stringBuilder.append(System.lineSeparator());
            stringBuilder.append("Students:").append(System.lineSeparator());
            for (Student student : getStudents) {
                stringBuilder.append(String.format("%s %s", student.getFirstName(), student.getLastName()));
                stringBuilder.append(System.lineSeparator());
            }
            return stringBuilder.toString().trim();
        }
    }

    public Student getStudent(String firstName, String lastName) {
        for (Student student : students) {
            String studentName = student.getFirstName();
            if (studentName.equals(firstName)&&student.getLastName().equals(lastName)) {
                return student;
            }
        }
        return null;

        }

    public String getStatistics() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Classroom size: %d", this.students.size()));
        stringBuilder.append(System.lineSeparator());
        for (Student student : students) {
            stringBuilder.append("==");
            stringBuilder.append(student.toString());
            stringBuilder.append(System.lineSeparator());
        }
        return stringBuilder.toString().trim();
    }
}
