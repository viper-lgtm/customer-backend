package cz.martinvedra.backend.impl.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "customer_entity")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
//@ToString(onlyExplicitlyIncluded = true)
//@ToString(exclude = "orders")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
//    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name")
//    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "address")
//    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "email")
//    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone")
//    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "user_name", nullable = false, length = 50)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "role", nullable = false, length = 10)
    private String role;
}
