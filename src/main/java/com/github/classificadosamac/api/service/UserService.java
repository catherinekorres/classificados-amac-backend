package com.github.classificadosamac.api.service;

import com.github.classificadosamac.api.dto.UserDTO;
import com.github.classificadosamac.api.model.User;
import com.github.classificadosamac.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    // Singleton
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<UserDTO> findOne(Long id) {
        Optional<User> user = userRepository.findById(id);

        return user.map(UserDTO::new);
    }

    public User update(User user, Long id) {
        Optional<User> optionalUser = userRepository.findById(id);

        if (!optionalUser.isPresent()) {
            return null;
        }

        user.setId(id);

        return this.save(user);
    }

    public void delete(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isPresent()) {
            userRepository.deleteById(id);
        }
    }
}
