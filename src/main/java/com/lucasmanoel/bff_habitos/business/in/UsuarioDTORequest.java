package com.lucasmanoel.bff_habitos.business.in;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioDTORequest {
    private String nome;
    private String email;
    private String senha;
}
