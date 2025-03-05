package tech.api.test.useCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.api.test.dto.TaskDTO;
import tech.api.test.model.Task;
import tech.api.test.repository.TaskRepository;

@Service
public class SaveTask {

    private TaskRepository taskRepository;

    @Autowired
    public SaveTask(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }   

    public void execute(TaskDTO taskDTO) {
        Task createTask = Task.create(taskDTO.name, taskDTO.description, taskDTO.startDate, taskDTO.endDate);
        taskRepository.save(createTask);
    }
}
