package interval_task;

import datebook.Task;
import datebook.Type;
import exception.IncorrectArgumentException;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class YearTask extends Task {
    public YearTask(String title, String description, Type type, LocalDateTime dateTime) throws IncorrectArgumentException {
        super(title, description, type, dateTime);
    }

    @Override
    public boolean appearsln(LocalDate dateCheck){
        return (dateCheck.isAfter(getDateTime().toLocalDate()) || dateCheck.isEqual(getDateTime().toLocalDate())) && dateCheck.getDayOfYear() == getDateTime().getDayOfYear();
    }
}
