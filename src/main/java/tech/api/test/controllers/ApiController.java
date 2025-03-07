package tech.api.test.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tech.api.test.dto.TaskDTO;
import tech.api.test.service.TaskService;

@RestController()
@RequestMapping("/task")
public class ApiController {
    @Autowired
    private TaskService taskService;

    ApiController (
        TaskService taskService
    ) {
        this.taskService = taskService;
    }  

    @GetMapping()
    public ResponseEntity<Object> getTask() {
        List<Object> tasks = this.taskService.get();
        return ResponseEntity.ok(tasks);
    }

    @PostMapping()
    public ResponseEntity<String> addTask(@RequestBody TaskDTO task) {
        this.taskService.save(task);
        return ResponseEntity.ok("Created task with sucess");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getTaskID(@PathVariable String id) {
        Object tasks = this.taskService.getById(id);
        return ResponseEntity.ok(tasks);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable String id) {
        this.taskService.delete(id);
        return ResponseEntity.ok("Deleted task with sucess");
    }
}
