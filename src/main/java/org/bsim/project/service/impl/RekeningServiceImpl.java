package org.bsim.project.service.impl;

import org.bsim.project.io.entity.ClientEntity;
import org.bsim.project.io.entity.RekeningEntity;
import org.bsim.project.io.repository.ClientRepository;
import org.bsim.project.io.repository.RekeningRepository;
import org.bsim.project.service.iservice.IRekeningService;
import org.bsim.project.shared.dto.ClientDTO;
import org.bsim.project.shared.dto.RekeningDTO;
import org.bsim.project.shared.utils.GenerateRandomPublicid;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RekeningServiceImpl implements IRekeningService {

    @Autowired
    GenerateRandomPublicid generateRandomPublicid;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    RekeningRepository rekeningRepository;


    @Override
    public RekeningDTO addNewRekening(String clientid, RekeningDTO rekeningDTO) {
        ModelMapper modelMapper = new ModelMapper();

        rekeningDTO.setRekeningid(generateRandomPublicid.generateUserId(10));

        ClientEntity clientData = clientRepository.findByClientid(clientid);

        rekeningDTO.setClientDTO(modelMapper.map(clientData, ClientDTO.class));

//        RekeningEntity entity = modelMapper.map(rekeningDTO, RekeningEntity.class);

        RekeningEntity storedData = rekeningRepository.save(modelMapper.map(rekeningDTO, RekeningEntity.class));

        return modelMapper.map(storedData, RekeningDTO.class);
    }

    @Override
    public List<RekeningDTO> getListRekening(String clientid) {
        ModelMapper modelMapper = new ModelMapper();
        List<RekeningEntity> entity= rekeningRepository.findAllByClient(clientRepository.findByClientid(clientid));
        return new ModelMapper().map(entity,new TypeToken<List<RekeningDTO>>(){}.getType());
    }

    @Override
    public RekeningDTO getRekeningbyRekeningid(String clientid, String rekeningid) {

        ModelMapper modelMapper = new ModelMapper();
        ClientEntity clientEntity = clientRepository.findByClientid(clientid);
        RekeningEntity rekeningEntity = rekeningRepository.findByRekeningid(rekeningid);
        if (clientEntity == null) return null;
        if (rekeningEntity == null) return null;
        return modelMapper.map(rekeningEntity, RekeningDTO.class);
    }


}
