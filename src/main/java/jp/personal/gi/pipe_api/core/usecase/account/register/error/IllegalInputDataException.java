package jp.personal.gi.pipe_api.core.usecase.account.register.error;

import jp.personal.gi.pipe_api.core.usecase.account.register.*;

public class IllegalInputDataException extends Exception {
    public IllegalInputDataException(String message) {
        super(message);
    }

    public IllegalInputDataException(String message, InputData inputData) {
        super(message + "inputData={ " + inputData.toString() + " }");
    }
}
