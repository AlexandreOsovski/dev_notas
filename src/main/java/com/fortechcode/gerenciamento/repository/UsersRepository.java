package com.fortechcode.gerenciamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.fortechcode.gerenciamento.entities.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {

}
