package interval_task;

import datebook.Task;
import datebook.Type;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class OneTimeTask extends Task {

    public OneTimeTask(String title, String description, Type type, LocalDateTime dateTime) {
        super(title, description, type, dateTime);
    }

    @Override
    public boolean appearsln(LocalDate dateCheck){
        return (dateCheck.isAfter(getDateTime().toLocalDate()) || dateCheck.isEqual(getDateTime().toLocalDate())) && dateCheck.getDayOfWeek() == getDateTime().getDayOfWeek();
    }
}
