package fr.cinquin.andy.festixapi.service.implementation;

import fr.cinquin.andy.festixapi.dto.UserDto;
import fr.cinquin.andy.festixapi.mapper.UserMapper;
import fr.cinquin.andy.festixapi.model.UserToReturn;
import fr.cinquin.andy.festixapi.model.Users;
import fr.cinquin.andy.festixapi.dao.repository.UserRepository;
import fr.cinquin.andy.festixapi.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Sort;
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

    private final UserMapper mapper = Mappers.getMapper(UserMapper.class);

    @Override
    public List<UserToReturn> list() {
        return adminRepository.findAllBy(Sort.by(Sort.Direction.ASC,"username"));
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
    public Boolean changestate(String uuid) {
        Users users = adminRepository.findById(UUID.fromString(uuid)).orElse(null);
        if(users == null){
            return Boolean.FALSE;
        } else{
            users.setEnabled(!users.isEnabled());
            adminRepository.save(users);
            return Boolean.TRUE;
        }
    }

    @Override
    public Users update(UserDto userDto) {
        Users users = adminRepository.findById(userDto.getId()).orElse(null);
        if(users == null){
            return null;
        } else{
            users.setEnabled(userDto.isEnabled());
            users.setUsername(userDto.getUsername());
            users.setEmail(userDto.getEmail());
            users.setFirstname(userDto.getFirstname());
            users.setLastname(userDto.getLastname());
            return adminRepository.save(users);
        }
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
