package com.raph.myproject.Exception;

public class TenantAlreadyExistsException extends RuntimeException {
    public TenantAlreadyExistsException(String name) {
        super("Un Tenant avec le nom '" + name + "' existe déjà !");
    }
}
