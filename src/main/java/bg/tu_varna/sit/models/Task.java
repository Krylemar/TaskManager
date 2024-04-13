package bg.tu_varna.sit.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.Date;
import java.util.List;

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

    @Getter(AccessLevel.PRIVATE)
    @Setter(AccessLevel.NONE)
    @CreationTimestamp
    @EqualsAndHashCode.Exclude
    private Instant createdAt;

    @Getter(AccessLevel.PRIVATE)
    @Setter(AccessLevel.PRIVATE)
    @UpdateTimestamp
    @EqualsAndHashCode.Exclude
    private Instant updatedAt;

    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "reports", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Report> reports;
}
