package by.stn.callslogproject;

import lombok.Getter;

public abstract class AbstractEntity implements Entity {
    @Getter
    private Long id;

    public AbstractEntity(Long id) {
        this.id = id;
    }
}