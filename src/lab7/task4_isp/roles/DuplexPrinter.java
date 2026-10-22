package lab7.task4_isp.roles;

/** Двосторонній друк — розширення ролі Printer (кожен duplex-принтер уміє і звичайний друк). */
public interface DuplexPrinter extends Printer {
    void duplexPrint(String doc);
}
