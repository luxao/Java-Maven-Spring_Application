package sk.stuba.fei.uim.project.User;

import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;
import sk.stuba.fei.uim.project.Contract.Contract;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;

@Data
public class User {

    @Min(1)
    @UniqueElements
    private int uid;
    @NotNull
    @NotEmpty
    private String name;
    @NotNull
    @NotEmpty
    private String surname;
    @NotNull
    @Min(1)
    private String  idNumber;
    @NotNull
    @NotEmpty
    @Email
    private String email;

    private Map<Integer, Contract> contracts = new HashMap<>();

    /**
    Adresu som sa rozhodol v tom projekte reprezentovat parametrami v userovi a potom v UserResource pre jednoduchost
     aj podla streamu kde to bolo spominane
     */

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


    public User(int uid, String name, String surname, String idNumber, String email) {
        setUid(uid);
        setName(name);
        setSurname(surname);
        setIdNumber(idNumber);
        setEmail(email);
    }

    public User() {
    }

    public User( int uid,  String name,  String surname,  String idNumber, String email,  String psc,  String city,  String street,  int houseNumber,String corPsc,  String corCity,  String corStreet,  int corHouseNumber) {
        this.uid = uid;
        this.name = name;
        this.surname = surname;
        this.idNumber = idNumber;
        this.email = email;
        this.psc = psc;
        this.city = city;
        this.street = street;
        this.corPsc = corPsc;
        this.corCity = corCity;
        this.corStreet = corStreet;
        this.houseNumber = houseNumber;
        this.corHouseNumber = corHouseNumber;
    }

    public void addContract(Contract contract){
        contracts.put(contract.getIdContract(),contract);
    }

    public Map<Integer, Contract> getContract(){
        return contracts;
    }

    public int getUid() { return uid; }

    public void setUid(int uid) {
        if (uid <=0 ){
            throw new IllegalArgumentException("uid can't by negative value\n");
        }
        this.uid = uid;
    }

    public String getName() { return name; }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("name name is entered incorrectly ");
        }
        this.name = name;
    }

    public String getSurname() { return surname; }

    public void setSurname(String surname) {
        if (surname == null || surname.trim().isEmpty()){
            throw new IllegalArgumentException("surname name is entered incorrectly ");
        }
        this.surname = surname;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        if (idNumber == null || idNumber.trim().isEmpty()){
            throw new IllegalArgumentException("surname name is entered incorrectly ");
        }
        this.idNumber = idNumber;
    }

    public String getEmail() { return email; }

    public void setEmail(String email) {
        if (email == null || email.trim().isEmpty()){
            throw new IllegalArgumentException("email name is entered incorrectly ");
        }
        this.email = email;
    }


    public Map<Integer, Contract> getUserContractList(){
        return contracts;
    }


    public void setPsc(String psc) {
        if (psc == null || psc.trim().isEmpty()){
            throw new IllegalArgumentException("email name is entered incorrectly ");
        }
        this.psc = psc;
    }

    public void setCity(String city) {
        if (city == null || city.trim().isEmpty()){
            throw new IllegalArgumentException("email name is entered incorrectly ");
        }
        this.city = city;
    }

    public void setStreet(String street) {
        if (street == null || street.trim().isEmpty()){
            throw new IllegalArgumentException("email name is entered incorrectly ");
        }
        this.street = street;
    }

    public void setCorPsc(String corPsc) {
        if (corPsc == null || corPsc.trim().isEmpty()){
            throw new IllegalArgumentException("email name is entered incorrectly ");
        }
        this.corPsc = corPsc;
    }

    public void setCorCity(String corCity) {
        if (corCity == null || corCity.trim().isEmpty()){
            throw new IllegalArgumentException("email name is entered incorrectly ");
        }
        this.corCity = corCity;
    }

    public void setCorStreet(String corStreet) {
        if (corStreet == null || corStreet.trim().isEmpty()){
            throw new IllegalArgumentException("email name is entered incorrectly ");
        }
        this.corStreet = corStreet;
    }

    public void setHouseNumber(int houseNumber) {
        if (houseNumber <=0 ){
            throw new IllegalArgumentException("uid can't by negative value\n");
        }
        this.houseNumber = houseNumber;
    }

    public void setCorHouseNumber(int corHouseNumber) {
        if (corHouseNumber <=0 ){
            throw new IllegalArgumentException("uid can't by negative value\n");
        }
        this.corHouseNumber = corHouseNumber;
    }
}
