package com.squad04.gestao_financeira.userEnum;

public enum UserRole {

    ADMIN("admin"),

    USER("user");


    private String role;

    UserRole(String role) {
        this.role = role;
    }

    public String getRole(){
        return role;
    }


}


