package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

@Service
public class StreamingService {
    @Autowired
    private ResourceLoader resourceLoader;

    public Mono<Resource> getVideo(String title){
        return Mono.fromSupplier( () -> resourceLoader.getResource(String.format("classpath:video/%s.mp4", title)));
    }
}
