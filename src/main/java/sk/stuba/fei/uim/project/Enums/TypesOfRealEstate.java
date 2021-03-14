package sk.stuba.fei.uim.project.Enums;

import lombok.Getter;

@Getter
public enum TypesOfRealEstate {
    FLAT(1,"FLAT"),
    BRICK_HOUSE_FAMILY(2,"BRICK HOUSE FAMILY"),
    WOOD_HOUSE_FAMILY(3,"WOOD HOUSE FAMILY");

    private final int id;
    private final String name;

    TypesOfRealEstate(int id,String name) {
        this.id = id;
        this.name = name;
    }
}
