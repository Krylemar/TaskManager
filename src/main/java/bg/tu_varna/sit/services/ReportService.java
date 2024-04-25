package bg.tu_varna.sit.services;

import bg.tu_varna.sit.dto.ReportDto;
import bg.tu_varna.sit.dto.TaskDto;

import java.time.Instant;
import java.util.List;

public interface ReportService {
    ReportDto createReport(ReportDto reportDto);
    List<ReportDto> getAllReportsOfATask(Long taskId);
    ReportDto getReportOfTaskById(Long id);
    ReportDto updateReportOfTaskById(ReportDto reportDto);
    void deleteReportOfTaskById(Long id);
    TaskDto getTaskOfReportById(Long id);
    List<ReportDto> getReportsOfTaskBetweenDates(Long taskId, Instant firstDate, Instant secondDate);
    ReportDto getReportOfTaskWithMostHoursLogged(Long taskId);
    Integer findTotalHoursOfTask(Long taskId);
}
