package com.backend.repository;

import com.backend.model.HistoryEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface HistoryEventRepository extends JpaRepository<HistoryEvent, Long> {
    List<HistoryEvent> findByDate(LocalDate date);

    @Query(value = "SELECT * FROM history_events WHERE EXTRACT(DAY FROM date) = :day", nativeQuery = true)
    List<HistoryEvent> findByDay(@Param("day") int day);

    @Query(value = "SELECT * FROM history_events WHERE EXTRACT(MONTH FROM date) = :month", nativeQuery = true)
    List<HistoryEvent> findByMonth(@Param("month") int month);

    @Query(value = "SELECT * FROM history_events WHERE EXTRACT(YEAR FROM date) = :year", nativeQuery = true)
    List<HistoryEvent> findByYear(@Param("year") int year);
}
