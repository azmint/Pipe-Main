package jp.personal.gi.pipe_api.adapter.controller.account.register;

import jp.personal.gi.pipe_api.core.usecase.account.register.*;

public class InputDataAdapter implements InputData {
    private final String name;
    private final String nameReading;
    private final Integer authority;

    public InputDataAdapter(String name, String nameReading, Integer authority) {
        this.name = name;
        this.nameReading = nameReading;
        this.authority = authority;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getNameReading() {
        return nameReading;
    }

    @Override
    public Integer getAuthority() {
        return authority;
    }
}
