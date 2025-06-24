package com.raph.myproject.Service;

import com.raph.myproject.Dto.TenantRequest;
import com.raph.myproject.Entity.Tenant;
import com.raph.myproject.Exception.TenantAlreadyExistsException;
import com.raph.myproject.Exception.TenantNotFoundException;
import com.raph.myproject.Repository.TenantRepository;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.List;

@Service
public class TenantService {
    private final TenantRepository tenantRepository;

    public TenantService(TenantRepository tenantRepository) {
        this.tenantRepository = tenantRepository;
    }

    public Tenant createTenant(TenantRequest request) {
        if (tenantRepository.existsByName(request.getName())) {
            throw new TenantAlreadyExistsException(request.getName());
        }
        Tenant tenant = new Tenant();
        tenant.setName(request.getName());
        tenant.setKey(generateKey());

        return tenantRepository.save(tenant);
    }

    private String generateKey() {
        byte[] randomBytes = new byte[24];
        new SecureRandom().nextBytes(randomBytes);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(randomBytes);
    }

    public List<Tenant> getAllTenants() {
        return tenantRepository.findAll();
    }

    public void deleteTenant(Long id) {
        if (!tenantRepository.existsById(id)) {
            throw new TenantNotFoundException(id);
        }
        tenantRepository.deleteById(id);
    }
}
