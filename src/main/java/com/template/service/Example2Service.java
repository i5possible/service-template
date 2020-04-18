package com.template.service;

import com.template.model.Example;
import com.template.model.Example2;
import com.template.repository.Example2Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author lianghongbuaa@gmail.com
 * @date 2020/4/18
 */

@Service
public class Example2Service {

    private Example2Repository example2Repository;

    public Example2Service(Example2Repository example2Repository) {
        this.example2Repository = example2Repository;
    }

    public List<Example2> getAllExamples2() {
        return example2Repository.findAll();
    }

    public Example2 getExample2ById(UUID id){
        return example2Repository.findById(id).orElse(null);
    }

    public void updateExamplesList(List<Example2> example2List){
        for (Example2 example2: example2List) {
            example2Repository.save(example2);
        }
    }

    public Example2 save(Example2 example2) {
        return example2Repository.save(example2);
    }

}
