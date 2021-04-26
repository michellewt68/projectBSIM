package org.bsim.project.service.impl;

import org.bsim.project.io.entity.ClientEntity;
import org.bsim.project.io.repository.ClientRepository;
import org.bsim.project.service.iservice.IClientService;
import org.bsim.project.shared.dto.ClientDTO;
import org.bsim.project.shared.utils.GenerateRandomPublicid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements IClientService {

    @Autowired
    GenerateRandomPublicid generateRandomPublicid;

    @Autowired
    ClientRepository clientRepository;

    @Override
    public ClientDTO addNewClient(ClientDTO client) {
        ModelMapper mapper=new ModelMapper();

        client.setClientid(generateRandomPublicid.generateUserId(8));

        //tf dri service --> repository
        ClientEntity entity= mapper.map(client, ClientEntity.class);

        ClientEntity savedData= clientRepository.save(entity);

        return mapper.map(savedData, ClientDTO.class);
    }

    @Override
    public ClientDTO getClientByClientid(String clientid) {

        ClientEntity getClient= clientRepository.findByClientid(clientid);
        if(getClient==null) return null;

        return new ModelMapper().map(getClient, ClientDTO.class);
    }

    @Override
    public ClientDTO updateClientData(String clientid, ClientDTO clientDTO) {

        ClientEntity clientData= clientRepository.findByClientid(clientid);

        if(clientData==null) return null;

        clientData.setClientdob(clientDTO.getClientdob());
        clientData.setClientaddress(clientDTO.getClientaddress());
        clientData.setClientname(clientDTO.getClientname());
        clientData.setClientphonenumber(clientDTO.getClientphonenumber());
        clientData.setClientmothername(clientDTO.getClientmothername());

        ClientEntity updateClientData= clientRepository.save(clientData);

        return new ModelMapper().map(updateClientData, ClientDTO.class);
    }
}
