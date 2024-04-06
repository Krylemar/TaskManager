package bg.tu_varna.sit.services;

import bg.tu_varna.sit.models.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    Task createTask(Task task);
    List<Task> getAllTasks();
    Optional<Task> getTaskById(Long id);
    Task updateTask(Task task);
    void deleteTask(Long id);
}
