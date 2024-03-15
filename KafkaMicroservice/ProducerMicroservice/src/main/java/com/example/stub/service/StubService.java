package com.example.stub.service;

import com.example.stub.service.dto.StubDTO;

import java.util.concurrent.ExecutionException;

public interface StubService {

    String createdMassage(StubDTO stubDTO) throws ExecutionException, InterruptedException;
}
