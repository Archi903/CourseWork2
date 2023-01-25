package datebook;

import exception.IncorrectArgumentException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public abstract class Task extends TypeOfTask {

    private String title;
    private int id;
    private LocalDateTime dateTime;
    private String description;
    private static int idGenerator = 1;
    private final Type setType;

    public Task(String title, String description, Type setType, LocalDateTime dateTime) throws IncorrectArgumentException {
        this.title = title;
        this.dateTime = dateTime;
        this.description = description;
        this.setType = setType;
        this.id = idGenerator++;
    }


    public int getIdGenerator() {
        return idGenerator;
    }

    public void setIdGenerator(int idGenerator) {
        Task.idGenerator = idGenerator;
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
                ", дата: " + dateTime + ", тип задачи - " + setType;
    }


    public abstract boolean appearsln(LocalDate dateCheck);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id && Objects.equals(title, task.title) && Objects.equals(dateTime, task.dateTime) && Objects.equals(description, task.description) && setType == task.setType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, id, dateTime, description, setType);
    }
}



