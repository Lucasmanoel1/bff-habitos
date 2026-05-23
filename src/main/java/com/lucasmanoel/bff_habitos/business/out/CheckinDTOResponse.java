package com.lucasmanoel.bff_habitos.business.out;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CheckinDTOResponse {
    private String id;
    private String habitosID;
    private LocalDate data;
}
