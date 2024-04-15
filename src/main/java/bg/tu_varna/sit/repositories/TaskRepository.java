package bg.tu_varna.sit.repositories;

import bg.tu_varna.sit.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository <Task, Long>{
}
