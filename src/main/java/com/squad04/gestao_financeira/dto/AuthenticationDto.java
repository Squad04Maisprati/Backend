package com.squad04.gestao_financeira.dto;


import lombok.*;

@Builder
@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class AuthenticationDto {

    private String username;
    private String password;

}
