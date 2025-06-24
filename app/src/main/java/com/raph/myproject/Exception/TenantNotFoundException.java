package com.raph.myproject.Exception;

public class TenantNotFoundException extends RuntimeException {
    public TenantNotFoundException(Long id) {
        super("Le Tenant avec l'ID " + id + " n'existe pas !");
    }
}
