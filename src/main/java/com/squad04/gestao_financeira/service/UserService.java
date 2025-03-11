package com.squad04.gestao_financeira.service;

import com.squad04.gestao_financeira.dto.CreateUserDto;
import com.squad04.gestao_financeira.dto.UpdateUserDto;
import com.squad04.gestao_financeira.repository.UserRepository;
import org.apache.catalina.User;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.List;
import java.util.Optional<User>;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Long createUser(@NotNull CreateUserDto createUserDto) {
        var entity = new User(
                null, // ID será gerado automaticamente
                createUserDto.username(),
                createUserDto.email(),
                createUserDto.password(),
                Instant.now(),
                null // updateTimestamp inicialmente nulo
        );
        // Salva a entidade no repositório e retorna o ID gerado
        var savedEntity = userRepository.save(entity);
        return savedEntity.getId();
    }

    public Optional<User> getUserById(Long userId) {
        return userRepository.findById(userId);
    }

    public List<User> listUsers() {
        return userRepository.findAll();
    }

    public void updateUserById(Long userId, UpdateUserDto updateUserDto) {
        var userEntity = userRepository.findById(userId);

        if (userEntity.isPresent()) {
            var user = userEntity.get();

            if (updateUserDto.username() != null) {
                user.setUsername(updateUserDto.username());
            }
            if (updateUserDto.password() != null) {
                user.setPassword(updateUserDto.password());
            }

            userRepository.save(user);
        }
    }

    public void deleteById(Long userId) {
        if (userRepository.existsById(userId)) {
            userRepository.deleteById(userId);
        }
    }
}
