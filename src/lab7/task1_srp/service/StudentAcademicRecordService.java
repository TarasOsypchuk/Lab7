package lab7.task1_srp.service;

import lab7.task1_srp.domain.AcademicSummary;
import lab7.task1_srp.domain.GradeSheet;

import java.math.BigDecimal;

/**
 * Оркестратор: лише визначає порядок кроків, сам не рахує, не форматує і не пише у файли.
 */
public class StudentAcademicRecordService {
    private final GpaCalculator gpaCalculator;
    private final ScholarshipPolicy scholarshipPolicy;
    private final TranscriptFormatter transcriptFormatter;
    private final ScholarshipCsvExporter csvExporter;
    private final CuratorNotifier curatorNotifier;

    public StudentAcademicRecordService(GpaCalculator gpaCalculator,
                                        ScholarshipPolicy scholarshipPolicy,
                                        TranscriptFormatter transcriptFormatter,
                                        ScholarshipCsvExporter csvExporter,
                                        CuratorNotifier curatorNotifier) {
        this.gpaCalculator = gpaCalculator;
        this.scholarshipPolicy = scholarshipPolicy;
        this.transcriptFormatter = transcriptFormatter;
        this.csvExporter = csvExporter;
        this.curatorNotifier = curatorNotifier;
    }

    public AcademicSummary process(GradeSheet sheet, String curatorEmail) {
        double gpa = gpaCalculator.calculate(sheet);
        BigDecimal scholarship = scholarshipPolicy.determine(gpa, sheet.hasFailedCourses());
        AcademicSummary summary = new AcademicSummary(sheet, gpa, scholarship);

        String transcript = transcriptFormatter.format(summary);
        csvExporter.export(summary);

        if (curatorEmail != null && !curatorEmail.isBlank()) {
            curatorNotifier.notify(curatorEmail, sheet.student(), transcript);
        }
        return summary;
    }
}
