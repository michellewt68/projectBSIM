package org.bsim.project.io.repository;

import org.bsim.project.io.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<ClientEntity, Long> {

    ClientEntity findByClientid(String clientid);
}
