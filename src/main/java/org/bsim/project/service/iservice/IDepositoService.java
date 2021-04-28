package org.bsim.project.service.iservice;

import org.bsim.project.shared.dto.DepositoDTO;

import java.util.List;

public interface IDepositoService {
    DepositoDTO addNewDeposito(String clientid, String rekeningid, DepositoDTO depositoDTO);

    List<DepositoDTO> getListDeposito(String clientid, String rekeningid);

    DepositoDTO getDepositobyDepositoid(String clientid, String rekeningid, String depositoid);


}
