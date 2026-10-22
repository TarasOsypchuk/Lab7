package lab7.task1_srp.service;

import lab7.task1_srp.domain.CourseGrade;
import lab7.task1_srp.domain.GradeSheet;

/**
 * Відповідальність: розрахунок середньозваженого бала (за кредитами ЄКТС).
 */
public class GpaCalculator {
    public double calculate(GradeSheet sheet) {
        double weightedSum = 0;
        int totalCredits = 0;
        for (CourseGrade g : sheet.grades()) {
            weightedSum += (double) g.score() * g.ectsCredits();
            totalCredits += g.ectsCredits();
        }
        return weightedSum / totalCredits; // totalCredits > 0 гарантує інваріант CourseGrade
    }
}
