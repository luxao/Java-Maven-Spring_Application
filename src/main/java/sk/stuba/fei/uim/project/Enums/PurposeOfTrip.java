package sk.stuba.fei.uim.project.Enums;

import lombok.Getter;

@Getter
public enum PurposeOfTrip {
    ON_BUSINESS(1,"ON_BUSINESS"),
    ON_HOLIDAY(2,"ON_HOLIDAY"),
    SPORT(3,"SPORT");

    private final int id;
    private final String name;

    PurposeOfTrip(int id,String name) {
        this.id = id;
        this.name = name;
    }
}
