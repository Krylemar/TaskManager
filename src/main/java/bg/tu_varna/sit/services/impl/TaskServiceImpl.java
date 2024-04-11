package bg.tu_varna.sit.services.impl;

import bg.tu_varna.sit.dto.TaskDto;
import bg.tu_varna.sit.exceptions.ResourceNotFoundException;
import bg.tu_varna.sit.models.Task;
import bg.tu_varna.sit.repositories.TaskRepository;
import bg.tu_varna.sit.repositories.impl.TaskRepositoryImpl;
import bg.tu_varna.sit.services.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {
    private TaskRepository taskRepository;
    private ModelMapper mapper;

    public TaskServiceImpl(ModelMapper mapper) {
        this.taskRepository = TaskRepositoryImpl.getInstance();
        this.mapper = mapper;
    }

    @Override
    public TaskDto createTask(TaskDto taskDto) {
        Task task = mapper.map(taskDto, Task.class);
        Task addedTask = taskRepository.createTask(task);
        return mapper.map(addedTask, taskDto.getClass());
    }

    @Override
    public List<TaskDto> getAllTasks() {
        List<TaskDto> tasks = new ArrayList<>();
        for (Task task : taskRepository.getAllTasks()){
            tasks.add(task2Dto(task));
        }
        return tasks;
    }

    @Override
    public TaskDto getTaskById(Long id) {
        Task task = taskRepository.getTaskById(id).orElseThrow(() -> new ResourceNotFoundException("Task","id",id.toString()));
        return task2Dto(task);
    }

    @Override
    public TaskDto updateTask(TaskDto taskDto) {
        Task task = dto2Task(taskDto);
        task = taskRepository.updateTask(task);
        return task2Dto(task);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteTask(id);
    }

    private Task dto2Task (TaskDto taskDto){
        return mapper.map(taskDto, Task.class);
    }

    private TaskDto task2Dto (Task task){
        return mapper.map(task, TaskDto.class);
    }
}
