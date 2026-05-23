package com.lucasmanoel.bff_habitos.business;

import com.lucasmanoel.bff_habitos.business.in.HabitosDTORequest;
import com.lucasmanoel.bff_habitos.business.out.CheckinDTOResponse;
import com.lucasmanoel.bff_habitos.business.out.HabitosDTOResponse;
import com.lucasmanoel.bff_habitos.infrastructure.client.HabitoClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HabitosService {

    private final HabitoClient client;

    public HabitosDTOResponse cadastraHabito(String token, HabitosDTORequest dto){
        return client.cadastraHabito(token, dto);
    }

    public void alterarStatusHabito(String token, String id, boolean ativo){

        client.alterarStatusHabito(token, id, ativo);
    }

    public void deletaHabito(String token, String id){
        client.deletaHabito(token, id);
    }

    public HabitosDTOResponse alteraHabito(String token, HabitosDTORequest dto, String id){
        return client.alteraHabito(token, dto, id);
    }

    public Integer efetuarCheckin(String token, String id){
        return client.efetuarCheckin(token, id);
    }

    public List<CheckinDTOResponse> historicoCheckin(String token, String habitoId){
        return client.historicoCheckin(token, habitoId);
    }

    public Integer calcularStreak(String token, String habitoId){
        return client.calcularStreak(token, habitoId);
    }
}
