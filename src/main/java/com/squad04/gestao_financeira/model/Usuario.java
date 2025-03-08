package com.squad04.gestao_financeira.model;

import com.squad04.gestao_financeira.userEnum.UserRole;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Table(name = "usuario")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "usuario")
    private List<Transacao> transacoes;

    private String username;
    private String senha;
    private String email;
    private String cpf;
    private String numCelular;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    public Usuario(String username, String email, String cpf, String numCelular, String senha, UserRole role) {
        this.username = username;
        this.email = email;
        this.cpf = cpf;
        this.senha = senha;
        this.numCelular = numCelular;
        this.role = role;
    }

    // Verificação da role do usuário. Se for ADM, recebe as roles de ADM+USER.
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.role == UserRole.ADMIN) {
            return List.of(
                    new SimpleGrantedAuthority("ROLE_ADMIN"),
                    new SimpleGrantedAuthority("ROLE_USER")
            );
        } else {
            return List.of(new SimpleGrantedAuthority("ROLE_USER"));
        }
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

