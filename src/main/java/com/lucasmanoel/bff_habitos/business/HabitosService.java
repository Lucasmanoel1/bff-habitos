package com.lucasmanoel.bff_habitos.business;

import com.lucasmanoel.bff_habitos.business.in.HabitosDTORequest;
import com.lucasmanoel.bff_habitos.business.out.CheckinDTOResponse;
import com.lucasmanoel.bff_habitos.business.out.HabitosDTOResponse;
import com.lucasmanoel.bff_habitos.infrastructure.client.HabitoClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HabitosService {

    private final HabitoClient client;

    public HabitosDTOResponse cadastraHabito(@RequestHeader("Authorization") String token, @RequestBody HabitosDTORequest dto){
        return client.cadastraHabito(token, dto);
    }

    public void alterarStatusHabito(@RequestHeader("Authorization") String token, @PathVariable String id, @RequestParam boolean ativo){

        client.alterarStatusHabito(token, id, ativo);
    }

    public void deletaHabito(@RequestHeader("Authorization") String token, @PathVariable String id){
        client.deletaHabito(token, id);
    }

    public HabitosDTOResponse alteraHabito(@RequestHeader("Authorization") String token, @RequestBody HabitosDTORequest dto, @PathVariable String id){
        return client.alteraHabito(token, dto, id);
    }

    public Integer efetuarCheckin(@RequestHeader("Authorization") String token, @RequestParam String id){
        return client.efetuarCheckin(token, id);
    }

    public List<CheckinDTOResponse> historicoCheckin(@RequestHeader("Authorization") String token, @RequestParam String habitoId){
        return client.historicoCheckin(token, habitoId);
    }

    public Integer calcularStreak(@RequestHeader("Authorization") String token, @RequestParam String habitoId){
        return client.calcularStreak(token, habitoId);
    }
}
