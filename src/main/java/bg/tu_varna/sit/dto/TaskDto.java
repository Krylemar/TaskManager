package bg.tu_varna.sit.dto;
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
    private String title;
    @EqualsAndHashCode.Exclude
    private String description;
    @EqualsAndHashCode.Exclude
    private Date deadline;
}
