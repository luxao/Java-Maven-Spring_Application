package sk.stuba.fei.uim.project.Functionality.Service;

import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.project.Contract.Contract;

import java.util.Map;
import java.util.Optional;

@Service
public interface ContractService {

    void addContractToUser(int uid,Contract contract);
    void addContract(Contract contract);
    Map<Integer, Contract> AllUserContracts(int uid);

    Map<Integer, Contract> AllContracts();
    Optional<Contract> findUserContractById(int uid,int idContract);




}
