package sk.stuba.fei.uim.project.Enums;

import lombok.Getter;

@Getter
public enum TerritorialValidity {
    SLOVAKIA(1,"SLOVAKIA"),
    USA(2,"USA"),
    ASIA(3,"ASIA"),
    EUROPE(4,"EUROPE"),
    WORLD(5,"WORLD");

    private final int id;
    private final String name;

    TerritorialValidity(int id,String name) {
        this.id = id;
        this.name = name;
    }
}
