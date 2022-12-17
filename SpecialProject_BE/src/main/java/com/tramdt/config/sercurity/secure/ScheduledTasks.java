package com.tramdt.config.sercurity.secure;

import com.tramdt.model.Transaction;
import com.tramdt.service.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class ScheduledTasks {

    private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);

    @Autowired
    private TransactionService transactionService;

    @Scheduled(fixedDelay = 5000)
    public void updateOverdueTransaction() {
        List<Transaction> transactions = transactionService.findOverdueTransaction();
        int size = transactions.size();
        if (size > 0) {
            for (Transaction i : transactions) {
                i.setStatus(TransactionService.CANCELED);
            }
            transactionService.saveAll(transactions);
            logger.info("Number of overdue transaction: " + size);
        }
    }
}
