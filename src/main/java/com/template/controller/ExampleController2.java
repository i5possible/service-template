package com.template.controller;

import com.template.model.Example2;
import com.template.resource.Example2Resource;
import com.template.response.Example2Response;
import com.template.service.Example2Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.template.model.mapper.Example2Mapper.EXAMPLE_2_MAPPER;


@RestController
@RequestMapping("/examples2")
public class ExampleController2 {

    private Example2Service example2Service;

    public ExampleController2(Example2Service example2Service) {
        this.example2Service = example2Service;
    }

    @GetMapping("/getAll")
    public List<Example2Response> getAllExamples() {
        return example2Service.getAllExamples2().stream()
                .map(EXAMPLE_2_MAPPER::mapToResponse)
                .collect(Collectors.toList());
    }

    @PostMapping("/create")
    public Example2Response createExample(@RequestBody Example2Resource resource) {
        return EXAMPLE_2_MAPPER.mapToResponse(example2Service.save(EXAMPLE_2_MAPPER.mapResourceToModel(resource)));
    }

    @GetMapping("/getExampleById")
    public Example2Response getExample2ById(String id) {
        UUID uuid = UUID.fromString(id);
        return EXAMPLE_2_MAPPER.mapToResponse(example2Service.getExample2ById(uuid));
    }

    @PostMapping("/updateExample")
    public String updateExamples2(@RequestBody List<Example2Resource> resourceList) {
        List<Example2> examples2 = resourceList.stream().map(EXAMPLE_2_MAPPER::mapResourceToModel)
                .collect(Collectors.toList());
        example2Service.updateExamplesList(examples2);
        return "更新成功";
    }
}
