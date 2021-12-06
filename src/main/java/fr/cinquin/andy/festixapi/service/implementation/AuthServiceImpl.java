package fr.cinquin.andy.festixapi.service.implementation;

import fr.cinquin.andy.festixapi.dao.repository.UserRepository;
import fr.cinquin.andy.festixapi.dto.UserDto;
import fr.cinquin.andy.festixapi.mappers.UserMapper;
import fr.cinquin.andy.festixapi.model.Users;
import fr.cinquin.andy.festixapi.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class AuthServiceImpl implements AuthService {
    private final UserRepository adminRepository;

    private UserMapper mapper;

    @Override
    public Users register(UserDto userDto) {
        Users users = mapper.map(userDto);
        if (adminRepository.existsByEmail(users.getEmail())) {
            return null;
        } else {
            users.setPassword(BCrypt.hashpw(users.getPassword(), "Z)IeqV4svK2fBTHJ3+&sm/2Vt,RQ_jA&A?,>5(>}Tc:l]i+NN7tBWugh+w*[9R?`"));
            adminRepository.save(users);
            return users;
        }
    }
}
