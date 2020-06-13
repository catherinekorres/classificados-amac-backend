package com.github.classificadosamac.api.service;

import com.github.classificadosamac.api.model.User;
import com.github.classificadosamac.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public User update(User user, Long id) {
        User updated = this.findOne(id);

        updated.setName(user.getName());
        updated.setEmail(user.getEmail());
        updated.setPassword(user.getPassword());
        updated.setPhone(user.getPhone());
        updated.setWhatsApp(user.getWhatsApp());
        updated.setStreet(user.getStreet());
        updated.setNumber(user.getNumber());

        return userRepository.save(updated);
    }

    public User findOne(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
