package bg.tu_varna.sit.services.impl;

import bg.tu_varna.sit.exceptions.TaskNotFoundException;
import bg.tu_varna.sit.models.Task;
import bg.tu_varna.sit.repositories.TaskRepository;
import bg.tu_varna.sit.repositories.impl.TaskRepositoryImpl;
import bg.tu_varna.sit.services.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {
    private TaskRepository taskRepository;

    public TaskServiceImpl() {
        this.taskRepository = TaskRepositoryImpl.getInstance();
    }

    @Override
    public Task createTask(Task task) {
        return taskRepository.createTask(task);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.getAllTasks();
    }

    @Override
    public Optional<Task> getTaskById(Long id) {
        Optional<Task> task = taskRepository.getTaskById(id);
        if (task.isEmpty()) {
            throw new TaskNotFoundException("Task with id " + id + " not found");
        }
        return task;
    }

    @Override
    public Task updateTask(Task task) {
        return taskRepository.updateTask(task);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteTask(id);
    }
}
