package com.backend.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "history_events")
@Data
public class HistoryEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;
    private String title;
    @Column(columnDefinition = "TEXT")
    private String description;
    private String country;
    private Double latitude;
    private Double longitude;
    private String category;
}