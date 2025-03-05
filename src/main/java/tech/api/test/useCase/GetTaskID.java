package tech.api.test.useCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.api.test.repository.TaskRepository;

@Service
public class GetTaskID {

    private TaskRepository taskRepository;

    @Autowired
    public GetTaskID(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    
    public Object execute(String id) {
        return taskRepository.findById(id).getValues();
    }
}
