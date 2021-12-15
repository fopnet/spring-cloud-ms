package com.ms.payroll.service;

import com.ms.payroll.entity.Payment;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public Payment getPayment(long workerId, int days) {

        return Payment.builder().days(days).dailyIncome(100d).name("felipe").build();
    }
}
