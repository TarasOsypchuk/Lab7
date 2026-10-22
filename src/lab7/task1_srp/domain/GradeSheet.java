package lab7.task1_srp.domain;

import java.util.List;
import java.util.Objects;

/**
 * Відомість студента за семестр. Інваріант — перелік дисциплін не порожній.
 */
public record GradeSheet(Student student, List<CourseGrade> grades) {
    public GradeSheet {
        Objects.requireNonNull(student, "Студент не може бути null.");
        if (grades == null || grades.isEmpty()) {
            throw new IllegalStateException("Перелік дисциплін порожній.");
        }
        grades = List.copyOf(grades); // незмінна копія, null-елементи заборонені
    }

    public boolean hasFailedCourses() {
        return grades.stream().anyMatch(CourseGrade::isFailed);
    }
}
