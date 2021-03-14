package sk.stuba.fei.uim.project.Functionality;

import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.project.Contract.Contract;
import sk.stuba.fei.uim.project.Functionality.Service.ContractService;
import sk.stuba.fei.uim.project.Functionality.Service.UserService;
import sk.stuba.fei.uim.project.User.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

;

@Service
public class UserContractService<T> implements UserService, ContractService {

    private Map<Integer, User> listUser;
    private Map<Integer,Contract> listContract;

    public UserContractService() {
        listUser = new HashMap<>();
        listContract = new HashMap<>();
    }


    @Override
    public void addUser(User user) {
        listUser.put(user.getUid(),user);

    }

    @Override
    public Map<Integer, User> getUserList() {
        return listUser;
    }


    @Override
    public Optional<User> findUserById(int userId) {
        return Optional.ofNullable(listUser.get(userId));
    }


    @Override
    public void addContractToUser(int uid, Contract contract) {
        listUser.get(uid).addContract(contract);
    }

    @Override
    public void addContract(Contract contract) {
        listContract.put(contract.getIdContract(),contract);
    }

    @Override
    public Map<Integer, Contract> AllUserContracts(int uid) {
        return listUser.get(uid).getContract();
    }

    @Override
    public Map<Integer, Contract> AllContracts() {
        return listContract;
    }

    @Override
    public Optional<Contract> findUserContractById(int uid,int idContract) {
        return  Optional.ofNullable(listUser.get(uid).getContract().get(idContract));
    }


//    @Override
//    public Optional<User> findUserByName(String name) {
//        return listUser.values().stream().filter(listUser -> listUser.getName().equals(name)).findFirst();
//    }


}
