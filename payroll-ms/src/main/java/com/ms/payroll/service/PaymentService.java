package com.ms.payroll.service;

import com.ms.payroll.entity.Payment;
import com.ms.payroll.entity.Worker;
import com.ms.payroll.feignClient.WorkerFeignClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private WorkerFeignClient workerClient;

    // @Value("${worker.host}")
    // private String workerHost;

    public Payment getPayment(long workerId, int days) {

        Worker worker = workerClient.findById(workerId).getBody();

        return Payment.builder().days(days).dailyIncome(worker.getDailyIncome()).name(worker.getName()).build();
    }
}
