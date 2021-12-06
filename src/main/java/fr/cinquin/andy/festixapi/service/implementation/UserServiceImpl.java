package fr.cinquin.andy.festixapi.service.implementation;

import fr.cinquin.andy.festixapi.model.Users;
import fr.cinquin.andy.festixapi.dao.repository.UserRepository;
import fr.cinquin.andy.festixapi.service.UserService;
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
public class UserServiceImpl implements UserService {
    private final UserRepository adminRepository;

    @Override
    public Collection<Users> list(int limit) {
        log.info("List admin... limit : {}", limit);
        return adminRepository.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public Users get(UUID uuid) {
        log.info("get Users... {}", uuid);
        return adminRepository.getById(uuid);
    }

    @Override
    public Users update(Users users) {
        log.info("Update users... {}", users.getEmail());
        return adminRepository.save(users);
    }

    @Override
    public Boolean delete(UUID uuid) {
        log.info("delete Users... {}", uuid);
        adminRepository.deleteById(uuid);
        return Boolean.TRUE;
    }
}
