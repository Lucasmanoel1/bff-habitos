package com.lucasmanoel.bff_habitos.business.out;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HabitosDTOResponse {

    private String habitosID;
    private String nome;
    private String email;
    private String descricao;
    private LocalDateTime dataCriacao;
    private Boolean ativo;
}
