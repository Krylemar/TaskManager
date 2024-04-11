package bg.tu_varna.sit.services;

import bg.tu_varna.sit.dto.TaskDto;
import bg.tu_varna.sit.models.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    TaskDto createTask(TaskDto taskDto);
    List<TaskDto> getAllTasks();
    TaskDto getTaskById(Long id);
    TaskDto updateTask(TaskDto taskDto);
    void deleteTask(Long id);
}
