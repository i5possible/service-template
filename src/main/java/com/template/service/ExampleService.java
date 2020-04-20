package com.template.service;

import com.template.model.Example;
import com.template.repository.ExampleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author lianghongbuaa@gmail.com
 * @date 2020/4/18
 */

@Service
public class ExampleService {

    private final ExampleRepository exampleRepository;

    public ExampleService(ExampleRepository exampleRepository) {
        this.exampleRepository = exampleRepository;
    }

    public List<Example> getAllExamples() {
        return exampleRepository.findAll();
    };

    public Example save(Example example) {
        return exampleRepository.save(example);
    }

    public Optional<Example> findById(UUID id) {
        return exampleRepository.findById(id);
    }

    public Example updateExample(Example example, Example updateExample) {
        return exampleRepository.persist(example.merge(updateExample));
    }
}
