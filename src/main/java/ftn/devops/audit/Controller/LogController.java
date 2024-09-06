package ftn.devops.audit.Controller;

import ftn.devops.audit.Entity.Log;
import ftn.devops.audit.Repository.LogRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LogController {

    @Autowired
    LogRepository logRepository;

    private static final Logger logger = LoggerFactory.getLogger(Controller.class);

    @Value("${spring.application.name}")
    private String applicationName;
    @GetMapping("/all-logs")
    public ResponseEntity<List<Log>> getAllLogs(){

        logger.info("Get all logs from Cassandra", applicationName);
        return ResponseEntity.ok(logRepository.findAll());
    }
    
    @GetMapping("/test")
    public ResponseEntity<String> testEndpoint(){

        logger.info("Test 1 - mladen kralj", applicationName);
        return ResponseEntity.ok("mladen kralj");
    }
    
    @GetMapping("/test2")
    public ResponseEntity<String> test2Endpoint(){
        logger.info("Test 2 - mladen kralj 123", applicationName);
        return ResponseEntity.ok("mladen kralj 123");
    }
}
