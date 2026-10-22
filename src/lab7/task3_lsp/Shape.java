package lab7.task3_lsp;

/**
 * Спільний контракт усіх фігур — лише те, що КОЖНА фігура виконує однаково.
 * Постумова scale(k): площа нової фігури = площа * k^2, вихідна фігура не змінюється.
 */
public interface Shape {
    double area();

    Shape scale(double factor);
}
