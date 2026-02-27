package org.example.expert.domain.todo.repository;

import org.example.expert.domain.todo.entity.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.Optional;

public interface TodoRepository extends JpaRepository<Todo, Long>, TodoCustomRepository {

    @Query("SELECT t FROM Todo t LEFT JOIN FETCH t.user u ORDER BY t.modifiedAt DESC")
    Page<Todo> findAllByOrderByModifiedAtDesc(Pageable pageable);

    // 날씨 조건만 검색
    @Query("SELECT t FROM Todo t WHERE t.weather = :weather")
    Page<Todo> findAllByWeather(String weather, Pageable pageable);

    // 수정일 기준으로만 검색
    @Query("SELECT t FROM Todo t WHERE t.modifiedAt BETWEEN :startDate AND :endDate")
    Page<Todo> findAllByModifiendAtBETWEEN(
            @Param("startDate")LocalDateTime startDate,
            @Param("endDate")LocalDateTime endDate,
            Pageable pageable
            );
}
