package org.bsim.project.service.impl;

import org.bsim.project.io.entity.DepositoEntity;
import org.bsim.project.io.entity.RekeningEntity;
import org.bsim.project.io.repository.DepositoRepository;
import org.bsim.project.io.repository.RekeningRepository;
import org.bsim.project.service.iservice.IDepositoService;
import org.bsim.project.shared.dto.DepositoDTO;
import org.bsim.project.shared.dto.RekeningDTO;
import org.bsim.project.shared.utils.GenerateRandomPublicid;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepositoServiceImpl implements IDepositoService {

    @Autowired
    GenerateRandomPublicid generateRandomPublicid;

    @Autowired
    RekeningRepository rekeningRepository;

    @Autowired
    DepositoRepository depositoRepository;

    @Override
    public DepositoDTO addNewDeposito(String clientid, String rekeningid, DepositoDTO depositoDTO) {

        ModelMapper mapper = new ModelMapper();

        depositoDTO.setDepositoid(generateRandomPublicid.generateUserId(10));

        RekeningEntity rekeningData = rekeningRepository.findByRekeningid(rekeningid);

        depositoDTO.setRekeningDTO(mapper.map(rekeningData, RekeningDTO.class));
        depositoDTO.setInterestDeposito(4.2);
        depositoDTO.setTaxDeposito(10000);

        rekeningData.setSaldo(rekeningData.getSaldo()-depositoDTO.getSaldoAwalPenempatan());

        DepositoEntity storeDepositoData=depositoRepository.save(mapper.map(depositoDTO, DepositoEntity.class));

        return mapper.map(storeDepositoData, DepositoDTO.class);
    }

    @Override
    public List<DepositoDTO> getListDeposito(String clientid, String rekeningid) {
        List<DepositoEntity> entity= depositoRepository.findAllByRekening(rekeningRepository.findByRekeningid(rekeningid));
        return new ModelMapper().map(entity,new TypeToken<List<DepositoDTO>>(){}.getType());
    }

    @Override
    public DepositoDTO getDepositobyDepositoid(String clientid, String rekeningid, String depositoid) {

        ModelMapper mapper = new ModelMapper();
        RekeningEntity rekeningEntity = rekeningRepository.findByRekeningid(rekeningid);
        if (rekeningEntity == null) return null;
        DepositoEntity depositoEntity = depositoRepository.findByDepositoid(depositoid);
        if (depositoEntity == null) return null;
        return mapper.map(depositoEntity, DepositoDTO.class);
    }
}
