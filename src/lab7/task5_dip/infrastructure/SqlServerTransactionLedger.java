package lab7.task5_dip.infrastructure;

import lab7.task5_dip.core.PaymentRequest;
import lab7.task5_dip.core.TransactionLedger;
import lab7.task5_dip.core.TransactionStatus;

public class SqlServerTransactionLedger implements TransactionLedger {
    @Override
    public void record(PaymentRequest request, TransactionStatus status) {
        System.out.println("[SQL Server Ledger] Записано транзакцію " + request.transactionId()
                + ": сума=" + request.amount() + ", статус=" + status + ".");
    }
}
