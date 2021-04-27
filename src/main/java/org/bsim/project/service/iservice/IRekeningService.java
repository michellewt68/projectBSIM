package org.bsim.project.service.iservice;

import org.bsim.project.shared.dto.RekeningDTO;

import java.util.List;

public interface IRekeningService {
    RekeningDTO addNewRekening(String clientid, RekeningDTO rekeningDTO);


    List<RekeningDTO> getListRekening(String clientid);

    RekeningDTO getRekeningbyRekeningid(String clientid, String rekeningid);
}
