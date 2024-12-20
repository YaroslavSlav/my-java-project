package org.example;

import java.util.Arrays;

public class FinanceReport {
    private Payment[] payments; // Массив платежей
    private String author; // ФИО составителя отчета
    private String reportDate; // Дата создания отчета

    // Конструктор
    public FinanceReport(Payment[] payments, String author, String reportDate) {
        // Копирование массива платежей для избежания изменений
        this.payments = Arrays.copyOf(payments, payments.length);
        this.author = author;
        this.reportDate = reportDate;
    }

    // Конструктор копирования
    public FinanceReport(FinanceReport other) {
        this.payments = Arrays.copyOf(other.payments, other.payments.length);
        this.author = other.author;
        this.reportDate = other.reportDate;
    }

    // Геттеры и сеттеры
    public Payment[] getPayments() {
        return Arrays.copyOf(payments, payments.length);
    }

    public void setPayments(Payment[] payments) {
        this.payments = Arrays.copyOf(payments, payments.length);
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getReportDate() {
        return reportDate;
    }

    public void setReportDate(String reportDate) {
        this.reportDate = reportDate;
    }

    // Получение количества платежей
    public int getPaymentCount() {
        return payments.length;
    }

    // Получение платежа по индексу
    public Payment getPayment(int index) {
        if (index < 0 || index >= payments.length) {
            throw new IndexOutOfBoundsException("Invalid payment index.");
        }
        return payments[index];
    }

    // Установка платежа по индексу
    public void setPayment(int index, Payment payment) {
        if (index < 0 || index >= payments.length) {
            throw new IndexOutOfBoundsException("Invalid payment index.");
        }
        payments[index] = payment;
    }

    // Метод toString
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Автор: %s, дата: %s, Платежи: [\n", author, reportDate));
        for (Payment payment : payments) {
            sb.append("  ").append(payment.toString()).append("\n");
        }
        sb.append("]");
        return sb.toString();
    }
}
