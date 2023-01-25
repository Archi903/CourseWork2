package interval_task;

import datebook.Task;
import exception.IncorrectArgumentException;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class WeeklyTask extends Task {

    public WeeklyTask(String title, String description, Type setType, LocalDateTime dateTime) throws IncorrectArgumentException {
        super(title, description, setType, dateTime);
    }

    @Override
    public boolean appearsln(LocalDate dateCheck){
        return dateCheck.isEqual(getDateTime().toLocalDate().plusWeeks(1)) || dateCheck.isEqual(getDateTime().toLocalDate().plusWeeks(1));
    }
}
