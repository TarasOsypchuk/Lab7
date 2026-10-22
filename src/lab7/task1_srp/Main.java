package lab7.task1_srp;

import lab7.task1_srp.domain.CourseGrade;
import lab7.task1_srp.domain.GradeSheet;
import lab7.task1_srp.domain.Student;
import lab7.task1_srp.service.*;

import java.nio.file.Path;
import java.time.Clock;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Composition root: збираємо оркестратор з окремих сервісі
        StudentAcademicRecordService service = new StudentAcademicRecordService(
                new GpaCalculator(),
                new ScholarshipPolicy(),
                new TranscriptFormatter(),
                new ScholarshipCsvExporter(Path.of("scholarship_registry.csv"), Clock.systemDefaultZone()),
                new CuratorNotifier());

        GradeSheet sheet = new GradeSheet(
                new Student("STU-243-07", "Олена Коваль"),
                List.of(new CourseGrade("Бази даних та NoSQL", 95, 5),
                        new CourseGrade("Операційні системи", 91, 4),
                        new CourseGrade("Конструювання ПЗ", 88, 6)));

        var summary = service.process(sheet, "curator@chnu.edu.ua");
        System.out.printf("Результат: GPA=%.2f, стипендія=%s грн%n", summary.gpa(), summary.scholarship());

        // Fail-fast: некоректна оцінка відсікається ще при створенні Value Object
        try {
            new CourseGrade("Фізика", 120, 3);
        } catch (IllegalArgumentException e) {
            System.out.println("Fail-fast: " + e.getMessage());
        }
    }
}
