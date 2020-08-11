package com.prime.proxy;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PrimeNumbersRetrieverController {

    @GetMapping("/prime/{limit}")
    public List<Integer> retrieve(@PathVariable Integer limit) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("0.0.0.0", 8082)
                .usePlaintext()
                .build();
        PrimeNumbersRetrieverServiceGrpc.PrimeNumbersRetrieverServiceBlockingStub stub = PrimeNumbersRetrieverServiceGrpc.newBlockingStub(channel);
        PrimeNumberSequenceResponse response = stub.retrieve(PrimeNumberSequenceRequest.newBuilder().setLimit(limit).build());
        return response.getNumbersList();
    }

}
