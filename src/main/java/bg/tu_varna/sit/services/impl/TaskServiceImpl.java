package bg.tu_varna.sit.services.impl;

import bg.tu_varna.sit.dto.TaskDto;
import bg.tu_varna.sit.exceptions.ResourceNotFoundException;
import bg.tu_varna.sit.models.Task;
import bg.tu_varna.sit.repositories.TaskRepository;
import bg.tu_varna.sit.services.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TaskServiceImpl implements TaskService {
    private TaskRepository taskRepository;
    private ModelMapper mapper;

    public TaskServiceImpl(TaskRepository taskRepository, ModelMapper mapper) {
        this.taskRepository = taskRepository;
        this.mapper = mapper;
    }

    @Override
    public TaskDto createTask(TaskDto taskDto) {
        Task task = taskRepository.save(dto2Task(taskDto));
        return task2Dto(task);
    }

    @Override
    public List<TaskDto> getAllTasks() {
        return taskRepository.findAll().stream().map(this::task2Dto).toList();
    }

    @Override
    public TaskDto getTaskById(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Task","id",id.toString()));
        return task2Dto(task);
    }

    @Override
    public TaskDto updateTask(TaskDto taskDto) {
        Task existingTask = taskRepository.findById(taskDto.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Task","id",taskDto.getId().toString()));
        mapper.map(taskDto, existingTask);

        return task2Dto(taskRepository.save(existingTask));
    }

    @Override
    public void deleteTask(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Task","id",id.toString()));
        taskRepository.delete(task);
    }

    private Task dto2Task (TaskDto taskDto){
        return mapper.map(taskDto, Task.class);

    }

    private TaskDto task2Dto (Task task){
        TaskDto taskDto = mapper.map(task, TaskDto.class);
        taskDto.setCreatedAt(task.getCreatedAt());
        taskDto.setUpdatedAt(task.getUpdatedAt());
        return taskDto;
    }
}
