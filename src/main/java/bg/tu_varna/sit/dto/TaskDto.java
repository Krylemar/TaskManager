package bg.tu_varna.sit.dto;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class TaskDto {
    private Long id;
    @EqualsAndHashCode.Exclude
    @NotEmpty(message = "Title cannot be empty!")
    private String title;
    @EqualsAndHashCode.Exclude
    @Size(min = 10,message = "Description must be at least 10 characters long!")
    private String description;
    @EqualsAndHashCode.Exclude
    @NotNull(message = "Deadline cannot be null!")
    private Date deadline;

    @EqualsAndHashCode.Exclude
    private Instant createdAt;

    @EqualsAndHashCode.Exclude
    private Instant updatedAt;
}
