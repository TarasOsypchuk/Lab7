package lab7.task4_isp;

import lab7.task4_isp.clients.*;
import lab7.task4_isp.devices.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        BasicLaserPrinter laser = new BasicLaserPrinter();
        DocumentScanner scanner = new DocumentScanner();
        OfficeMultiFunctionDevice mfd = new OfficeMultiFunctionDevice();

        new PrintQueue(laser).printAll(List.of("Наказ №12.pdf", "Розклад.docx"));
        new PrintQueue(mfd).printAll(List.of("Відомість.xlsx")); // БФП теж підходить як Printer
        new ArchiveDigitizer(scanner).digitize(2);
        new FaxDispatcher(mfd).dispatch("+380372584810", "Лист до ректорату");
        new BookletService(mfd, mfd).makeBooklet("Методичка ЛР7", 12);

        // new FaxDispatcher(laser); // <- не скомпілюється: лазерний принтер не має ролі FaxMachine
    }
}
