package lab7.task1_srp.domain;

/**
 * Value Object: оцінка з однієї дисципліни.
 * Єдине джерело правди (SSOT) для меж оцінки та прохідного бала.
 */
public record CourseGrade(String courseName, int score, int ectsCredits) {
    public static final int MIN_SCORE = 0;
    public static final int MAX_SCORE = 100;
    public static final int PASSING_SCORE = 60;

    public CourseGrade {
        if (courseName == null || courseName.isBlank()) {
            throw new IllegalArgumentException("Назва дисципліни не може бути порожньою.");
        }
        if (score < MIN_SCORE || score > MAX_SCORE) {
            throw new IllegalArgumentException("Неможлива оцінка " + score + " з предмета " + courseName + ".");
        }
        if (ectsCredits <= 0) {
            throw new IllegalArgumentException("Кількість кредитів ЄКТС з предмета " + courseName + " має бути більшою за 0.");
        }
    }

    public boolean isFailed() {
        return score < PASSING_SCORE;
    }
}
