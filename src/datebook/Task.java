package datebook;

import exception.IncorrectArgumentException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;


public abstract class Task {

    private String title;
    private int id;
    private LocalDateTime dateTime;
    private String description;
    private static int idGenerator = 1;
    private final Type type;

    public Task(String title, String description, Type type, LocalDateTime dateTime) {
        if (title.isBlank() || title.isEmpty()) {
            throw new IncorrectArgumentException("Строка пустая");
        } else {
            this.title = title;
        }
        this.dateTime = dateTime;
        if (description.isBlank() || description.isEmpty()) {
            throw new IncorrectArgumentException("Строка пустая");
        } else {
            this.description = description;
        }
        this.type = type;
        this.id = idGenerator++;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public String toString() {
        return "Task: " + " id: " + id +
                ", Название - " + title +
                ", описание - " + description +
                ", дата: " + dateTime + ", тип задачи - " + type;
    }


    public abstract boolean appearsln(LocalDate dateCheck);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id && Objects.equals(title, task.title) && Objects.equals(dateTime, task.dateTime) && Objects.equals(description, task.description) && type == task.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, id, dateTime, description, type);
    }
}



