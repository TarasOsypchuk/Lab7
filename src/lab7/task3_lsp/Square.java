package lab7.task3_lsp;

/**
 * Квадрат більше НЕ успадковує Rectangle. Він має одну сторону, тому
 * незалежних setWidth/setHeight у нього просто немає — порушувати нічого.
 */
public record Square(double side) implements Shape {
    public Square {
        Guards.requirePositive(side, "Сторона");
    }

    public Square withSide(double newSide) {
        return new Square(newSide);
    }

    @Override
    public double area() {
        return side * side;
    }

    @Override
    public Square scale(double factor) {
        Guards.requirePositive(factor, "Коефіцієнт масштабування");
        return new Square(side * factor);
    }
}
