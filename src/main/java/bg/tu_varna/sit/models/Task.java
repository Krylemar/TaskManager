package bg.tu_varna.sit.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.context.annotation.ComponentScan;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@ComponentScan
@Entity
@Table(name = "tasks")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 40, unique = false)
    @EqualsAndHashCode.Exclude
    private String title;

    @Column(nullable = false, length = 255, unique = false)
    @EqualsAndHashCode.Exclude
    private String description;

    @Column(nullable = false)
    @EqualsAndHashCode.Exclude
    private Date deadline;

    @Setter(AccessLevel.NONE)
    @CreationTimestamp
    @EqualsAndHashCode.Exclude
    private Instant createdAt;

    @Setter(AccessLevel.PRIVATE)
    @UpdateTimestamp
    @EqualsAndHashCode.Exclude
    private Instant updatedAt;

    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Report> reports;

    @PrePersist
    protected void onCreate() {
        createdAt = Instant.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = Instant.now();
    }
}
