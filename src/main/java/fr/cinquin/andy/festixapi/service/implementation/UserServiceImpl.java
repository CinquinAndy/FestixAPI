package fr.cinquin.andy.festixapi.service.implementation;

import fr.cinquin.andy.festixapi.model.UserToReturn;
import fr.cinquin.andy.festixapi.model.Users;
import fr.cinquin.andy.festixapi.dao.repository.UserRepository;
import fr.cinquin.andy.festixapi.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Transactional
@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository adminRepository;

//    private final UserMapper mapper = Mappers.getMapper(UserMapper.class);

    @Override
    public List<UserToReturn> list() {
        return adminRepository.findAllBy();
    }

    @Override
    public List<Users> listComplete(int limit) {
        return adminRepository.findAll();
    }

    @Override
    public UserToReturn get(UUID uuid) {
        return adminRepository.findAllById(uuid);
    }

    @Override
    public Boolean delete(String uuid) {
        log.info("delete User... {}", uuid);
        Boolean exists = adminRepository.existsById(UUID.fromString(uuid)) ? Boolean.TRUE : Boolean.FALSE;
        if(exists == Boolean.TRUE) {
            adminRepository.delete(adminRepository.getById(UUID.fromString(uuid)));
        }
        return exists;
    }
}
