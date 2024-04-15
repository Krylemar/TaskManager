package bg.tu_varna.sit.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.context.annotation.ComponentScan;

import java.time.Instant;

@ComponentScan
@Entity
@Table(name = "reports")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Report {
    @Id
    private Long id;

    @EqualsAndHashCode.Exclude
    private String content;

    @EqualsAndHashCode.Exclude
    private int hoursLogged;

    @EqualsAndHashCode.Exclude
    @CreationTimestamp
    private Instant createdAt;

    @EqualsAndHashCode.Exclude
    @UpdateTimestamp
    private Instant updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_id", nullable = false)
    private Task task;

    @PrePersist
    protected void onCreate() {
        createdAt = Instant.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = Instant.now();
    }
}
