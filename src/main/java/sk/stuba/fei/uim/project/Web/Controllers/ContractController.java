package sk.stuba.fei.uim.project.Web.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.uim.project.Contract.Contract;
import sk.stuba.fei.uim.project.Contract.LifeInsurance.AccidentInsurance;
import sk.stuba.fei.uim.project.Enums.PurposeOfTrip;
import sk.stuba.fei.uim.project.Enums.TerritorialValidity;
import sk.stuba.fei.uim.project.Contract.LifeInsurance.TravelInsurance;
import sk.stuba.fei.uim.project.Contract.NonLifeInsurance.HouseApartmentInsurance;
import sk.stuba.fei.uim.project.Contract.NonLifeInsurance.HouseHoldInsurance;
import sk.stuba.fei.uim.project.Enums.TypesOfRealEstate;
import sk.stuba.fei.uim.project.ContractResource.AccidentResource;
import sk.stuba.fei.uim.project.ContractResource.ApartmentResource;
import sk.stuba.fei.uim.project.ContractResource.HouseHoldResource;
import sk.stuba.fei.uim.project.ContractResource.TravelResource;
import sk.stuba.fei.uim.project.Functionality.Service.ContractService;
import sk.stuba.fei.uim.project.Functionality.Service.UserService;
import sk.stuba.fei.uim.project.User.UserResource.UserResource;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/user/")
public class ContractController {

    private final ContractService contractService;
    private  final UserService userService;

    @Autowired
    public ContractController(ContractService contractService, UserService userService) {
        this.contractService = contractService;
        this.userService = userService;
    }


    @GetMapping("uid/{uid}/contract/{idContract}")
    public String byI(@PathVariable int uid, @PathVariable int idContract, Model model) {
        Optional<Contract> contractById1 = contractService.findUserContractById(uid,idContract);
        if (contractById1.isPresent()) {
            Contract contract =  contractById1.get();
            if(contract instanceof AccidentInsurance){
                model.addAttribute("user",new UserResource(userService.getUserList().get(uid)));
                model.addAttribute("users",userService.getUserList());
                model.addAttribute("accidentInsurance", (AccidentInsurance) contract);
                return  "user/contract/one1";
            }
            if(contract instanceof TravelInsurance){
                model.addAttribute("user",new UserResource(userService.getUserList().get(uid)));
                model.addAttribute("users",userService.getUserList());
                model.addAttribute("travelInsurance", (TravelInsurance) contract);
                return  "user/contract/one2";
            }
            if(contract instanceof HouseApartmentInsurance){
                model.addAttribute("user",new UserResource(userService.getUserList().get(uid)));
                model.addAttribute("users",userService.getUserList());
                model.addAttribute("houseApartmentInsurance", (HouseApartmentInsurance) contract);
                return  "user/contract/one3";
            }
            model.addAttribute("user",new UserResource(userService.getUserList().get(uid)));
            model.addAttribute("users",userService.getUserList());
            model.addAttribute("houseHoldInsurance", (HouseHoldInsurance) contract);
            return  "user/contract/one4";
        }
        return  "user/one";
    }


    @GetMapping("/contract/add1/{uid}")
    public String addForm1(@PathVariable int uid,Model model) {
        model.addAttribute("user",new UserResource(userService.getUserList().get(uid)));
        model.addAttribute("accidentInsurance",new AccidentResource());
        model.addAttribute("users",userService.getUserList());
        model.addAttribute("territorialValidity", TerritorialValidity.values());
        return "user/contract/add1";
    }

    @GetMapping("/contract/add2/{uid}")
    public String addForm2(@PathVariable int uid,Model model) {
        model.addAttribute("user",new UserResource(userService.getUserList().get(uid)));
        model.addAttribute("travelInsurance",new TravelResource());
        model.addAttribute("users",userService.getUserList());
        model.addAttribute("purposeOfTrip", PurposeOfTrip.values());
        return "user/contract/add2";
    }
    @GetMapping("/contract/add3/{uid}")
    public String addForm3(@PathVariable int uid,Model model) {
        model.addAttribute("user",new UserResource(userService.getUserList().get(uid)));
        model.addAttribute("houseApartmentInsurance",new ApartmentResource());
        model.addAttribute("users",userService.getUserList());
        model.addAttribute("typesOfRealEstate", TypesOfRealEstate.values());
        return "user/contract/add3";
    }

    @GetMapping("/contract/add4/{uid}")
    public String addForm4(@PathVariable int uid,Model model) {
        model.addAttribute("user",new UserResource(userService.getUserList().get(uid)));
        model.addAttribute("houseHoldInsurance",new HouseHoldResource());
        model.addAttribute("users",userService.getUserList());
        model.addAttribute("typesOfRealEstate", TypesOfRealEstate.values());
        return "user/contract/add4";
    }

    @PostMapping("/contract/add1/{uid}")
    public String addSubmit1(@PathVariable int uid,@ModelAttribute @Valid AccidentResource accidentResource, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user/contract/add1";
        }
        AccidentInsurance accidentInsurance = new AccidentInsurance();
        accidentInsurance.setIdContract(accidentResource.getIdContract());
        accidentInsurance.setDateTime(accidentResource.getDateTime());
        accidentInsurance.setInsurer(accidentResource.getInsurer());
        accidentInsurance.setInsured(accidentResource.getInsured());
        accidentInsurance.setDateStart(accidentResource.getDateStart());
        accidentInsurance.setDateEnd(accidentResource.getDateEnd());
        accidentInsurance.setHighAmount(accidentResource.getHighAmount());
        accidentInsurance.setMonthPayment(accidentResource.getMonthPayment());
        accidentInsurance.setPermanentConsequences(accidentResource.getPermanentConsequences());
        accidentInsurance.setDeathConsequences(accidentResource.getDeathConsequences());
        accidentInsurance.setDayHospitalization(accidentResource.getDayHospitalization());
        accidentInsurance.setTerritorialValidity(accidentResource.getTerritorialValidity());
        contractService.addContractToUser(uid,accidentInsurance);
        contractService.addContract(accidentInsurance);
        return "redirect:/user/uid/{uid}";
    }

    @PostMapping("/contract/add2/{uid}")
    public String addSubmit2(@PathVariable int uid,@ModelAttribute @Valid TravelResource travelResource, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user/contract/add2";
        }
        TravelInsurance travelInsurance = new TravelInsurance();
        travelInsurance.setIdContract(travelResource.getIdContract());
        travelInsurance.setDateTime(travelResource.getDateTime());
        travelInsurance.setInsurer(travelResource.getInsurer());
        travelInsurance.setInsured(travelResource.getInsured());
        travelInsurance.setDateStart(travelResource.getDateStart());
        travelInsurance.setDateEnd(travelResource.getDateEnd());
        travelInsurance.setHighAmount(travelResource.getHighAmount());
        travelInsurance.setMonthPayment(travelResource.getMonthPayment());
        travelInsurance.setEu(travelResource.isEu());
        travelInsurance.setPurposeOfTrip(travelResource.getPurposeOfTrip());
        contractService.addContractToUser(uid,travelInsurance);
        contractService.addContract(travelInsurance);
        return "redirect:/user/uid/{uid}";
    }

    @PostMapping("/contract/add3/{uid}")
    public String addSubmit3(@PathVariable int uid,@ModelAttribute @Valid ApartmentResource apartmentResource, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user/contract/add3";
        }
        HouseApartmentInsurance houseApartmentInsurance = new HouseApartmentInsurance();
        houseApartmentInsurance.setIdContract(apartmentResource.getIdContract());
        houseApartmentInsurance.setDateTime(apartmentResource.getDateTime());
        houseApartmentInsurance.setInsurer(apartmentResource.getInsurer());
        houseApartmentInsurance.setDateStart(apartmentResource.getDateStart());
        houseApartmentInsurance.setDateEnd(apartmentResource.getDateEnd());
        houseApartmentInsurance.setHighAmount(apartmentResource.getHighAmount());
        houseApartmentInsurance.setMonthPayment(apartmentResource.getMonthPayment());
        houseApartmentInsurance.setGarageInsurance(apartmentResource.isGarageInsurance());;
        houseApartmentInsurance.setValueOfHouse(apartmentResource.getValueOfHouse());
        houseApartmentInsurance.setTypesOfRealEstate(apartmentResource.getTypesOfRealEstate());
        contractService.addContractToUser(uid,houseApartmentInsurance);
        contractService.addContract(houseApartmentInsurance);
        return "redirect:/user/uid/{uid}";
    }

    @PostMapping("/contract/add4/{uid}")
    public String addSubmit4(@PathVariable int uid,@ModelAttribute @Valid HouseHoldResource houseHoldResource,BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user/contract/add4";
        }
        HouseHoldInsurance houseHoldInsurance = new HouseHoldInsurance();
        houseHoldInsurance.setIdContract(houseHoldResource.getIdContract());
        houseHoldInsurance.setDateTime(houseHoldResource.getDateTime());
        houseHoldInsurance.setInsurer(houseHoldResource.getInsurer());
        houseHoldInsurance.setDateStart(houseHoldResource.getDateStart());
        houseHoldInsurance.setDateEnd(houseHoldResource.getDateEnd());
        houseHoldInsurance.setHighAmount(houseHoldResource.getHighAmount());
        houseHoldInsurance.setMonthPayment(houseHoldResource.getMonthPayment());
        houseHoldInsurance.setValueOfHouse(houseHoldResource.getValueOfHouse());
        houseHoldInsurance.setHouseEquipment(houseHoldResource.getHouseEquipment());
        houseHoldInsurance.setTypesOfRealEstate(houseHoldResource.getTypesOfRealEstate());
        contractService.addContractToUser(uid,houseHoldInsurance);
        contractService.addContract(houseHoldInsurance);
        return "redirect:/user/uid/{uid}";
    }

    @GetMapping("uid/{uid}/contract/update1/{idContract}")
    public String update1(@PathVariable int uid,@PathVariable int idContract,Model model) {
        model.addAttribute("user",new UserResource(userService.getUserList().get(uid)));
        model.addAttribute("users",userService.getUserList());
        model.addAttribute("accidentInsurance",new AccidentResource((AccidentInsurance) userService.getUserList().get(uid).getUserContractList().get(idContract)));
        model.addAttribute("territorialValidity", TerritorialValidity.values());
        return "user/contract/update1";
    }

    @PostMapping("uid/{uid}/contract/update1/{idContract}")
    public String submit1(@PathVariable int uid,@PathVariable int idContract,@ModelAttribute  @Valid AccidentResource accidentResource, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user/contract/update1";
        }
        userService.getUserList().get(uid).getUserContractList().put(idContract,accidentResource.toAccident(idContract));
        return "redirect:/user/uid/{idContract}";
    }

    @GetMapping("uid/{uid}/contract/update2/{idContract}")
    public String update2(@PathVariable int uid,@PathVariable int idContract,Model model) {
        model.addAttribute("user",new UserResource(userService.getUserList().get(uid)));
        model.addAttribute("users",userService.getUserList());
        model.addAttribute("travelInsurance",new TravelResource((TravelInsurance) userService.getUserList().get(uid).getUserContractList().get(idContract)));
        model.addAttribute("purposeOfTrip", PurposeOfTrip.values());
        return "user/contract/update2";
    }

    @PostMapping("uid/{uid}/contract/update2/{idContract}")
    public String submit2(@PathVariable int uid,@PathVariable int idContract,@ModelAttribute  @Valid TravelResource travelResource, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user/contract/update2";
        }
        userService.getUserList().get(uid).getUserContractList().put(idContract,travelResource.toTravel(idContract));
        return "redirect:/user/uid/{idContract}";
    }

    @GetMapping("uid/{uid}/contract/update3/{idContract}")
    public String update3(@PathVariable int uid,@PathVariable int idContract,Model model) {
        model.addAttribute("user",new UserResource(userService.getUserList().get(uid)));
        model.addAttribute("users",userService.getUserList());
        model.addAttribute("houseApartmentInsurance",new ApartmentResource((HouseApartmentInsurance) userService.getUserList().get(uid).getUserContractList().get(idContract)));
        model.addAttribute("typesOfRealEstate", TypesOfRealEstate.values());
        return "user/contract/update3";
    }

    @PostMapping("uid/{uid}/contract/update3/{idContract}")
    public String submit3(@PathVariable int uid,@PathVariable int idContract,@ModelAttribute @Valid ApartmentResource apartmentResource, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user/contract/update3";
        }
        userService.getUserList().get(uid).getUserContractList().put(idContract,apartmentResource.toApartment(idContract));
        return "redirect:/user/uid/{idContract}";
    }

    @GetMapping("uid/{uid}/contract/update4/{idContract}")
    public String update4(@PathVariable int uid,@PathVariable int idContract,Model model) {
        model.addAttribute("user",new UserResource(userService.getUserList().get(uid)));
        model.addAttribute("users",userService.getUserList());
        model.addAttribute("houseHoldInsurance",new HouseHoldResource((HouseHoldInsurance) userService.getUserList().get(uid).getUserContractList().get(idContract)));
        model.addAttribute("typesOfRealEstate", TypesOfRealEstate.values());
        return "user/contract/update4";
    }

    @PostMapping("uid/{uid}/contract/update4/{idContract}")
    public String submit4(@PathVariable int uid,@PathVariable int idContract,@ModelAttribute @Valid HouseHoldResource houseHoldResource,BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user/contract/update4";
        }
        userService.getUserList().get(uid).getUserContractList().put(idContract,houseHoldResource.toHouseHold(idContract));
        return "redirect:/user/uid/{idContract}";
    }

}
