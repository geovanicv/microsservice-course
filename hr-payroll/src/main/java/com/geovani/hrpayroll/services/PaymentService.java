package com.geovani.hrpayroll.services;

import com.geovani.hrpayroll.entities.Payment;
import com.geovani.hrpayroll.entities.Worker;
import com.geovani.hrpayroll.feignClients.WorkerFeignClient;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private WorkerFeignClient workerFeignClient;

    PaymentService(WorkerFeignClient workerFeignClient) {
        this.workerFeignClient = workerFeignClient;
    }

    public Payment getPayment(long workerId, int days) {

        Worker worker = workerFeignClient.findById(workerId).getBody();
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}