package lab7.task3_lsp;

/**
 * Незмінний Value Object. Ширина і висота незалежні — це інваріант прямокутника.
 */
public record Rectangle(double width, double height) implements Shape {
    public Rectangle {
        Guards.requirePositive(width, "Ширина");
        Guards.requirePositive(height, "Висота");
    }

    public Rectangle withWidth(double newWidth) {
        return new Rectangle(newWidth, height);
    }

    public Rectangle withHeight(double newHeight) {
        return new Rectangle(width, newHeight);
    }

    @Override
    public double area() {
        return width * height;
    }

    @Override
    public Rectangle scale(double factor) {
        Guards.requirePositive(factor, "Коефіцієнт масштабування");
        return new Rectangle(width * factor, height * factor);
    }
}
