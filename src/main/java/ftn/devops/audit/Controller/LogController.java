package ftn.devops.audit.Controller;

import ftn.devops.audit.Entity.Log;
import ftn.devops.audit.Repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LogController {

    @Autowired
    LogRepository logRepository;

    @GetMapping("/all-logs")
    public ResponseEntity<List<Log>> getAllLogs(){
        return ResponseEntity.ok(logRepository.findAll());
    }
    
    @GetMapping("/test")
    public ResponseEntity<String> testEndpoint(){
        return ResponseEntity.ok("mladen kralj");
    }
    
    @GetMapping("/test2")
    public ResponseEntity<String> test2Endpoint(){
        return ResponseEntity.ok("mladen kralj 123");
    }
}
