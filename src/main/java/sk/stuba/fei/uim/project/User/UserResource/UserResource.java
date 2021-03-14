package sk.stuba.fei.uim.project.User.UserResource;

import lombok.Data;
import sk.stuba.fei.uim.project.User.User;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class UserResource {

    @NotNull
    @Min(1)
    private int uid  = 1;
    @NotNull
    @NotEmpty
    private String name;
    @NotNull
    @NotEmpty
    private String surname;
    @NotNull
    @NotEmpty
    private String  idNumber;
    @NotNull
    @NotEmpty
    @Email
    private String email;
    @NotNull
    @NotEmpty
    private String psc;
    @NotNull
    @NotEmpty
    private String city;
    @NotNull
    @NotEmpty
    private String street;
    @NotNull
    @NotEmpty
    private String corPsc;
    @NotNull
    @NotEmpty
    private String corCity;
    @NotNull
    @NotEmpty
    private String corStreet;
    @NotNull
    @Min(1)
    private int houseNumber;
    @NotNull
    @Min(1)
    private int corHouseNumber;


    public UserResource() {
    }


    public UserResource(User user) {
        this.uid = user.getUid();
        this.name = user.getName();
        this.surname = user.getSurname();
        this.idNumber = user.getIdNumber();
        this.email = user.getEmail();
        this.psc = user.getPsc();
        this.city = user.getCity();
        this.street = user.getStreet();
        this.houseNumber = user.getHouseNumber();
        this.corPsc = user.getCorPsc();
        this.corCity = user.getCorCity();
        this.corStreet = user.getCorStreet();
        this.corHouseNumber = user.getCorHouseNumber();
    }

   public User toUser(int uid) {
        return new User(
                uid,
                name,
                surname,
                idNumber,
                email,
                psc,
                city,
                street,
                houseNumber,
                corPsc,
                corCity,
                corStreet,
                corHouseNumber
        );
    }
}
