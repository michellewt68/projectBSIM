package org.bsim.project.ui.controller;

import org.bsim.project.service.iservice.IDepositoService;
import org.bsim.project.shared.dto.DepositoDTO;
import org.bsim.project.shared.dto.RekeningDTO;
import org.bsim.project.ui.model.request.DepositoRequest;
import org.bsim.project.ui.model.response.DepositoResponse;
import org.bsim.project.ui.model.response.RekeningResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/deposito")
public class DepositoController {

    @Autowired
    IDepositoService iDepositoService;

    @PostMapping(path = "/{clientid}/{rekeningid}", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public DepositoResponse createNewDeposito(@PathVariable String clientid, @PathVariable String rekeningid, @RequestBody DepositoRequest deposito){
        ModelMapper mapper=new ModelMapper();

        DepositoDTO depositoDTO=mapper.map(deposito, DepositoDTO.class);
        DepositoDTO createDeposito=iDepositoService.addNewDeposito(clientid, rekeningid, depositoDTO);

        return mapper.map(createDeposito, DepositoResponse.class);
    }


    @GetMapping(path = "/{clientid}/{rekeningid}",produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<DepositoResponse> displayAllDepositobyRekeningid(@PathVariable String clientid, @PathVariable String rekeningid){
        List<DepositoDTO> depositoDTOList = iDepositoService.getListDeposito(clientid, rekeningid);
        ModelMapper mapper = new ModelMapper();

        List<DepositoResponse> value = new ArrayList<>();
        for (DepositoDTO depositoDTO : depositoDTOList){
            value.add(mapper.map(depositoDTO, DepositoResponse.class));
        }
        return value;
    }

    @GetMapping(path = "/{clientid}/{rekeningid}/{depositoid}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public DepositoResponse displayDepositobyDepositoid(@PathVariable String clientid, @PathVariable String rekeningid, @PathVariable String depositoid){
        ModelMapper mapper=new ModelMapper();

        DepositoDTO depositoDTO= iDepositoService.getDepositobyDepositoid(clientid, rekeningid, depositoid);
        return mapper.map(depositoDTO, DepositoResponse.class);
    }
}
