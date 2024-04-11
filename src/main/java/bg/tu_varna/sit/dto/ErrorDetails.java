package bg.tu_varna.sit.dto;

import java.util.Date;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDetails {
    private Date date;
    private String message;
}
