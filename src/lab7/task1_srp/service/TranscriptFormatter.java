package lab7.task1_srp.service;

import lab7.task1_srp.domain.AcademicSummary;
import lab7.task1_srp.domain.CourseGrade;
import lab7.task1_srp.domain.Student;

/**
 * Відповідальність: представлення — текстовий витяг з академічної відомості.
 */
public class TranscriptFormatter {
    private static final String DOUBLE_LINE = "==========================================\n";
    private static final String SINGLE_LINE = "------------------------------------------\n";

    public String format(AcademicSummary summary) {
        Student s = summary.sheet().student();
        StringBuilder sb = new StringBuilder();
        sb.append(DOUBLE_LINE);
        sb.append("АКАДЕМІЧНА ДОВІДКА: ").append(s.name()).append(" (ID: ").append(s.id()).append(")\n");
        sb.append(DOUBLE_LINE);
        for (CourseGrade g : summary.sheet().grades()) {
            sb.append(String.format("%-30s | %d Кредитів | Оцінка: %d%n", g.courseName(), g.ectsCredits(), g.score()));
        }
        sb.append(SINGLE_LINE);
        sb.append(String.format("Середній бал (GPA): %.2f%n", summary.gpa()));
        sb.append("Призначена стипендія: ").append(summary.scholarship()).append(" грн\n");
        return sb.toString();
    }
}
