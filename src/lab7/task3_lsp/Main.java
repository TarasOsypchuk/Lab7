package lab7.task3_lsp;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        AreaCalculator calc = new AreaCalculator();

        Rectangle r = calc.resizeAndVerifyArea(new Rectangle(2, 3));
        System.out.println("Прямокутник після зміни розмірів: " + r + ", площа = " + r.area());

        // Будь-яку фігуру можна підставити туди, де очікується Shape
        for (Shape s : List.<Shape>of(new Rectangle(2, 3), new Square(4))) {
            Shape scaled = calc.scaleAndVerify(s, 2.5);
            System.out.println(s + " -> " + scaled + ", площа " + s.area() + " -> " + scaled.area());
        }

        // Незмінність: вихідний об'єкт не змінився
        Square sq = new Square(3);
        Square bigger = sq.withSide(10);
        System.out.println("Оригінал: " + sq + ", новий: " + bigger);

        // calc.resizeAndVerifyArea(new Square(5)); // <- не скомпілюєтя: Square не є Rectangle

        // Fail-fast: інваріанти перевіряються в конструкторі
        try {
            new Rectangle(-1, 5);
        } catch (IllegalArgumentException e) {
            System.out.println("Fail-fast: " + e.getMessage());
        }
    }
}
