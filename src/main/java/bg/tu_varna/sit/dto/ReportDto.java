package bg.tu_varna.sit.dto;

import lombok.*;

import java.time.Instant;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class ReportDto {
    private Long id;

    @EqualsAndHashCode.Exclude
    private String content;

    @EqualsAndHashCode.Exclude
    private int hoursLogged;

    @EqualsAndHashCode.Exclude
    private Long taskId;

    @EqualsAndHashCode.Exclude
    private Instant createdAt;

    @EqualsAndHashCode.Exclude
    private Instant updatedAt;
}
