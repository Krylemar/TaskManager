package bg.tu_varna.sit.controllers;

import bg.tu_varna.sit.dto.TaskDto;
import bg.tu_varna.sit.services.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
public class TaskController {
    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/api/tasks")
    public ResponseEntity<TaskDto> createTask(@Valid @RequestBody TaskDto task) {
        TaskDto addedTask = taskService.createTask(task);
        return new ResponseEntity<>(addedTask, HttpStatus.CREATED);
    }

    @GetMapping("/api/tasks/all")
    public ResponseEntity<List<TaskDto>> getAllTasks() {
        return new ResponseEntity<>(taskService.getAllTasks(),HttpStatus.OK);
    }

    /**
     * Handles the GET request to "/api/tasks/{id}".
     *
     * @param id The ID of the task to be retrieved.
     * @return ResponseEntity containing the Task object with the specified ID, or a 404 status code if the task doesn't exist.
     */
    @GetMapping("/api/tasks/{id}")
    public ResponseEntity<TaskDto> getTaskById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(taskService.getTaskById(id),HttpStatus.OK);
    }

    /**
     * Handles the GET request to "/api/tasks".
     *
     * @param id The ID of the task to be retrieved.
     * @return RedirectView object that redirects the user to "/api/tasks/{id}".
     */
    @GetMapping("/api/tasks")
    public RedirectView getTask(@RequestParam Long id) {
        return new RedirectView("/api/tasks/" + id);
    }

    @PutMapping("/api/tasks")
    public ResponseEntity<TaskDto> updateTask(@Valid @RequestBody TaskDto task) {
        TaskDto updatedTask = taskService.updateTask(task);
        return new ResponseEntity<>(updatedTask, HttpStatus.OK);
    }

    @DeleteMapping("/api/tasks/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable("id") Long id) {
        taskService.deleteTask(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
