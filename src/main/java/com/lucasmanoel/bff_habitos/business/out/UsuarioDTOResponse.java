package com.lucasmanoel.bff_habitos.business.out;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioDTOResponse {
    private Long id;
    private String nome;
    private String email;
}
