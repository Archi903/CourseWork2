package interval_task;

import datebook.Task;
import datebook.TypeOfTask;
import exception.IncorrectArgumentException;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DailyTask extends Task {


    public DailyTask(String title, String description, Type setType, LocalDateTime dateTime) throws IncorrectArgumentException {
        super(title, description, setType, dateTime);
    }

    @Override
    public boolean appearsln(LocalDate dateCheck) {
        return dateCheck.isAfter(getDateTime().toLocalDate()) || dateCheck.isEqual(getDateTime().toLocalDate());
    }
}
