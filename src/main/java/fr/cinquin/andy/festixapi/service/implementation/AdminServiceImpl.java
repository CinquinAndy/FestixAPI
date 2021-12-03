package fr.cinquin.andy.festixapi.service.implementation;

import fr.cinquin.andy.festixapi.model.Admin;
import fr.cinquin.andy.festixapi.repository.AdminRepository;
import fr.cinquin.andy.festixapi.service.AdminService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.UUID;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class AdminServiceImpl implements AdminService {
    private final AdminRepository adminRepository;
    @Override
    public Admin create(Admin admin) {
        log.info("Create admin... {}", admin.getEmail());
        return adminRepository.save(admin);
    }

    @Override
    public Collection<Admin> list(int limit) {
        log.info("List admin... limit : {}", limit);
        return adminRepository.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public Admin get(UUID uuid) {
        log.info("get Admin... {}", uuid);
        return adminRepository.getById(uuid);
    }

    @Override
    public Admin update(Admin admin) {
        log.info("Update admin... {}", admin.getEmail());
        return adminRepository.save(admin);
    }

    @Override
    public Boolean delete(UUID uuid) {
        log.info("delete Admin... {}", uuid);
        adminRepository.deleteById(uuid);
        return Boolean.TRUE;
    }
}
