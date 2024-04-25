package bg.tu_varna.sit.controllers;

import bg.tu_varna.sit.dto.TaskDto;
import bg.tu_varna.sit.models.Report;
import bg.tu_varna.sit.services.ReportService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import bg.tu_varna.sit.dto.ReportDto;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.time.Instant;
import java.util.List;

@RestController
public class ReportController {
    private ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @PostMapping("/api/reports")
    public ResponseEntity<ReportDto> createReport(@RequestBody ReportDto report){
        ReportDto createdReport = reportService.createReport(report);
        return new ResponseEntity<>(createdReport, HttpStatus.CREATED);
    }

    /**
     * This method is a GET request mapping that is used to retrieve all reports of a task.
     * It is mapped to the "/api/task/reports" URL and expects a task ID as a request parameter.
     * The method returns a RedirectView object, which can be used to redirect the user to another URL.
     *
     * @param taskId The ID of the task for which the reports are to be retrieved. This is a required request parameter.
     * @return A RedirectView object which can be used to redirect the user to another URL.
     */
    @GetMapping("/api/task/reports")
    public RedirectView getAllReportsOfTask(@RequestParam("task_id") Long taskId){
        return new RedirectView("/api/task/" + taskId + "/reports");
    }

    /**
     * This method is a GET request mapping that is used to retrieve all reports of a specific task by its ID.
     * It is mapped to the "/api/task/{taskId}/reports" URL and expects a task ID as a path variable.
     * The method returns a ResponseEntity object containing a list of ReportDto objects and an HTTP status code.
     *
     * @param taskId The ID of the task for which the reports are to be retrieved. This is a required path variable.
     * @return A ResponseEntity object containing a list of ReportDto objects and an HTTP status code.
     */
    @GetMapping("/api/task/{taskId}/reports")
    public ResponseEntity<List<ReportDto>> getReportsOfTaskById(@PathVariable Long taskId){
        return new ResponseEntity<>(reportService.getAllReportsOfATask(taskId), HttpStatus.OK);
    }

    @GetMapping("/api/task/reports")
    public RedirectView getReportOfTaskByIdRedirect(@RequestParam("report_id") Long reportId){
        TaskDto taskDto = reportService.getTaskOfReportById(reportId);
        return new RedirectView("/api/task/" + taskDto.getId() + "/reports/" + reportId);
    }

    @GetMapping("/api/task/{taskId}/reports/{reportId}")
    public ResponseEntity<ReportDto> getReportOfTaskById(@PathVariable("taskId") Long taskId, @PathVariable("reportId") Long reportId){
        return new ResponseEntity<>(reportService.getReportOfTaskById(reportId), HttpStatus.OK);
    }


    @PutMapping("/api/reports")
    public ResponseEntity<ReportDto> updateReport(@RequestBody ReportDto report){
        ReportDto updatedReport = reportService.updateReportOfTaskById(report);
        return new ResponseEntity<>(updatedReport, HttpStatus.OK);
    }

    @DeleteMapping("/api/reports")
    public ResponseEntity<Void> deleteReport(@RequestParam Long id){
        reportService.deleteReportOfTaskById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //Get all reports of a task with hours logged within a specific date range
    @GetMapping()
    public ResponseEntity<List<ReportDto>> getReportsOfTaskBetweenDates(Long taskId, Instant firstDate, Instant secondDate){
        List<ReportDto> reports = reportService.getReportsOfTaskBetweenDates(taskId, firstDate, secondDate);
        return new ResponseEntity<>(reports, HttpStatus.OK);
    }

    //- Get the report of a task with the most hours logged
    @GetMapping
    public ResponseEntity<ReportDto> getReportOfTaskWithMostHoursLogged(Long taskId){
        ReportDto report = reportService.getReportOfTaskWithMostHoursLogged(taskId);
        return new ResponseEntity<>(report, HttpStatus.OK);
    }

    //- Get total hours logged for a task by id
    @GetMapping
    public ResponseEntity<Integer> getTotalHoursOfATaskById(Long taskId){
        Integer hours = reportService.findTotalHoursOfTask(taskId);
        return new ResponseEntity<>(hours, HttpStatus.OK);
    }
}
