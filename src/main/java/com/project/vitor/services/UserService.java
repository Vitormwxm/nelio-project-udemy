package com.project.vitor.services;

import com.project.vitor.entities.User;
import com.project.vitor.repositories.UserRepository;
import com.project.vitor.services.exceptions.DatabaseException;
import com.project.vitor.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new ResourceNotFoundException(id)) ;
    }

    public User insert(User obj) {
        User user = userRepository.save(obj);
        return user;
    }

    public void delete(Long id) {
        try {
            userRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }

    }

    public User update(Long id, User obj) {
        User user = userRepository.findById(id).orElseThrow();

        if (obj.getName() != null) {
            user.setName(obj.getName());
        }

        if (obj.getEmail() != null) {
            user.setEmail(obj.getEmail());
        }

        return userRepository.save(user);
    }
}
