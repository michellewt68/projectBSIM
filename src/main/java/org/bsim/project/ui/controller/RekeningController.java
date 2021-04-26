package org.bsim.project.ui.controller;


import org.bsim.project.service.iservice.IRekeningService;
import org.bsim.project.shared.dto.RekeningDTO;
import org.bsim.project.ui.model.request.RekeningRequest;
import org.bsim.project.ui.model.response.ClientResponse;
import org.bsim.project.ui.model.response.RekeningResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/rekening")
public class RekeningController {

    @Autowired
    IRekeningService rekeningService;

    @PostMapping(path = "/{clientid}",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public RekeningResponse addNewRekening (@PathVariable String clientid,
                                            @RequestBody RekeningRequest rekeningRequest){
        ModelMapper modelMapper = new ModelMapper();
        RekeningDTO rekeningDTO = modelMapper.map(rekeningRequest, RekeningDTO.class);
        RekeningDTO createRekening = rekeningService.addNewRekening(clientid, rekeningDTO);
        return modelMapper.map(createRekening, RekeningResponse.class);
    }

    @GetMapping (path = "/{clientid}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<RekeningResponse> getClients(@PathVariable String clientid){
        List<RekeningDTO> rekeningDTOS = rekeningService.getListRekening(clientid);
        ModelMapper modelMapper = new ModelMapper();

        List<RekeningResponse> value = new ArrayList<>();
        for (RekeningDTO rekeningDTO : rekeningDTOS){
            value.add(modelMapper.map(rekeningDTO, RekeningResponse.class));
        }
        return value;
    }


}
