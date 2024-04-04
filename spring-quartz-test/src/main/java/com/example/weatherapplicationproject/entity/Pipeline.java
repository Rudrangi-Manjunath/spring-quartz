package com.example.weatherapplicationproject.entity;

import com.example.weatherapplicationproject.helper.JsonNodeConverter;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;


@Entity
@Table(name = "pipeline")
public class Pipeline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "template_type")
    private String templateType;

    @Column(name = "parameters_config", columnDefinition = "jsonb")
    @Convert(converter = JsonNodeConverter.class)
    private String parametersConfig;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "last_modified_by")
    private String lastModifiedBy;

    @Column(name = "last_modified_date")
    private LocalDateTime lastModifiedDate;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = PipelineInstance.class, mappedBy = "pipeline", fetch = FetchType.LAZY)
    private List<PipelineInstance> pipelineInstance = new LinkedList<PipelineInstance>();
}
