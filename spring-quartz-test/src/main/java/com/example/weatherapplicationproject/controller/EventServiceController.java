package com.example.weatherapplicationproject.controller;

import com.example.weatherapplicationproject.repository.PipelineInstanceRepository;
import com.example.weatherapplicationproject.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pipelineInstance")
public class EventServiceController {

    @Autowired
    private PipelineInstanceRepository pipelineInstanceRepository;

    @Autowired
    private EventService eventService;

    @PostMapping("/create")
    public void createPipelineInstance() {


    }
}
