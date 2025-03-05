package tech.api.test.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import tech.api.test.model.Task;

@Repository
public class MemoryTaskRepository implements TaskRepository {

    private List<Task> tasks = new ArrayList<>();

    public MemoryTaskRepository() {}

    @Override
    public void save(Task task) {
        tasks.add(task);
    }

    @Override
    public List<Task> findAll() {
        return tasks;
    }

    @Override
    public Task findById(String id) {
        int index = 0;
        for (Task task : tasks) {
            if (task.getId().equals(id)) break;
            index++;
        }
        System.out.println(index);
        return tasks.get(index);
    }

    @Override
    public void delete(String id) {
        tasks.removeIf(task -> task.getId().equals(id));
    }

}
