package bg.tu_varna.sit.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

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
    private Instant dateCreated;

    @EqualsAndHashCode.Exclude
    @UpdateTimestamp
    private Instant dateUpdated;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", nullable = false)
    private Task task;
}
