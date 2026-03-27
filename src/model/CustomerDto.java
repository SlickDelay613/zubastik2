package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDto {
    String id;
    String name;

    public CustomerDto(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
