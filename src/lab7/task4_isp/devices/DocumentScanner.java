package lab7.task4_isp.devices;

import lab7.task4_isp.roles.Scanner;

public class DocumentScanner implements Scanner {
    @Override
    public void scanDocument() {
        System.out.println("Scanning physical document...");
    }
}
