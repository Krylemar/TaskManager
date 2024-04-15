package bg.tu_varna.sit.repositories;

import bg.tu_varna.sit.models.Report;
import com.fasterxml.jackson.datatype.jsr310.deser.InstantDeserializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Instant;
import java.util.List;

@ComponentScan
public interface ReportRepository extends JpaRepository <Report, Long>{
    List<Report> findByTaskId(Long taskId);
    Report findReportByTask_Id(Long taskId);
    List<Report> getAllReportsOfTaskBetweenCreationDates(Instant firstDate, Instant secondDate);
}
