package com.squad04.gestao_financeira.controller;


import com.squad04.gestao_financeira.dto.AuthenticationDto;
import com.squad04.gestao_financeira.dto.LoginResponseDto;
import com.squad04.gestao_financeira.dto.RegisterDto;
import com.squad04.gestao_financeira.infra.TokenService;
import com.squad04.gestao_financeira.model.Usuario;
import com.squad04.gestao_financeira.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository repository;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login (@RequestBody AuthenticationDto dados){
        var usernamePassword = new UsernamePasswordAuthenticationToken(dados.getUsername(), dados.getPassword());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generateToken((Usuario)auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDto(token));

    }

    @PostMapping("/register")
    public ResponseEntity register (@RequestBody RegisterDto dados){
        if (this.repository.findByUsername(dados.getUsername()) != null) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(dados.getPassword());
        Usuario newUser = new Usuario(dados.getUsername(), dados.getEmail(), dados.getCpf(), dados.getNumCelular(), encryptedPassword, dados.getRole());

        this.repository.save(newUser);

        return ResponseEntity.ok().build();

    }

}
