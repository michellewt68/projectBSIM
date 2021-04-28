package org.bsim.project.io.repository;

import org.bsim.project.io.entity.DepositoEntity;
import org.bsim.project.io.entity.RekeningEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface DepositoRepository extends JpaRepository<DepositoEntity, Long> {


    List<DepositoEntity> findAllByRekening(RekeningEntity Rekeningid);

    DepositoEntity findByDepositoid(String depositoid);

}
