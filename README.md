# Лабораторна робота №7 — SOLID, DRY, KISS, YAGNI

**Варіант 3** · мова: Java 17+ · група 243(2)

| Завдання | Принцип | Предметна область (варіант 3) | Пакет |
|---|---|---|---|
| 1 | SRP | Деканат: облік успішності, GPA, стипендія | `lab7.task1_srp` |
| 2 | OCP | Мультиканальні сповіщення | `lab7.task2_ocp` |
| 3 | LSP | Геометричні фігури (Rectangle / Square) | `lab7.task3_lsp` |
| 4 | ISP | Багатофункціональний принтер (БФП) | `lab7.task4_isp` |
| 5 | DIP | Процесинг онлайн-платежів | `lab7.task5_dip` |
| 6 | DRY / KISS / YAGNI | Аналіз | [`REPORT.md`](REPORT.md#завдання-6) |

Вихідний («поганий») код: тека [`original/`](original). Повний звіт з аналізом: [`REPORT.md`](REPORT.md).

## Запуск (Git Bash / Linux / macOS)

```bash
javac --release 17 -encoding UTF-8 -d out $(find src -name "*.java")

java -cp out lab7.task1_srp.Main
java -cp out lab7.task2_ocp.Main
java -cp out lab7.task3_lsp.Main
java -cp out lab7.task4_isp.Main
java -cp out lab7.task5_dip.Main
```

> Якщо в консолі Windows кирилиця виводиться «кракозябрами» — виконайте `chcp 65001`
> або запускайте з `-Dstdout.encoding=UTF-8`.

## Структура

```
src/lab7/
├── task1_srp/   domain/ (Student, CourseGrade, GradeSheet, AcademicSummary)
│                service/ (GpaCalculator, ScholarshipPolicy, TranscriptFormatter,
│                          ScholarshipCsvExporter, CuratorNotifier, StudentAcademicRecordService)
├── task2_ocp/   NotificationChannel (extension point), NotificationSender, channels/*
├── task3_lsp/   Shape, Rectangle, Square, Guards, AreaCalculator
├── task4_isp/   roles/ (Printer, DuplexPrinter, Scanner, FaxMachine, Stapler),
│                devices/, clients/
└── task5_dip/   core/ (абстракції + процесор), infrastructure/ (production), fakes/ (mock)
```
