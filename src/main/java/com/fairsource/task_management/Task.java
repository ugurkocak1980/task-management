package com.fairsource.task_management;

import jakarta.persistence.*;
import lombok.*;
import java.time.Instant;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Builder
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Boolean done;
    private Instant created;
    @Enumerated(EnumType.STRING)
    private Priority priority;
}
