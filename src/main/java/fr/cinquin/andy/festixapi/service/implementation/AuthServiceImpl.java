package fr.cinquin.andy.festixapi.service.implementation;

import fr.cinquin.andy.festixapi.dao.repository.AuthorityRepository;
import fr.cinquin.andy.festixapi.dao.repository.UserRepository;
import fr.cinquin.andy.festixapi.dto.UserDto;
import fr.cinquin.andy.festixapi.mapper.UserMapper;
import fr.cinquin.andy.festixapi.model.Authority;
import fr.cinquin.andy.festixapi.model.Users;
import fr.cinquin.andy.festixapi.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Transactional
@Service
@Slf4j
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository adminRepository;
    @Autowired
    private final AuthorityRepository authorityRepository;

    private final UserMapper mapper = Mappers.getMapper(UserMapper.class);

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public Users register(UserDto userDto) {
        Users user = mapper.map(userDto);
        List<Authority> authorityList = authorityRepository.findAll();
        for (Authority authority:authorityList) {
            if(Objects.equals(authority.getAuthority(), "USER")){
                user.setAuthorities_users(List.of(authority));
            }
        }
        if (adminRepository.existsByEmail(user.getEmail())) {
            return null;
        } else {
            user.setPassword(passwordEncoder.encode(userDto.getPassword()));
            //FIXME : disable later
            user.setEnabled(true);
            adminRepository.save(user);
            return user;
        }
    }
}
