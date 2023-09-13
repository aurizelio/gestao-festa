package br.gov.sp.etec.gestaofesta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.gov.sp.etec.gestaofesta.model.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long> {
		Login findByEmail(String email);
		Login findByCpf(String cpf);
}
