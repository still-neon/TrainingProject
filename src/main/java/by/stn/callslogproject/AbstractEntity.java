package by.stn.callslogproject;

import lombok.Getter;

public abstract class AbstractEntity implements MyEntity {
    @Getter
    private long id;

    public AbstractEntity(long id) {
        this.id = id;
    }
}