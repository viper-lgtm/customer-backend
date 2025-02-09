package cz.martinvedra.backend.impl.dto;


public record SaveCustomerBody(
        String firstName,
        String lastName,
        String address,
        String email,
        String phone,
        String username,
        String password
) {}
