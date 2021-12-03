package fr.cinquin.andy.festixapi.service.implementation;

import fr.cinquin.andy.festixapi.model.Admin;
import fr.cinquin.andy.festixapi.repository.AdminRepository;
import fr.cinquin.andy.festixapi.service.AdminService;
import lombok.RequiredArgsConstructor;

import java.util.Collection;
import java.util.UUID;

@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final AdminRepository adminRepository;
    @Override
    public Admin create(Admin admin) {
        return null;
    }

    @Override
    public Collection<Admin> list(int limit) {
        return null;
    }

    @Override
    public Admin get(UUID uuid) {
        return null;
    }

    @Override
    public Admin update(Admin admin) {
        return null;
    }

    @Override
    public Boolean delete(UUID uuid) {
        return null;
    }
}
