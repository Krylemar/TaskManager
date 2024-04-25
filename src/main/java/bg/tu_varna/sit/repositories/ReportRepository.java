package bg.tu_varna.sit.repositories;

import bg.tu_varna.sit.models.Report;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.Instant;
import java.util.List;

@ComponentScan
public interface ReportRepository extends JpaRepository <Report, Long>{
    List<Report> findByTaskId(Long taskId);
    Report findReportByTask_Id(Long taskId);
    List<Report> getAllReportsOfTaskBetweenCreationDates(Instant firstDate, Instant secondDate);

    @Query("SELECT r FROM Report r WHERE r.task.id = :taskId ORDER BY r.hoursLogged DESC")
    Report findReportWithMostHoursLogged(@Param("taskId") Long taskId);

    @Query("SELECT SUM(r.hoursLogged) FROM Report r WHERE r.task.id = :taskId")
    Integer findTotalHoursOfTask(Long taskId);
}
