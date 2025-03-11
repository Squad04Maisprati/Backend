package com.squad04.gestao_financeira.repository;

import com.squad04.gestao_financeira.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository <Usuario, Long>{

    UserDetails findByUsername(String username);
}
