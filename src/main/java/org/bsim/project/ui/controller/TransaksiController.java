package org.bsim.project.ui.controller;

import org.bsim.project.service.iservice.ITransaksiService;
import org.bsim.project.shared.dto.TransaksiDTO;
import org.bsim.project.ui.model.request.TransaksiRequest;
import org.bsim.project.ui.model.response.TransaksiResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/transaksi")
public class TransaksiController {

    @Autowired
    ITransaksiService transaksiService;

    @PostMapping(path = "/{clientid}/{rekeningid}",
                produces = {MediaType.APPLICATION_JSON_VALUE},
                consumes = {MediaType.APPLICATION_JSON_VALUE})
    public TransaksiResponse addNewTransaksi (@PathVariable String clientid,
                                              @PathVariable String rekeningid,
                                              @RequestBody TransaksiRequest transaksiRequest){
        ModelMapper modelMapper = new ModelMapper();

        TransaksiDTO transaksiDTO = modelMapper.map(transaksiRequest, TransaksiDTO.class);
        TransaksiDTO createTransaksi = transaksiService.addNewTransaksi(clientid, rekeningid, transaksiDTO);

        return modelMapper.map(createTransaksi, TransaksiResponse.class);
    }

    @GetMapping (path = "/{clientid}/{rekeningid}",
                produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<TransaksiResponse> viewTransactionListByRekeningId (@PathVariable String clientid,
                                                                    @PathVariable String rekeningid){
        List<TransaksiDTO> value = transaksiService.getTransactionList(clientid, rekeningid);
        ModelMapper mapper = new ModelMapper();

        List<TransaksiResponse> returnValue = new ArrayList<>();
        for (TransaksiDTO transaksiDTO : value){
            returnValue.add(mapper.map(transaksiDTO, TransaksiResponse.class));
        }
        return returnValue;
    }

    @GetMapping(path = "/{clientid}/{rekeningid}/{transactionid}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public TransaksiResponse viewOneTransactionByRekeningId (@PathVariable String clientid,
                                                             @PathVariable String rekeningid,
                                                             @PathVariable String transactionid){
        ModelMapper mapper=new ModelMapper();

        TransaksiDTO transaksiDTO= transaksiService.getTransactionByTransactionId(clientid, rekeningid, transactionid);
        return mapper.map(transaksiDTO,TransaksiResponse.class);
    }

}
