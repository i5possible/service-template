package com.template.controller;

import com.template.resource.ExampleResource;
import com.template.response.ExampleResponse;
import com.template.service.ExampleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static com.template.model.mapper.ExampleMapper.MAPPER;

/**
 * @author lianghongbuaa@gmail.com
 * @date 2020/4/18
 */

@RestController
@RequestMapping("examples")
public class ExampleController {

    private ExampleService exampleService;

    public ExampleController(ExampleService exampleService) {
        this.exampleService = exampleService;
    }

    @GetMapping("/all")
    public List<ExampleResponse> getAllExamples() {
        return exampleService.getAllExamples().stream()
                .map(MAPPER::mapToResponse)
                .collect(Collectors.toList());
    }

    @PostMapping
    public ExampleResponse createExample(@RequestBody ExampleResource resource) {
        return MAPPER.mapToResponse(exampleService.save(MAPPER.mapResourceToModel(resource)));
    }
}
