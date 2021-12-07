package fr.cinquin.andy.festixapi.service.implementation;

import fr.cinquin.andy.festixapi.dao.repository.UserRepository;
import fr.cinquin.andy.festixapi.dto.UserDto;
import fr.cinquin.andy.festixapi.mapper.UserMapper;
import fr.cinquin.andy.festixapi.model.Users;
import fr.cinquin.andy.festixapi.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
@Slf4j
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository adminRepository;

    private UserMapper mapper = Mappers.getMapper(UserMapper.class);

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Users register(UserDto userDto) {
        Users user = mapper.map(userDto);
        if (adminRepository.existsByEmail(user.getEmail())) {
            return null;
        } else {
            user.setPassword(passwordEncoder.encode(userDto.getPassword()));
            adminRepository.save(user);
            return user;
        }
    }
}
