package com.template.controller;

import com.template.model.Example;
import com.template.service.ExampleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author lianghongbuaa@gmail.com
 * @date 2020/4/18
 */

@Controller
@RequestMapping("examples")
public class ExampleController {

    private ExampleService exampleService;

    public ExampleController(ExampleService exampleService) {
        this.exampleService = exampleService;
    }

    @GetMapping
    public String show(Model model){
        List<Example> allExamples = exampleService.getAllExamples();
        model.addAttribute("examples",allExamples);
        return "examples";
    }
}
