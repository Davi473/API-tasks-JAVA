package tech.api.test.useCase;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.api.test.model.Task;
import tech.api.test.repository.TaskRepository;

@Service
public class GetTask {

    private TaskRepository taskRepository;

    @Autowired
    public GetTask(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    
    public List<Object> execute() {
        List<Task> tasks = taskRepository.findAll();
        List<Object> tasksObjects = new ArrayList<Object>();
        for (Task task : tasks) {
            tasksObjects.add(task.getValues());
        }
        return tasksObjects;
    }
}
