package cz.martinvedra.backend.impl.security;

import cz.martinvedra.backend.impl.entity.CustomerEntity;
import cz.martinvedra.backend.impl.repo.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerUserDetailsService implements UserDetailsService {

    private final CustomerRepository customerRepository;

//    @Override
//    public UserDetails loadUserByUsername(String username) {
//        log.info("Načítám uživatele s uživatelským jménem: {}", username);
//        CustomerEntity customerEntity = customerRepository.findByUsername(username).orElse(null);
//        return customerRepository.findByUsername(username)
//                .orElseThrow(() -> new UsernameNotFoundException(username + " not found"));
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        CustomerEntity customerEntity = customerRepository.findByUsername(username).orElse(null);
        UserDetails userDetails = customerRepository.findByUsername(username)
                .map(CustomerUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException(username + " not found"));
        return userDetails;
    }
}