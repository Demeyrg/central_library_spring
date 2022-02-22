package com.aleinikov.central_library_spring.services;

import com.aleinikov.central_library_spring.entities.Role;
import com.aleinikov.central_library_spring.entities.User;
import com.aleinikov.central_library_spring.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional(readOnly = true)
    public UserDetails findById(Long id) {
        Optional<User> userById = userRepository.findById(id);
        return userById.orElseThrow(() -> new UsernameNotFoundException("User with id=" + id + " not Found"));
    }

    @Transactional(readOnly = true)
    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        UserDetails userByLogin = userRepository.findUserByLogin(user.getLogin());
        if (userByLogin != null)
            throw new UsernameNotFoundException("User with this username exist!");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        if (user.getActive() == null)
            user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        return userRepository.save(user);
    }

    public UserDetails updateUser(User user, Long id) {
        findById(id);
        user.setId(id);
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        findById(id);
        userRepository.deleteById(id);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails userDetails = userRepository.findUserByLogin(username);
        if (userDetails == null)
            throw new UsernameNotFoundException("Username not found");
        return userDetails;
    }
}
