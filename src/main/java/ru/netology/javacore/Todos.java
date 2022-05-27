package ru.netology.javacore;

import java.util.*;

public class Todos {
    private List<String> allTasks;

    public Todos() {
        this.allTasks = new ArrayList<>();
    }

    public void addTask(String task) {
        this.allTasks.add(task);
    }

    public void removeTask(String task) {
        this.allTasks.remove(task);
    }

    public void setAllTasks(List<String> allTasks) {
        this.allTasks = allTasks;
    }

    public List<String> getAllTasksAsList() {
        return this.allTasks;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Todos)) return false;
        Todos todos = (Todos) obj;
        return getAllTasks().equals(todos.getAllTasks());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAllTasks());
    }

    @Override
    public String toString() {
        return "Todos { " +
                " allTasks = " + allTasks +
                " }";
    }

    public String getAllTasks() {
        Collections.sort(this.allTasks);
        StringBuilder sb = new StringBuilder();
        for (String task : this.allTasks) {
            sb.append(task);
            sb.append(" ");
        }
        return sb.toString();
    }

}
