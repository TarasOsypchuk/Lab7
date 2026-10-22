package lab7.task3_lsp;

/**
 * Клієнтський код. Незалежна зміна ширини й висоти — поведінка лише прямокутника,
 * тому метод приймає Rectangle; Square сюди передати неможливо вже на етапі компіляції.
 */
public class AreaCalculator {
    private static final double EPS = 1e-9;

    public Rectangle resizeAndVerifyArea(Rectangle rect) {
        Rectangle resized = rect.withWidth(5).withHeight(10);
        double expectedArea = 50;
        if (Math.abs(resized.area() - expectedArea) > EPS) {
            throw new IllegalStateException("Порушено постумову: очікувалась площа " + expectedArea + ", отримано " + resized.area());
        }
        return resized;
    }

    /** Працює з БУДЬ-ЯКОЮ фігурою — тут підстановка нащадків безпечна (LSP виконується). */
    public Shape scaleAndVerify(Shape shape, double factor) {
        Shape scaled = shape.scale(factor);
        double expectedArea = shape.area() * factor * factor;
        if (Math.abs(scaled.area() - expectedArea) > EPS * Math.max(1, expectedArea)) {
            throw new IllegalStateException("Порушено контракт scale(): очікувалась площа " + expectedArea + ", отримано " + scaled.area());
        }
        return scaled;
    }
}
