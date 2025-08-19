package com.jellmayer.forumhub.api.domain.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User implements UserDetails {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String password;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER")); // Role padrão
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    // Métodos de controle de estado da conta usuário
    @Override
    public boolean isAccountNonExpired() {
        return true; // A conta não expirou.
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // A conta não está bloqueada.
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // As credenciais (senha) não expiraram.
    }

    @Override
    public boolean isEnabled() {
        return true; // A conta está ativa.
    }
}
