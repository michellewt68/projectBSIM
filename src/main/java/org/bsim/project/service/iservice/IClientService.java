package org.bsim.project.service.iservice;

import org.bsim.project.shared.dto.ClientDTO;

public interface IClientService {

    ClientDTO addNewClient(ClientDTO client);

    ClientDTO getClientByClientid(String clientid);

    ClientDTO updateClientData(String clientid, ClientDTO clientDTO);
}
