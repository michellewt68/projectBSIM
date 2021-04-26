package org.bsim.project.ui.controller;

import org.springframework.web.bind.annotation.RestController;
import org.bsim.project.service.iservice.IClientService;
import org.bsim.project.shared.dto.ClientDTO;
import org.bsim.project.ui.model.request.ClientRequest;
import org.bsim.project.ui.model.response.ClientResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/client")
public class ClientController {

    @Autowired
    IClientService iClientService;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ClientResponse addNewClient (@RequestBody ClientRequest client){
        ModelMapper mapper=new ModelMapper();

        ClientDTO clientDTO=mapper.map(client, ClientDTO.class);
        ClientDTO createdClient=iClientService.addNewClient(clientDTO);

        return mapper.map(createdClient, ClientResponse.class);
    }

    @GetMapping(path = "/{clientid}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ClientResponse getClientByClientid(@PathVariable String clientid){

        ClientDTO getClient= iClientService.getClientByClientid(clientid);
        if(getClient==null) return null;

        return new ModelMapper().map(getClient, ClientResponse.class);
    }

    @PutMapping(path = "/{clientid}", consumes ={MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ClientResponse updateClient(@PathVariable String clientid, @RequestBody ClientRequest client){
        ModelMapper mapper=new ModelMapper();

        ClientDTO clientDTO=mapper.map(client, ClientDTO.class);
        ClientDTO updateClient= iClientService.updateClientData(clientid, clientDTO);
        return mapper.map(updateClient, ClientResponse.class);
    }

}
