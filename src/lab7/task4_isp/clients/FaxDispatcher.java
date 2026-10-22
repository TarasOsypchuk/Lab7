package lab7.task4_isp.clients;

import lab7.task4_isp.roles.FaxMachine;

public class FaxDispatcher {
    private final FaxMachine fax;

    public FaxDispatcher(FaxMachine fax) {
        this.fax = fax;
    }

    public void dispatch(String number, String doc) {
        fax.sendFax(number, doc);
    }
}
