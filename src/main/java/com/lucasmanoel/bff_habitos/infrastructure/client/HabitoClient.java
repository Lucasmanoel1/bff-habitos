package com.lucasmanoel.bff_habitos.infrastructure.client;

import com.lucasmanoel.bff_habitos.business.in.HabitosDTORequest;
import com.lucasmanoel.bff_habitos.business.out.CheckinDTOResponse;
import com.lucasmanoel.bff_habitos.business.out.HabitosDTOResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "habito", url = "${habitos.url}")
public interface HabitoClient {

    @PostMapping
    HabitosDTOResponse cadastraHabito(@RequestHeader("Authorization") String token, @RequestBody HabitosDTORequest dto);

    @PatchMapping("/{id}")
    void alterarStatusHabito(@RequestHeader("Authorization") String token, @PathVariable String id,  @RequestParam boolean ativo);

    @DeleteMapping("/{id}")
    void deletaHabito(@RequestHeader("Authorization") String token, @PathVariable String id);

    @PutMapping("/{id}")
    HabitosDTOResponse alteraHabito(@RequestHeader("Authorization") String token, @RequestBody HabitosDTORequest dto, @PathVariable String id);

    @PostMapping("/checkin")
    Integer efetuarCheckin(@RequestHeader("Authorization") String token, @RequestParam String id);

    @GetMapping
    List<CheckinDTOResponse> historicoCheckin(@RequestHeader("Authorization") String token, @RequestParam String habitoId);

    @GetMapping("/streak")
    Integer calcularStreak(@RequestHeader("Authorization") String token, @RequestParam String habitoId);
}
