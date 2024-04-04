package com.example.weatherapplicationproject.entity;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

import com.example.weatherapplicationproject.helper.JsonNodeConverter;
import com.fasterxml.jackson.databind.JsonNode;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "pipeline_instance")
public class PipelineInstance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne(targetEntity = Pipeline.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "pipeline_id", foreignKey = @ForeignKey(name = "pipeline_id_FK"), referencedColumnName = "id")
    private Pipeline pipeline;

    @Column(name = "config", columnDefinition = "jsonb")
    @Convert(converter = JsonNodeConverter.class)
    private JsonNode config;

    @Column(name = "schedule")
    private String schedule;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "synced")
    private Boolean synced;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "last_modified_by")
    private String lastModifiedBy;

    @Column(name = "last_modified_date")
    private LocalDateTime lastModifiedDate;

    @Column(name = "webhook_config", columnDefinition = "jsonb")
    @Convert(converter = JsonNodeConverter.class)
    private JsonNode webhookConfig;

    @Column(name = "quartz_schedule")
    private String quartzSchedule;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = PipelineRun.class, mappedBy = "pipelineInstance", fetch = FetchType.LAZY)
    private List<PipelineRun> pipelineRun = new LinkedList<PipelineRun>();

}

