package com.backend.controller;

import com.backend.model.HistoryEvent;
import com.backend.repository.HistoryEventRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/history_events")
public class HistoryEventController {

    private final HistoryEventRepository repository;

    public HistoryEventController(HistoryEventRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<HistoryEvent> getEventsByDate(@RequestParam LocalDate date) {
        return repository.findByDate(date);
    }

    @GetMapping("/year={year}")
    public List<HistoryEvent> getEventsByYear(@PathVariable("year") int year) {
        return repository.findByYear(year);
    }
}
