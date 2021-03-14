package sk.stuba.fei.uim.project.Web.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.uim.project.Functionality.Service.ContractService;
import sk.stuba.fei.uim.project.Functionality.Service.UserService;
import sk.stuba.fei.uim.project.User.User;
import sk.stuba.fei.uim.project.User.UserResource.UserResource;

import javax.validation.Valid;
import java.util.Optional;

@Controller

@RequestMapping("/user")
public class UserController {

    private UserService userService;
    private ContractService contractService;


    public UserController(UserService userService, ContractService contractService) {
        this.userService = userService;
        this.contractService = contractService;
    }

    @GetMapping("/")
    public String all(Model model) {
        model.addAttribute("users", userService.getUserList());
        return "user/all";
    }

    @GetMapping("/uid/{uid}")
    public String byId(@PathVariable int uid, Model model) {
        Optional<User> userById = userService.findUserById(uid);
        if (userById.isPresent()) {
            User user = userById.get();
            model.addAttribute("user", user);
            //model.addAttribute("contract",contractService.AllContracts(user.getUid()));
            model.addAttribute("contracts", contractService.AllUserContracts(user.getUid()));
        }
        return "user/one";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("user",new UserResource());
        return "user/add";
    }

    @PostMapping("/add")
    public String addSubmit(@ModelAttribute @Valid UserResource userResource,  BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user/add";
        }
        User user = new User();
        user.setUid(userResource.getUid());
        user.setName(userResource.getName());
        user.setSurname(userResource.getSurname());
        user.setIdNumber(userResource.getIdNumber());
        user.setEmail(userResource.getEmail());
        user.setPsc(userResource.getPsc());
        user.setCity(userResource.getCity());
        user.setStreet(userResource.getStreet());
        user.setHouseNumber(userResource.getHouseNumber());
        user.setCorPsc(userResource.getCorPsc());
        user.setCorCity(userResource.getCorCity());
        user.setCorStreet(userResource.getCorStreet());
        user.setCorHouseNumber(userResource.getCorHouseNumber());
        userService.addUser(user);
        return "redirect:/user/";
    }
    
    @GetMapping("/update/{uid}")
    public String update(@PathVariable int uid,Model model) {
        model.addAttribute("users",new UserResource(userService.getUserList().get(uid)));
        return "/user/update";
    }


    @PostMapping("/update/{uid}")
    public String submit(@PathVariable int uid, @ModelAttribute @Valid UserResource userResource, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/user/update";
        }
        userService.getUserList().put(uid,userResource.toUser(uid));
        return "redirect:/user/uid/{uid}";
    }

    @GetMapping("delete/{uid}")
    public String deleteById(@PathVariable int uid) {
        userService.getUserList().remove(uid);
        return "redirect:/user/";
    }

}
