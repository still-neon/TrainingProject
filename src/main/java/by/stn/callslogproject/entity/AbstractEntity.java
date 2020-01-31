package by.stn.callslogproject.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbstractEntity implements Entity {
    private Long id;

    public AbstractEntity(Long id) {
        this.id = id;
    }
}