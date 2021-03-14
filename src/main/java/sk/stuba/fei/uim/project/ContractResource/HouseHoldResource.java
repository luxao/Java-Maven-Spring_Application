package sk.stuba.fei.uim.project.ContractResource;

import lombok.Data;
import lombok.NoArgsConstructor;
import sk.stuba.fei.uim.project.Contract.NonLifeInsurance.HouseHoldInsurance;
import sk.stuba.fei.uim.project.Enums.TypesOfRealEstate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDateTime;
@Data
@NoArgsConstructor
public class HouseHoldResource {
    @NotNull
    @Min(1)
    private int idContract;
    @NotNull
    @PastOrPresent
    private LocalDateTime dateTime;
    @NotNull
    private String insurer;
    @NotNull
    private String insured;
    @NotNull
    @PastOrPresent
    @NotEmpty
    private LocalDateTime dateStart;
    @NotNull
    @PastOrPresent
    @NotEmpty
    private LocalDateTime dateEnd;
    @NotNull
    @Min(1)
    private float highAmount;
    @NotNull
    @Min(1)
    private float monthPayment;
    @NotNull
    @NotEmpty
    private String nameOfContract;
    @NotNull
    @Min(1)
    private float valueOfHouse;
    @NotNull
    @Min(1)
    private float houseEquipment;
    @NotNull
    private TypesOfRealEstate typesOfRealEstate;

    public HouseHoldResource(HouseHoldInsurance houseHoldInsurance){
        this.idContract = houseHoldInsurance.getIdContract();
        this.dateTime = houseHoldInsurance.getDateTime();
        this.insurer = houseHoldInsurance.getInsurer();
        this.dateStart = houseHoldInsurance.getDateStart();
        this.dateEnd = houseHoldInsurance.getDateEnd();
        this.highAmount = houseHoldInsurance.getHighAmount();
        this.monthPayment = houseHoldInsurance.getMonthPayment();
        this.valueOfHouse = houseHoldInsurance.getValueOfHouse();
        this.houseEquipment = houseHoldInsurance.getHouseEquipment();
        this.nameOfContract = houseHoldInsurance.getNameOfContract();
        this.typesOfRealEstate = houseHoldInsurance.getTypesOfRealEstate();
    }

    public HouseHoldInsurance toHouseHold(int idContract) {
        return new HouseHoldInsurance(
                idContract,
                insurer,
                dateTime,
                dateStart,
                dateEnd,
                highAmount,
                monthPayment,
                valueOfHouse,
                typesOfRealEstate,
                houseEquipment
        );
    }
}
