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
import tech.api.test.useCase.DeleteTask;
import tech.api.test.useCase.GetTask;
import tech.api.test.useCase.GetTaskID;
import tech.api.test.useCase.SaveTask;


@RestController()
@RequestMapping("/task")
public class ApiController {
    @Autowired
    private GetTask getTask;

    @Autowired
    private SaveTask saveTask;

    @Autowired
    private GetTaskID getTaskID;

    @Autowired
    private DeleteTask deleteTask;

    ApiController (
        GetTask getTask,
        SaveTask saveTask,
        GetTaskID getTaskID,
        DeleteTask deleteTask
    ) {
        this.getTask = getTask;
        this.saveTask = saveTask;
        this.getTaskID = getTaskID;
        this.deleteTask = deleteTask;
    }  

    @GetMapping()
    public ResponseEntity<Object> getTask() {
        List<Object> tasks = this.getTask.execute();
        return ResponseEntity.ok(tasks);
    }

    @PostMapping()
    public ResponseEntity<String> addTask(@RequestBody TaskDTO task) {
        saveTask.execute(task);
        return ResponseEntity.ok("Created task with sucess");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getTaskID(@PathVariable String id) {
        Object tasks = this.getTaskID.execute(id);
        return ResponseEntity.ok(tasks);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable String id) {
        deleteTask.execute(id);
        return ResponseEntity.ok("Deleted task with sucess");
    }
}
