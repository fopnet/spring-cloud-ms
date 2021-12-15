package com.ms.payroll.service;

import java.util.HashMap;
import java.util.Map;

import com.ms.payroll.entity.Payment;
import com.ms.payroll.entity.Worker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PaymentService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${worker.host}")
    private String workerHost;

    public Payment getPayment(long workerId, int days) {

        Map<String, String> urlVariables = new HashMap<>();
        urlVariables.put("id", String.valueOf(workerId));

        Worker worker = restTemplate.getForObject(workerHost.concat("/workers/{id}"), Worker.class,
                urlVariables);

        return Payment.builder().days(days).dailyIncome(worker.getDailyIncome()).name(worker.getName()).build();
    }
}
