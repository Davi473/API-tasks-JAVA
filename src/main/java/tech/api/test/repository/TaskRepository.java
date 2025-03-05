package tech.api.test.repository;

import java.util.List;

import tech.api.test.model.Task;


public interface TaskRepository {
    void save (Task task);
    List<Task> findAll();
    Task findById(String id);
    void delete(String id);
}
