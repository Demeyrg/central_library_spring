package com.aleinikov.central_library_spring.repositories;

import com.aleinikov.central_library_spring.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    UserDetails findUserByLogin(String login);

}
