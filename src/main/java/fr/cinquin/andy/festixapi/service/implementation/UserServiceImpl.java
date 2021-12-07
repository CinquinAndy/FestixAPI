package fr.cinquin.andy.festixapi.service.implementation;

import fr.cinquin.andy.festixapi.dto.UserDto;
import fr.cinquin.andy.festixapi.mapper.UserMapper;
import fr.cinquin.andy.festixapi.model.UserToReturn;
import fr.cinquin.andy.festixapi.model.Users;
import fr.cinquin.andy.festixapi.dao.repository.UserRepository;
import fr.cinquin.andy.festixapi.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
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
//    private SimpleSourceDestinationMapper mapper
//            = Mappers.getMapper(SimpleSourceDestinationMapper.class);
    private UserMapper mapper = Mappers.getMapper(UserMapper.class);

    @Override
    public List<UserToReturn> list(int limit) {
        log.info("List admin... limit : {}", limit);
        return adminRepository.findAllBy();
    }

    @Override
    public Users get(UUID uuid) {
        log.info("get Users... {}", uuid);
        return adminRepository.getById(uuid);
    }

    @Override
    public Users update(UserDto usersDto) {
        Users user = mapper.map(usersDto);
        log.info("Update users... {}", user.getEmail());
        return adminRepository.save(user);
    }

    @Override
    public Boolean delete(UUID uuid) {
        log.info("delete Users... {}", uuid);
        adminRepository.deleteById(uuid);
        return Boolean.TRUE;
    }
}
