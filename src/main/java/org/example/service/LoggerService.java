package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.entity.Logger_Table;
import org.example.repository.LoggerRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoggerService {
    public final LoggerRepository repository;
        public Logger_Table logger(Logger_Table log){
            return repository.save(log);
        }
}
