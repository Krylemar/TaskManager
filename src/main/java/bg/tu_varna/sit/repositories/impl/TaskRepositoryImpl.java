package bg.tu_varna.sit.repositories.impl;

import bg.tu_varna.sit.exceptions.ResourceNotFoundException;
import bg.tu_varna.sit.models.Task;
import bg.tu_varna.sit.repositories.TaskRepository;

import java.util.*;

public class TaskRepositoryImpl implements TaskRepository {
    private static TaskRepositoryImpl instance;
    private Set<Task> tasks;

    private static Long id;

    private TaskRepositoryImpl() {
        tasks = new HashSet<>();
        id = 1L;
    }

    public static TaskRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new TaskRepositoryImpl();
        }
        return instance;
    }

    @Override
    public Task createTask(Task task){
        task.setId(id++);
        tasks.add(task);
        return task;
    }

    @Override
    public List<Task> getAllTasks() {
        return new ArrayList<>(tasks);
    }

    @Override
    public Optional<Task> getTaskById(Long id) {
        for (Task task : tasks) {
            if (task.getId().equals(id)) {
                return Optional.of(task);
            }
        }
        return Optional.empty();
    }

    @Override
    public Task updateTask(Task task) {
        Task existingTask = getTaskById(task.getId()).orElseThrow(() -> new ResourceNotFoundException("Task","id",id.toString()));
        existingTask.setTitle(task.getTitle());
        existingTask.setDescription(task.getDescription());
        existingTask.setDeadline(task.getDeadline());
        return existingTask;
    }

    @Override
    public void deleteTask(Long id) {
        if (getTaskById(id).isPresent()){
            tasks.remove(getTaskById(id).get());
        }
        else throw new ResourceNotFoundException("Task","id",id.toString());
    }
}
