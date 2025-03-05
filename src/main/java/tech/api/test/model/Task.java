package tech.api.test.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Task {
    private String id;
    private String name;
    private String description;
    private Date startDate;
    private Date endDate;

    public Task(String id, String name, String description, Date startDate, Date endDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public static Task create(String name, String description, Date startDate, Date endDate) {
        String id = UUID.randomUUID().toString();
        return new Task(id, name, description, startDate, endDate);
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public int getLate() {
        Date now = new Date();
        return (int) (now.getTime() - endDate.getTime()) % (24 * 60 * 60 * 1000);
    }

    public Object getValues() {
        Map<String, Object> values = new HashMap<>();
        values.put("id", getId());
        values.put("name", getName());
        values.put("description", getDescription());
        values.put("startDate", getStartDate());
        values.put("endDate", getEndDate());
        values.put("late", getLate());
        return values;
    }
}
