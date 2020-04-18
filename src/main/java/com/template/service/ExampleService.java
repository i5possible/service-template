package com.template.service;

import com.template.model.Example;
import com.template.repository.ExampleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lianghongbuaa@gmail.com
 * @date 2020/4/18
 */

@Service
public class ExampleService {

    private ExampleRepository exampleRepository;

    public ExampleService(ExampleRepository exampleRepository) {
        this.exampleRepository = exampleRepository;
    }

    public List<Example> getAllExamples() {
        return exampleRepository.findAll();
    };

    public Example save(Example example) {
        return exampleRepository.save(example);
    }
}
