package bg.tu_varna.sit.services.impl;

import bg.tu_varna.sit.dto.ReportDto;
import bg.tu_varna.sit.dto.TaskDto;
import bg.tu_varna.sit.exceptions.ResourceNotFoundException;
import bg.tu_varna.sit.models.Report;
import bg.tu_varna.sit.models.Task;
import bg.tu_varna.sit.repositories.ReportRepository;
import bg.tu_varna.sit.services.ReportService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService{
    private ReportRepository reportRepository;
    private ModelMapper mapper;

    public ReportServiceImpl(ReportRepository reportRepository, ModelMapper mapper) {
        this.reportRepository = reportRepository;
        this.mapper = mapper;
    }
    @Override
    public ReportDto createReport(ReportDto reportDto) {
        return report2Dto(reportRepository.save(dto2Report(reportDto)));
    }

    @Override
    public List<ReportDto> getAllReportsOfATask(Long taskId) {
        return reportRepository.findByTaskId(taskId).stream().map(this::report2Dto).toList();
    }

    //Instructions unclear: Don't know if I should get just report by Id or a report of a task by taskId and reportId
    @Override
    public ReportDto getReportOfTaskById(Long id) {
        return report2Dto(reportRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Report","id",id.toString())));
    }

    @Override
    public ReportDto updateReportOfTaskById(ReportDto reportDto) {
        Report existingReport = reportRepository.findById(reportDto.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Report","id",reportDto.getId().toString()));
        mapper.map(reportDto, existingReport);

        return report2Dto(reportRepository.save(existingReport));
    }

    @Override
    public void deleteReportOfTaskById(Long id) {
        reportRepository.deleteById(id);
    }

    @Override
    public TaskDto getTaskOfReportById(Long id) {
        return reportRepository.findByTaskId(id).stream().findFirst().map(report -> mapper.map(report.getTask(), TaskDto.class)).orElseThrow(() -> new ResourceNotFoundException("Task","id",id.toString()));
    }

    @Override
    public List<ReportDto> getReportsOfTaskBetweenDates(Long taskId, Instant firstDate, Instant secondDate) {
        return reportRepository.getAllReportsOfTaskBetweenCreationDates(firstDate, secondDate).stream().map(this::report2Dto).toList();
    }

    @Override
    public ReportDto getReportOfTaskWithMostHoursLogged(Long taskId) {
        return report2Dto(reportRepository.findReportWithMostHoursLogged(taskId));
    }

    @Override
    public Integer findTotalHoursOfTask(Long taskId){
        return reportRepository.findTotalHoursOfTask(taskId);
    }

    private Report dto2Report (ReportDto reportDto){
        return mapper.map(reportDto, Report.class);
    }

    private ReportDto report2Dto (Report report) {
        ReportDto reportDto = mapper.map(report, ReportDto.class);
        reportDto.setCreatedAt(report.getCreatedAt());
        reportDto.setUpdatedAt(report.getUpdatedAt());
        return reportDto;
    }
}
