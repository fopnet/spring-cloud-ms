package com.ms.worker.controller;

import java.util.List;

import com.ms.worker.entity.Worker;
import com.ms.worker.repository.WorkerRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/workers")
public class WorkerController {

    @Autowired
    private Environment environment;

    private static Logger logger = LoggerFactory.getLogger(WorkerController.class);

    @Autowired
    private WorkerRepository repository;

    @Value("${test.config}")
    private String testConfig;

    @GetMapping
    public ResponseEntity<List<Worker>> findAll() {
        List<Worker> lista = repository.findAll();
        return ResponseEntity.ok(lista);

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Worker> findById(@PathVariable Long id) {
        logger.info("PORT {}", environment.getProperty("local.server.port"));

        // try {
        // Thread.sleep(3000);
        // } catch (InterruptedException e) {
        // e.printStackTrace();
        // }

        Worker wk = repository.findById(id).orElseThrow(() -> new RuntimeException("Worker not found"));
        return ResponseEntity.ok(wk);

    }

    @GetMapping(value = "/configs")
    public ResponseEntity<Void> getConfigs() {
        logger.info("CONFIG= {}", testConfig);
        return ResponseEntity.noContent().build();
    }
}
