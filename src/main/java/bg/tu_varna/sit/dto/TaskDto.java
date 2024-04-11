package bg.tu_varna.sit.dto;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

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
    @Min(value = 10,message = "Description must be at least 10 characters long!")
    private String description;
    @EqualsAndHashCode.Exclude
    @NotNull(message = "Deadline cannot be null!")
    private Date deadline;
}
