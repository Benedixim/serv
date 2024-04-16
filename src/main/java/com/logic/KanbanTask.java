package com.logic;

public class KanbanTask {

    private Long id;
    private String title;
    private String description;
    private String status;

    public KanbanTask(Long id, String title, String description, String status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
    }

    // Геттеры и сеттеры для полей title, description и status

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void moveTask(String newStatus) {
        this.status = newStatus;
    }

    @Override
    public String toString() {
        return "Task: " + title + "\nDescription: " + description + "\nStatus: " + status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

//Люди и их взаимодействие важнее, чем рабочие процессы и инструменты.
//Функционирующий продукт важнее, чем регламенты, написание инструкций, задания.
//Сотрудничество с заказчиком важнее, чем просто подписание договора.
//Адаптивность и оперативная реакция важнее, чем слепое следование плану.
