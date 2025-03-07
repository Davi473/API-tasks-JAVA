package tech.api.test.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.api.test.dto.TaskDTO;
import tech.api.test.model.Task;
import tech.api.test.repository.TaskRepository;

@Service
public class TaskService {
    private TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    
    public void save(TaskDTO taskDTO) {
        Task createTask = Task.create(taskDTO.name, taskDTO.description, taskDTO.startDate, taskDTO.endDate);
        taskRepository.save(createTask);
    }

    public Object getById(String id) {
        return taskRepository.findById(id).getValues();
    }

    public List<Object> get() {
        List<Task> tasks = taskRepository.findAll();
        List<Object> tasksObjects = new ArrayList<Object>();
        for (Task task : tasks) {
            tasksObjects.add(task.getValues());
        }
        return tasksObjects;
    }

    public void delete(String id) {
        taskRepository.delete(id);
    }
}
