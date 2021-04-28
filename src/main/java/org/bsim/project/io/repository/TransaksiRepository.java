package org.bsim.project.io.repository;

import org.bsim.project.io.entity.RekeningEntity;
import org.bsim.project.io.entity.TransaksiEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransaksiRepository extends JpaRepository<TransaksiEntity, Long> {

    TransaksiEntity findByTransactionid(String transactionid);

    List<TransaksiEntity> findAllByRekening(RekeningEntity Rekeningid);

}
