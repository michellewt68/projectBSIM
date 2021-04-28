package org.bsim.project.service.impl;

import org.bsim.project.io.entity.ClientEntity;
import org.bsim.project.io.entity.DepositoEntity;
import org.bsim.project.io.entity.RekeningEntity;
import org.bsim.project.io.entity.TransaksiEntity;
import org.bsim.project.io.repository.ClientRepository;
import org.bsim.project.io.repository.RekeningRepository;
import org.bsim.project.io.repository.TransaksiRepository;
import org.bsim.project.service.iservice.ITransaksiService;
import org.bsim.project.shared.dto.DepositoDTO;
import org.bsim.project.shared.dto.RekeningDTO;
import org.bsim.project.shared.dto.TransaksiDTO;
import org.bsim.project.shared.utils.GenerateRandomPublicid;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TransaksiServiceImpl implements ITransaksiService {

    @Autowired
    GenerateRandomPublicid generateRandomPublicid;

    @Autowired
    RekeningRepository rekeningRepository;

    @Autowired
    TransaksiRepository transaksiRepository;

    @Autowired
    ClientRepository clientRepository;

    @Override
    public TransaksiDTO addNewTransaksi(String clientid, String rekeningid, TransaksiDTO transaksiDTO) {
        ModelMapper modelMapper = new ModelMapper();

        transaksiDTO.setTransactionid(generateRandomPublicid.generateUserId(10));

        RekeningEntity rekeningData = rekeningRepository.findByRekeningid(rekeningid);

        transaksiDTO.setRekeningDTO(modelMapper.map(rekeningData, RekeningDTO.class));
        transaksiDTO.setTransactiondate(LocalDate.now());

        TransaksiEntity storeData = transaksiRepository.save(modelMapper.map(transaksiDTO, TransaksiEntity.class));
        return modelMapper.map(storeData, TransaksiDTO.class);
    }

    @Override
    public List<TransaksiDTO> getTransactionList(String clientid, String rekeningid) {
        List<TransaksiEntity> entity= transaksiRepository.findAllByRekening(rekeningRepository.findByRekeningid(rekeningid));
        return new ModelMapper().map(entity,new TypeToken<List<TransaksiDTO>>(){}.getType());
    }

    @Override
    public TransaksiDTO getTransactionByTransactionId(String clientid, String rekeningid, String transactionid) {
        ModelMapper mapper = new ModelMapper();

        ClientEntity clientEntity = clientRepository.findByClientid(clientid);
        if (clientEntity == null) return null;

        RekeningEntity rekeningEntity = rekeningRepository.findByRekeningid(rekeningid);
        if (rekeningEntity == null) return null;

        TransaksiEntity transaksiEntity = transaksiRepository.findByTransactionid(transactionid);
        if (transaksiEntity == null) return null;

        return mapper.map(transaksiEntity, TransaksiDTO.class);
    }

}
