package cz.martinvedra.backend.impl.dto;


public record CustomerDto (
        Long id,
        String firstName,
        String lastName,
        String address,
        String email,
        String phone,
        String username
) {}