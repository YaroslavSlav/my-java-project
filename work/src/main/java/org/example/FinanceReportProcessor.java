package org.example;

import java.util.ArrayList;
import java.util.List;

public class FinanceReportProcessor {

    public static FinanceReport filterByLastName(FinanceReport report, char startChar) {
        List<Payment> filtered = new ArrayList<>();
        for (Payment p : report.getPayments()) {
            if (p.getFullName().charAt(0) == startChar) {
                filtered.add(p);
            }
        }
        return new FinanceReport(filtered.toArray(new Payment[0]), report.getAuthor(), report.getReportDate());
    }

    public static FinanceReport filterByAmount(FinanceReport report, int maxAmount) {
        List<Payment> filtered = new ArrayList<>();
        for (Payment p : report.getPayments()) {
            if (p.getAmount() < maxAmount) {
                filtered.add(p);
            }
        }
        return new FinanceReport(filtered.toArray(new Payment[0]), report.getAuthor(), report.getReportDate());
    }

    // Дополнительные методы из задачи 12*
}
