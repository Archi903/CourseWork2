package interval_task;

import datebook.Task;
import datebook.TypeOfTask;
import exception.IncorrectArgumentException;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class YearTask extends Task {
    public YearTask(String title, String description, TypeOfTask.Type setType, LocalDateTime dateTime) throws IncorrectArgumentException {
        super(title, description, setType, dateTime);
    }

    @Override
    public boolean appearsln(LocalDate dateCheck){
        return dateCheck.isEqual(getDateTime().toLocalDate().plusYears(1)) || dateCheck.isEqual(getDateTime().toLocalDate().plusYears(1));
    }
}
