package fr.cinquin.andy.festixapi.service.implementation;

import fr.cinquin.andy.festixapi.dao.repository.AdminRepository;
import fr.cinquin.andy.festixapi.dto.AdminDto;
import fr.cinquin.andy.festixapi.mappers.AdminMapper;
import fr.cinquin.andy.festixapi.model.Admin;
import fr.cinquin.andy.festixapi.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class AuthServiceImpl implements AuthService {
    private final AdminRepository adminRepository;

    private AdminMapper mapper;

    @Override
    public Admin register(AdminDto adminDto) {
        Admin admin = mapper.map(adminDto);
        if (adminRepository.existsByEmail(admin.getEmail())) {
            return null;
        } else {
            admin.setPassword(BCrypt.hashpw(admin.getPassword(), "Z)IeqV4svK2fBTHJ3+&sm/2Vt,RQ_jA&A?,>5(>}Tc:l]i+NN7tBWugh+w*[9R?`"));
            adminRepository.save(admin);
            return admin;
        }
    }
}
