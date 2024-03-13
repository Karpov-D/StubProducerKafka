package com.example.stub.controller;

import com.example.stub.service.StubService;
import com.example.stub.service.dto.StubDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/stubURL")
public class StubController {

    private StubService stubService;

    public StubController(StubService stubService) {
        this.stubService = stubService;
    }

    @PostMapping
    public ResponseEntity<String> stubURL(@RequestBody StubDTO stubDTO) throws ExecutionException, InterruptedException {
        stubDTO.setAge(96);
        String result = stubService.createdMassage(stubDTO);
        System.out.println(stubDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);

    }
}
