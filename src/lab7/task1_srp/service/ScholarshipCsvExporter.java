package lab7.task1_srp.service;

import lab7.task1_srp.domain.AcademicSummary;
import lab7.task1_srp.domain.Student;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.Clock;
import java.time.LocalDate;
import java.util.Locale;

/**
 * Відповідальність: експорт у CSV-реєстр стипендій для бухгалтерії (формат + файлова система).
 */
public class ScholarshipCsvExporter {
    private final Path file;
    private final Clock clock;

    public ScholarshipCsvExporter(Path file, Clock clock) {
        this.file = file;
        this.clock = clock;
    }

    public void export(AcademicSummary summary) {
        Student s = summary.sheet().student();
        String line = String.format(Locale.ROOT, "%s;%s;%.2f;%s;%s%n",
                s.id(), s.name(), summary.gpa(), summary.scholarship(), LocalDate.now(clock));
        try {
            Files.writeString(file, line, StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new UncheckedIOException("Помилка експорту у CSV: " + e.getMessage(), e);
        }
    }
}
