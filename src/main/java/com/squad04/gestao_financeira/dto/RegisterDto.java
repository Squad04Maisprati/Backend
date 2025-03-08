package com.squad04.gestao_financeira.dto;


import com.squad04.gestao_financeira.userEnum.UserRole;
import lombok.*;

@Builder
@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class RegisterDto {

    private String username;
    private String password;
    private String email;
    private String cpf;
    private String numCelular;
    private UserRole role;


}
