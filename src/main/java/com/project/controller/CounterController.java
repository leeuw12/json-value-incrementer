package com.project.controller;

import com.project.model.CounterRequest;
import com.project.service.MainService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
public class CounterController {
    private final MainService mainService;

    @Autowired
    public CounterController(MainService mainService) {
        this.mainService = mainService;
    }

    @PostMapping("/modify")
    public ResponseEntity<Integer> update(@RequestBody CounterRequest counterRequest) {
        return ResponseEntity.ok()
                .body(mainService.update(counterRequest));
    }
}
