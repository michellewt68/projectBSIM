package org.bsim.project.io.repository;


import org.bsim.project.io.entity.ClientEntity;
import org.bsim.project.io.entity.RekeningEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface RekeningRepository extends JpaRepository<RekeningEntity, Long> {

    List<RekeningEntity> findAllByClient(ClientEntity cliententity);
}
