package ua.lviv.iot.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class Lift {
    private String manufacturer;
    private Integer liftCapacity;
    private Integer enginePower;
} 