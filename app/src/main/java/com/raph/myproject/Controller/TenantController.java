package com.raph.myproject.Controller;

import com.raph.myproject.Dto.TenantRequest;
import com.raph.myproject.Dto.TenantResponse;
import com.raph.myproject.Entity.Tenant;
import com.raph.myproject.Service.TenantService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tenants")
public class TenantController {

    private final TenantService tenantService;

    public TenantController(TenantService tenantService) {
        this.tenantService = tenantService;
    }

    @PostMapping
    public ResponseEntity<TenantResponse<Tenant>> createTenant(@Valid @RequestBody TenantRequest request) {
        Tenant newTenant = tenantService.createTenant(request);
        TenantResponse<Tenant> response = new TenantResponse<>(
                200,
                true,
                "Le Tenant a été créé avec succès !",
                newTenant);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<TenantResponse<List<Tenant>>> getAllTenants() {
        List<Tenant> allTenants = tenantService.getAllTenants();
        TenantResponse<List<Tenant>> response = new TenantResponse<>(
                200,
                true,
                "Les Tenants ont été récupérés avec succès !",
                allTenants);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TenantResponse<Void>> deleteTenant(@PathVariable Long id) {
        tenantService.deleteTenant(id);
        TenantResponse<Void> response = new TenantResponse<>(
                200,
                true,
                "Le Tenant a été supprimé avec succès !",
                null);
        return ResponseEntity.ok(response);
    }
}