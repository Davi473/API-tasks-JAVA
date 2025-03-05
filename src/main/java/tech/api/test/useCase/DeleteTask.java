package tech.api.test.useCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.api.test.repository.TaskRepository;

@Service
public class DeleteTask {

    private TaskRepository taskRepository;

    @Autowired
    public DeleteTask(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }   

    public void execute(String id) {
        taskRepository.delete(id);
    }
}
