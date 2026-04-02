package com.cramanager.repository;


import com.cramanager.entity.User;
import com.cramanager.enumeration.UserRoles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByRole(UserRoles role);
    Optional<User> findByActivationToken (String activationToken);
}
