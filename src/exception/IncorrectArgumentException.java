package exception;

import datebook.Task;

public class IncorrectArgumentException extends IllegalArgumentException {


    public IncorrectArgumentException(String message) {
        super(message);
    }

}
