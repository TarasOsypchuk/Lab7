package lab7.task4_isp.devices;

import lab7.task4_isp.roles.DuplexPrinter;

/** Реалізує лише ті ролі, які пристрій реально підтримує — без методів-заглушок. */
public class BasicLaserPrinter implements DuplexPrinter {
    @Override
    public void printDocument(String doc) {
        System.out.println("Printing: " + doc);
    }

    @Override
    public void duplexPrint(String doc) {
        System.out.println("Duplex printing: " + doc);
    }
}
