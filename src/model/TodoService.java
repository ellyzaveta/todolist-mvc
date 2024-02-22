package model;

import model.data.Task;

import javax.swing.*;

public class TodoService {

    private final DefaultListModel<Task> tasks = new DefaultListModel<>();

    public DefaultListModel<Task> getAll() {
        return tasks;
    }

    public void add(Task task) {
        tasks.addElement(task);
    }

    public void remove(int index) {
        tasks.remove(index);
    }

    public void updateStatus(int index) {
        Task task = tasks.get(index);
        task.setNextStatus();
        tasks.set(index, task);
    }
}
